package com.test.assignment.requests

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.assignment.AppExecutors
import com.test.assignment.requests.response.LoginResponse
import com.test.assignment.util.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
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

    private var mlogin: MutableLiveData<Response<LoginResponse>>? = MutableLiveData()

    val loginResponse: LiveData<Response<LoginResponse>>?
        get() = mlogin


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

    fun cancelRequest() {
        if (mCredRunnable != null) {
            mCredRunnable!!.cancelRequest()
        }
    }

    private inner class CredRunnable(val email: String, val password: String) : Runnable {

        private var cancelRequest = false

        override fun run() {
            try {
                getLoginCheck(email, password)?.enqueue(object : Callback<LoginResponse> {
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        mlogin?.postValue(null)
                        cancelRequest()
                    }

                    override fun onResponse(call: Call<LoginResponse>, response: retrofit2.Response<LoginResponse>) {
                        mlogin?.value = response
                    }
                })
                if (cancelRequest) {
                    return
                }
            } catch (e: IOException) {
                e.printStackTrace()
                mlogin?.postValue(null)
            }
        }

        private fun getLoginCheck(username: String, password: String): Call<LoginResponse>? {
            return ServiceGenerator.getApi().loginCheck(
                    Constants.API_KEY,
                    username, password)
        }

        fun cancelRequest() {
            cancelRequest = true
        }
    }
}
