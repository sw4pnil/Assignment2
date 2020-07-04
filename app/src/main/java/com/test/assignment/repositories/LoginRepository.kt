package com.test.assignment.repositories

import androidx.lifecycle.LiveData
import com.test.assignment.AuthViewState
import com.test.assignment.DataState
import com.test.assignment.Response
import com.test.assignment.ResponseType
import com.test.assignment.custom.errors.ErrorHandler.ERROR_UNKNOWN
import com.test.assignment.models.LoggedInUser
import com.test.assignment.requests.api.CredentialCheckApi
import com.test.assignment.util.ApiErrorResponse
import com.test.assignment.util.ApiSuccessResponse
import androidx.lifecycle.switchMap
import com.test.assignment.util.ApiEmptyResponse

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository(val openApiAuthService: CredentialCheckApi) {

    // in-memory cache of the loggedInUser object
    var user: LoggedInUser? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
    }

    fun attemptLogin(email: String, password: String): LiveData<DataState<AuthViewState>> {
        return openApiAuthService.login(email, password)
                .switchMap { response ->
                    object: LiveData<DataState<AuthViewState>>(){
                        override fun onActive() {
                            super.onActive()
                            when(response){
                                is ApiSuccessResponse ->{
                                    value = DataState.data(
                                            AuthViewState(
                                                    authToken = AuthToken(response.body.pk, response.body.token)
                                            ),
                                            response = null
                                    )
                                }
                                is ApiErrorResponse ->{
                                    value = DataState.error(
                                            Response(
                                                    message = response.errorMessage,
                                                    responseType = ResponseType.Dialog()
                                            )
                                    )
                                }
                                is ApiEmptyResponse ->{
                                    value = DataState.error(
                                            Response(
                                                    message = ERROR_UNKNOWN,
                                                    responseType = ResponseType.Dialog()
                                            )
                                    )
                                }
                            }
                        }
                    }
                }
    }


    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }
}