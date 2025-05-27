package dev.alexisvillarruel.imageapp.service.APInet

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val apikey: String): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val originalrequest =request.url

        val newurl= originalrequest.newBuilder()
            .addQueryParameter("client_id", apikey)
            .build()
        val newrequest = request.newBuilder()
            .url(newurl)
            .build()
        return chain.proceed(newrequest)
    }
}