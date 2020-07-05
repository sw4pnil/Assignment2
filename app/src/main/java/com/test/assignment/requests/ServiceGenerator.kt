package com.test.assignment.requests

import com.test.assignment.requests.api.CredentialCheckApi
import com.test.assignment.util.Constants
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author swapnil tripathi 5 july
 * OkHttp Client used to handle json format
 */
object ServiceGenerator {



    private var retrofitBuilder = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL1)
            .addConverterFactory(GsonConverterFactory.create())

    private val retrofit: Retrofit = retrofitBuilder.build()

    private val api: CredentialCheckApi = retrofit.create(CredentialCheckApi::class.java)

    fun getApi(): CredentialCheckApi {
        return api
    }

    fun getDetailApiCall(newApiBaseUrl: String): Call {
        val apiBaseUrl = "https://hacker-news.firebaseio.com/v0/"
        val newApiBaseUrl = apiBaseUrl + newApiBaseUrl

        val request = Request.Builder()
                .url(newApiBaseUrl)

        val requestCall = request.build()
        return OkHttpClient().newCall(requestCall)
    }
    // No need to instantiate this class.
    private fun ServiceGenerator() {}


}