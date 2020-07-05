package com.test.assignment.requests.api

import com.test.assignment.requests.response.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface CredentialCheckApi {

    // CHECK CRED
    @POST("login")
    @FormUrlEncoded
    fun loginCheck(
            @Header("x-api-key") privilege_key: String,
            @Field("username") email: String,
            @Field("password") password: String
    ): Call<LoginResponse>

}