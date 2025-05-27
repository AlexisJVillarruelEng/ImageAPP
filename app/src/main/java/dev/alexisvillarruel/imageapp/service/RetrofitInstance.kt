package dev.alexisvillarruel.imageapp.service

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.alexisvillarruel.imageapp.ui.splashscreen.data.network.SplashClient

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitInstance {


    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
         val baseURL = "https://api.unsplash.com/"
         val APIKEY="Z8TttGF5-S2zB0D85_yNMCAl8n666BRTtNlN2qbHnjw"
         val client = OkHttpClient.Builder().addInterceptor(AuthInterceptor(APIKEY)).build() // con authinterceptor
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideSplashClient(retrofit: Retrofit): SplashClient {   //llama a la interfaz
        return retrofit.create(SplashClient::class.java)
    }

}