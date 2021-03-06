package com.test.assignment.repositories

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.test.assignment.DataState
import com.test.assignment.Response
import com.test.assignment.ResponseType
import com.test.assignment.custom.errors.ErrorHandler
import com.test.assignment.custom.errors.ErrorHandler.ERROR_CHECK_NETWORK_CONNECTION
import com.test.assignment.custom.errors.ErrorHandler.ERROR_UNKNOWN
import com.test.assignment.util.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main


abstract class NetworkBoundResource<ResponseObject, ViewStateType>
(
        isNetworkAvailable: Boolean //is there a network connection?
) {

    private val TAG: String = "AppDebug"

    protected val result = MediatorLiveData<DataState<ViewStateType>>()
    protected lateinit var job: CompletableJob
    protected lateinit var coroutineScope: CoroutineScope

    init {
        setJob(initNewJob())
        setValue(DataState.loading(isLoading = true, cachedData = null))

        if (isNetworkAvailable) {
            coroutineScope.launch {

                // simulate a network delay for testing
                delay(Constants.TESTING_NETWORK_DELAY)

                withContext(Main) {

                    // make network call
                    val apiResponse = createCall()
                    result.addSource(apiResponse) { response ->
                        result.removeSource(apiResponse)

                        coroutineScope.launch {
                            handleNetworkCall(response)
                        }
                    }
                }
            }

            GlobalScope.launch(IO) {
                delay(Constants.NETWORK_TIMEOUT)

                if (!job.isCompleted) {
                    Log.e(TAG, "NetworkBoundResource: JOB NETWORK TIMEOUT.")
                    job.cancel(CancellationException(ErrorHandler.UNABLE_TO_RESOLVE_HOST))
                }
            }
        } else {
            onErrorReturn(ErrorHandler.UNABLE_TODO_OPERATION_WO_INTERNET, shouldUseDialog = true, shouldUseToast = false)
        }
    }

    suspend fun handleNetworkCall(response: GenericApiResponse<ResponseObject>?) {
        when (response) {
            is ApiSuccessResponse -> {
                handleApiSuccessResponse(response)
            }
            is ApiErrorResponse -> {
                Log.e(TAG, "NetworkBoundResource: ${response.errorMessage}")
                onErrorReturn(response.errorMessage, true, false)
            }
            is ApiEmptyResponse -> {
                Log.e(TAG, "NetworkBoundResource: Request returned NOTHING (HTTP 204)")
                onErrorReturn("HTTP 204. Returned nothing.", true, false)
            }
        }
    }

    fun onCompleteJob(dataState: DataState<ViewStateType>) {
        GlobalScope.launch(Main) {
            job.complete()
            setValue(dataState)
        }
    }

    private fun setValue(dataState: DataState<ViewStateType>) {
        result.value = dataState
    }

    fun onErrorReturn(errorMessage: String?, shouldUseDialog: Boolean, shouldUseToast: Boolean) {
        var msg = errorMessage
        var useDialog = shouldUseDialog
        var responseType: ResponseType = ResponseType.None()
        if (msg == null) {
            msg = ERROR_UNKNOWN
        } else if (ErrorHandler.isNetworkError(msg)) {
            msg = ERROR_CHECK_NETWORK_CONNECTION
            useDialog = false
        }
        if (shouldUseToast) {
            responseType = ResponseType.Toast()
        }
        if (useDialog) {
            responseType = ResponseType.Dialog()
        }

        onCompleteJob(DataState.error(
                response = Response(
                        message = msg,
                        responseType = responseType
                )
        ))
    }

    @SuppressLint("LogNotTimber")
    @OptIn(InternalCoroutinesApi::class)
    fun initNewJob(): Job {
        Log.d(TAG, "initNewJob: called...")
        job = Job()
        job.invokeOnCompletion(onCancelling = true, invokeImmediately = true, handler = object : CompletionHandler {

            override fun invoke(cause: Throwable?) {
                if (job.isCancelled) {
                    Log.e(TAG, "NetworkBoundResource: Job has been cancelled.")
                    cause?.let {
                        onErrorReturn(it.message, shouldUseDialog = false, shouldUseToast = true)
                    } ?: onErrorReturn(ERROR_UNKNOWN, shouldUseDialog = false, shouldUseToast = true)
                } else if (job.isCompleted) {
                    Log.e(TAG, "NetworkBoundResource: Job has been completed...")
                    // Do nothing. Should be handled already.
                }
            }

        })
        coroutineScope = CoroutineScope(IO + job)
        return job
    }

    fun asLiveData() = result as LiveData<DataState<ViewStateType>>

    abstract suspend fun handleApiSuccessResponse(response: ApiSuccessResponse<ResponseObject>)

    abstract fun createCall(): LiveData<GenericApiResponse<ResponseObject>>

    abstract fun setJob(job: Job)
}


















