package com.test.assignment.requests.api

import androidx.lifecycle.LiveData
import com.test.assignment.requests.response.LoginResponse
import com.test.assignment.util.GenericApiResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface CredentialCheckApi {

    // CHECK CRED
    @POST("login")
    @FormUrlEncoded
    fun login(
            @Field("user_id") email: String,
            @Field("password") password: String
    ): LiveData<GenericApiResponse<LoginResponse>>
}