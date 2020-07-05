package com.test.assignment.requests

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.test.assignment.*
import com.test.assignment.custom.errors.ErrorHandler
import com.test.assignment.models.Country
import com.test.assignment.requests.api.CredentialCheckApi
import com.test.assignment.util.ApiEmptyResponse
import com.test.assignment.util.ApiErrorResponse
import com.test.assignment.util.ApiSuccessResponse
import com.test.assignment.util.Constants
import okhttp3.Call
import okhttp3.Callback
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginApiClient internal constructor() {


    companion object {
        private const val TAG = "LoginApiClient"
        @JvmStatic
        var instance: LoginApiClient? = null
            get() {
                if (field == null) {
                    field = LoginApiClient()
                }
                return field
            }
            private set
    }

    private val mCategory: MutableLiveData<List<Country>?> = MutableLiveData()
    private val mCountryName: MutableLiveData<String?> = MutableLiveData()

    private var mRetrieveCountryRunnable: CredentialCheckRunnable? = null
    var arrayListDetails: ArrayList<Country> = ArrayList()

    private var mCredRunnable: CredRunnable? = null


    fun attemptLogin(email: String, password: String) {
       // return

        if (mCredRunnable != null) {
            mCredRunnable = null
        }
        mCredRunnable = CredRunnable(email, password)
        val handler = AppExecutors.get()?.networkIO()?.submit(mCredRunnable)
        AppExecutors.get()?.networkIO()?.schedule({
            handler?.cancel(true)
        }, Constants.NETWORK_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
    }

    val category: LiveData<List<Country>?>
        get() = mCategory

    val countryName: LiveData<String?>
        get() = mCountryName

    fun countryDetailApi() {
        if (mRetrieveCountryRunnable != null) {
            mRetrieveCountryRunnable = null
        }
        mRetrieveCountryRunnable = CredentialCheckRunnable()
        val handler = AppExecutors.get()?.networkIO()?.submit(mRetrieveCountryRunnable)
        AppExecutors.get()?.networkIO()?.schedule({
            handler?.cancel(true)
        }, Constants.NETWORK_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
    }

    private inner class CredentialCheckRunnable : Runnable {
        private var cancelRequest = false
        override fun run() {
            run(ServiceGenerator.getCountryApiCall())
        }

        private fun run(call: Call) {
            call.enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    //Log.d("Error:",e)
                }

                override fun onResponse(call: Call, response: okhttp3.Response) {
                    val strResponse = response.body()!!.string()
                    //creating json object
                    val jsonContact = JSONObject(strResponse)
                    //creating json array
                    val jsonArrayInfo: JSONArray = jsonContact.getJSONArray("rows")
                    val jsonTitleString: String = jsonContact.getString("title")
                    val size: Int = jsonArrayInfo.length()
                    arrayListDetails = ArrayList()
                    for (i in 0 until size) {
                        val jsonObjectDetail: JSONObject = jsonArrayInfo.getJSONObject(i)
                        val model = Country()
                        model.setImageHref(jsonObjectDetail.getString("imageHref"))
                        model.setTitle(jsonObjectDetail.getString("title"))
                        model.setDescription(jsonObjectDetail.getString("description"))
                        arrayListDetails.add(model)
                    }

                    mCountryName.postValue(jsonTitleString)
                    mCategory.postValue(arrayListDetails)

                }
            })
        }

        fun cancelRequest() {
            cancelRequest = true
        }

    }

    fun cancelRequest() {
        if (mRetrieveCountryRunnable != null) {
            mRetrieveCountryRunnable!!.cancelRequest()
        }
    }

    private inner class CredRunnable(val email: String,val password: String) : Runnable {
        private var cancelRequest = false

        override fun run() {
            run(ServiceGenerator.provideRetrofitBuilder())
        }

        private fun run(call: CredentialCheckApi) {

            call.login(email, password)
                    .switchMap { response ->
                        object : LiveData<DataState<AuthViewState>>() {
                            override fun onActive() {
                                super.onActive()
                                when (response) {
                                    is ApiSuccessResponse -> {
                                        value = DataState.data(
                                                AuthViewState(
                                                        authToken = AuthToken(response.body.code, response.body.message)
                                                ),
                                                response = null
                                        )
                                    }
                                    is ApiErrorResponse -> {
                                        value = DataState.error(
                                                Response(
                                                        message = response.errorMessage,
                                                        responseType = ResponseType.Dialog()
                                                )
                                        )
                                    }
                                    is ApiEmptyResponse -> {
                                        value = DataState.error(
                                                Response(
                                                        message = ErrorHandler.ERROR_UNKNOWN,
                                                        responseType = ResponseType.Dialog()
                                                )
                                        )
                                    }
                                }
                            }
                        }
                    }
        }

        fun cancelRequest() {
            cancelRequest = true
        }

    }

}