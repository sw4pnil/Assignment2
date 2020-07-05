package com.test.assignment.viewmodels

import android.util.Patterns
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.assignment.R
import com.test.assignment.login.data.Data
import com.test.assignment.login.data.LoginFormState
import com.test.assignment.repositories.LoginRepository
import com.test.assignment.requests.response.LoginResponse
import retrofit2.Response

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val mDetailRepository: LoginRepository? = LoginRepository.instance

    var EmailAddress: MutableLiveData<String?> = MutableLiveData()
    var Password: MutableLiveData<String?> = MutableLiveData()
    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _data = MutableLiveData<Data>()
    val data: LiveData<Data> = _data

    val loginResult: LiveData<Response<LoginResponse>>?
        get() = mDetailRepository?.isLogin

    fun login(view: View?) {
        // can be launched in a separate asynchronous job
        if (!EmailAddress.value.isNullOrEmpty() && !Password.value.isNullOrEmpty()) {
            loginRepository.attemptLogin(EmailAddress.value!!, Password.value!!)
        }
    }

    fun loginDataChanged() {
        if (!isUserNameValid(EmailAddress.value.toString())) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(Password.value.toString())) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }


    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}
