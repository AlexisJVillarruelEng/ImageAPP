package dev.alexisvillarruel.imageapp.ui.splashscreen.data.network

import dev.alexisvillarruel.imageapp.ui.splashscreen.data.network.response.UnsplashPhoto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SplashClient {

    @GET("photos/random")
    suspend fun getRandomPhoto(
        @Query("query") query: String,
        @Query("orientation") orientation: String,
    ): Response<UnsplashPhoto>


}