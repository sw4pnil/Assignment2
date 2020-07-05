package com.test.assignment.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.assignment.repositories.LoginRepository
import com.test.assignment.requests.LoginApiClient
import com.test.assignment.requests.ServiceGenerator
import com.test.assignment.requests.api.CredentialCheckApi

class LoginViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(
                    loginRepository = LoginRepository(
                            dataSource = LoginApiClient(
                            )
                    )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}