package dev.alexisvillarruel.imageapp.service

import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val baseURL = "https://api.unsplash.com/"
    private val APIKEY="Z8TttGF5-S2zB0D85_yNMCAl8n666BRTtNlN2qbHnjw"
    private val client = OkHttpClient.Builder().addInterceptor(AuthInterceptor(APIKEY)).build()
    private val retrofit by lazy {
        retrofit2.Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
    val api: ImageappApiService by lazy {
        retrofit.create(ImageappApiService::class.java)
    }

}