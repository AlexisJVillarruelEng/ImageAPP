package dev.alexisvillarruel.imageapp.ui.principalscreen.data.network

import dev.alexisvillarruel.imageapp.ui.principalscreen.data.network.response.searchResponse
import dev.alexisvillarruel.imageapp.ui.principalscreen.data.network.response.urlsUnsp
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface dashboardClient {
        @GET("photos/random")
        suspend fun getRandomPhoto(
            @Query("count") count: Int
        ): Response<List<urlsUnsp>>

        @GET("search/photos")
        suspend fun searchPhotos(
            @Query("query") query: String
        ): Response<searchResponse>
}
