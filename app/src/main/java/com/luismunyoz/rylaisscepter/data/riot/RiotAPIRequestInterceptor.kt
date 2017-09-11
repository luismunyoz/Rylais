package com.luismunyoz.rylaisscepter.data.riot

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by llco on 11/09/2017.
 */
class RiotAPIRequestInterceptor(val apiKey: String): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val url = request.url()

        val newRequest = request.newBuilder()
                .url(url)
                .addHeader("x-riot-token", apiKey)
                .build()

        return chain.proceed(newRequest)
    }

}