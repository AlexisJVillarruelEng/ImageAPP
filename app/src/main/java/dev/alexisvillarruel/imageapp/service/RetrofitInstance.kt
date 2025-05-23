package dev.alexisvillarruel.imageapp.service

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.alexisvillarruel.imageapp.ui.splashscreen.data.network.SplashClient
import jakarta.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class RetrofitInstance {


    private val baseURL = "https://api.unsplash.com/"
    private val APIKEY="Z8TttGF5-S2zB0D85_yNMCAl8n666BRTtNlN2qbHnjw"
    private val client = OkHttpClient.Builder().addInterceptor(AuthInterceptor(APIKEY)).build() // con authinterceptor

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
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