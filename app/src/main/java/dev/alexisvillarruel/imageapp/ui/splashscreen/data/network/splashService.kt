package dev.alexisvillarruel.imageapp.ui.splashscreen.data.network

import dev.alexisvillarruel.imageapp.service.firebase.RetrofitInstance
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class splashService @Inject constructor( private val splashClient: SplashClient) {

    suspend fun getRandomPhoto(query: String, orientation: String): String? {
        return withContext(Dispatchers.IO) {
            try {
                val response = splashClient.getRandomPhoto(query, orientation)
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        return@withContext body.urls.regular
                    } else {
                        throw Exception("Response body is null")
                    }
                } else {
                    throw Exception("Error: ${response.code()} ${response.message()}")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                throw Exception("Error: ${e.message}")
            }

        }
    }

}