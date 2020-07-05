package com.test.assignment.requests.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginResponse {

    @SerializedName("token")
    @Expose
    private val token: String? = null

    @SerializedName("description")
    @Expose
    private val description: String? = null

    @SerializedName("error")
    @Expose
    private val error: String? = null

    fun token(): String? {
        return token
    }

    fun description(): String? {
        return description
    }

    fun error(): String? {
        return error
    }

    override fun toString(): String {
        return "LoginResponse(token=$token, description=$description, error=$error)"
    }


}