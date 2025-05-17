package dev.alexisvillarruel.imageapp.service

import dev.alexisvillarruel.imageapp.model.UnsplashPhoto
import dev.alexisvillarruel.imageapp.model.Urlsplashphoto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageappApiService {

    @GET("photos/random")
    suspend fun getRandomPhoto(
        @Query("query") query: String,
        @Query("orientation") orientation: String,
    ): Response<UnsplashPhoto>

}