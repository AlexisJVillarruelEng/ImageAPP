package dev.alexisvillarruel.imageapp.repository

import dev.alexisvillarruel.imageapp.model.UnsplashPhoto
import dev.alexisvillarruel.imageapp.model.Urlsplashphoto
import dev.alexisvillarruel.imageapp.service.ImageappApiService
import dev.alexisvillarruel.imageapp.service.RetrofitInstance
import retrofit2.Response

class ImageappRepository {
    private val imageappApiService: ImageappApiService = RetrofitInstance.api

    suspend fun getRandomPhotos(query: String, orientation: String): Urlsplashphoto?{
        return try {
            val response = imageappApiService.getRandomPhoto(query, orientation)
            if (response.isSuccessful) {
                val body = response.body()?:throw Exception("Response body is null")
                if (body != null) {
                    return body.urls
                } else {
                    throw Exception("Response body is null")
                }
            } else {
                throw Exception("Error: ${response.code()} ${response.message()}")
            }
        } catch (e: Exception) {
           e.printStackTrace()
            null
        }
    }

}