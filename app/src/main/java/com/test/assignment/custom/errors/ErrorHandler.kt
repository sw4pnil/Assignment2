package com.test.assignment.custom.errors

import android.content.Context
import android.view.View
import android.widget.Toast
import com.test.assignment.base.Error
import com.test.assignment.custom.views.IndefiniteSnackbar
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

object ErrorHandler {

    private const val NETWORK_ERROR_MESSAGE =
            "Please check your internet connectivity and try again!"
    private const val EMPTY_RESPONSE = "Server returned empty response."
    const val NO_SUCH_DATA = "Data not found in the database"
    const val UNKNOWN_ERROR = "An unknown error occurred!"

    fun handleError(
            view: View,
            throwable: Error,
            shouldToast: Boolean = false,
            shouldShowSnackBar: Boolean = false,
            refreshAction: () -> Unit = {}
    ) {
        if (shouldShowSnackBar) {
            showSnackBar(view, message = throwable.message, refresh = refreshAction)
        } else {
            if (shouldToast) {
                showLongToast(view.context, throwable.message)
            }
        }
        when (throwable.exception) {
            is IOException -> Timber.e(NETWORK_ERROR_MESSAGE)
            is HttpException -> Timber.e(
                    "HTTP Exception: ${throwable.exception.code()}"
            )
            is NoResponseException -> Timber.e(EMPTY_RESPONSE)
            is NoDataException -> Timber.e(NO_SUCH_DATA)
            else -> Timber.e(throwable.message)
        }
    }

    private fun showSnackBar(view: View, message: String, refresh: () -> Unit = {}) {
        IndefiniteSnackbar.show(view, message, refresh)
    }

    private fun showLongToast(context: Context, message: String) = Toast.makeText(
            context,
            message,
            Toast.LENGTH_LONG
    ).show()


        const val UNABLE_TO_RESOLVE_HOST = "Unable to resolve host"
        const val UNABLE_TODO_OPERATION_WO_INTERNET = "Can't do that operation without an internet connection"
        const val ERROR_CHECK_NETWORK_CONNECTION = "Check network connection."

        const val ERROR_UNKNOWN = "Unknown error"

        fun isNetworkError(msg: String): Boolean{
            when{
                msg.contains(UNABLE_TO_RESOLVE_HOST) -> return true
                else-> return false
            }
        }

}