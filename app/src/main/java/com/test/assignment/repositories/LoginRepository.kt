package com.test.assignment.repositories

import androidx.lifecycle.LiveData
import com.test.assignment.models.LoggedInUser
import com.test.assignment.requests.LoginApiClient
import com.test.assignment.requests.response.LoginResponse
import retrofit2.Response

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository() {
    private val mLoginApiClient: LoginApiClient? = LoginApiClient.instance

    // in-memory cache of the loggedInUser object
    var user: LoggedInUser? = null
        private set

    val isLogin: LiveData<Response<LoginResponse>>?
        get() = mLoginApiClient?.loginResponse

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
    }

    fun attemptLogin(email: String, password: String) {
        return mLoginApiClient!!.attemptLogin(email, password)
    }


    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    companion object {
        var instance: LoginRepository? = null
            get() {
                if (field == null) {
                    field = LoginRepository()
                }
                return field
            }
            private set
    }
}