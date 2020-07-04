package com.test.assignment.requests

import com.test.assignment.util.Constants
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request

/**
 * @author swapnil-tml on 26-06-2020.
 * OkHttp Client used to handle json format
 */
object ServiceGenerator {
    private val request1 = Request.Builder()
            .url(Constants.BASE_URL)
    private val requestCall1 = request1.build()
    private val client1 = OkHttpClient().newCall(requestCall1)
    fun getCountryApiCall(): Call {
        return client1
    }



}