package dev.alexisvillarruel.imageapp.ui.splashscreen.data

import dev.alexisvillarruel.imageapp.service.firebase.RetrofitInstance
import dev.alexisvillarruel.imageapp.ui.splashscreen.data.network.SplashClient
import dev.alexisvillarruel.imageapp.ui.splashscreen.data.network.response.Urlsplashphoto
import dev.alexisvillarruel.imageapp.ui.splashscreen.data.network.splashService
import jakarta.inject.Inject

class ImageappRepository @Inject constructor(private val api: splashService) {

    suspend fun getRandomPhoto(query: String, orientation: String): String? {
        return api.getRandomPhoto(query, orientation)

    }
}