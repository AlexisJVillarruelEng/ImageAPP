package dev.alexisvillarruel.imageapp.ui.principalscreen.data.network

import android.util.Log
import dev.alexisvillarruel.imageapp.ui.principalscreen.data.network.response.Item
import dev.alexisvillarruel.imageapp.ui.principalscreen.data.network.response.searchResponse
import dev.alexisvillarruel.imageapp.ui.principalscreen.data.network.response.urlsUnsp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class dashboardService @Inject constructor(
    private val dashboardClient: dashboardClient
) {
    suspend fun getcarrouselphotos(count: Int): List<String> {
        return withContext(Dispatchers.IO){
            try {
                val response = dashboardClient.getRandomPhoto(count)
                if (response.isSuccessful) {
                    val body = response.body()?: emptyList<urlsUnsp>() // Assuming the response body is a list of 'urls' objects
                    Log.d("Response", body.toString())
                    if (body != null) {
                        return@withContext body.map { it.urls.regular } // Assuming 'urls' has a 'regular' property
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


        suspend fun searchPhotos(query: String): Result<searchResponse> {
            val response = dashboardClient.searchPhotos(query)
            if (response.isSuccessful) {
                val body = response.body()
                Log.d("Response", body.toString())
                return if (body != null) {
                    Result.success(body)
                } else {
                    Result.failure(Exception("Response body is null"))
                }
            } else {
                return Result.failure(Exception("Error: ${response.code()} ${response.message()}"))
            }


        }
}