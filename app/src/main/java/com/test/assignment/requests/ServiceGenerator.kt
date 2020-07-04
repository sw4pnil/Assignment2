package com.test.assignment.requests

import com.google.gson.Gson
import com.test.assignment.requests.api.CredentialCheckApi
import com.test.assignment.util.Constants
import com.test.assignment.util.LiveDataCallAdapter
import com.test.assignment.util.LiveDataCallAdapterFactory
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author swapnil-tml on 26-06-2020.
 * OkHttp Client used to handle json format
 */
object ServiceGenerator {
    private val request = Request.Builder()
            .url(Constants.BASE_URL)
    private val requestCall = request.build()
    private val client = OkHttpClient().newCall(requestCall)
    fun getCountryApiCall(): Call {
        return client
    }


    fun provideRetrofitBuilder(gsonBuilder: Gson): Retrofit.Builder{
        return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL1)
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
    }


}