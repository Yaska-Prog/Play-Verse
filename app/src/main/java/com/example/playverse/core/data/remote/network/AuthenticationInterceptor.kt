package com.example.playverse.core.data.remote.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .addHeader("key", "09106fd37e844773a754c15059fa50e4")
            .build()
        return chain.proceed(newRequest)
    }
}