package com.test.assignment.login.ui.login

import android.util.Patterns
import android.view.View
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.assignment.R
import com.test.assignment.login.data.LoginRepository
import com.test.assignment.login.data.Result

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    var EmailAddress: MutableLiveData<String?> = MutableLiveData()
    var Password: MutableLiveData<String?> = MutableLiveData()
    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm
    private var userMutableLiveData: MutableLiveData<LoginResult?>? = null

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult
    private val _data= MutableLiveData<Data>()
    val data: LiveData<Data> = _data


   /* @Bindable
    fun getRememberMe(): Boolean {
        return data.rememberMe
    }

    fun setRememberMe(value: Boolean) {
        // Avoids infinite loops.
        if (dataResult.rememberMe != value) {
            dataResult.rememberMe = value

            // React to the change.
//            saveData()

            // Notify observers of a new value.
           /// notifyPropertyChanged(BR.remember_me)
        }
    }
*/
    fun login(view: View?) {
        // can be launched in a separate asynchronous job
        val result = loginRepository.login(EmailAddress.value!!, Password.value!!)

        if (result is Result.Success) {
           // userMutableLiveData?.setValue(result)
            _loginResult.value = LoginResult(success = LoggedInUserView(displayName = result.data.displayName))
        } else {
            _loginResult.value = LoginResult(error = R.string.login_failed)
        }
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
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
