package dev.alexisvillarruel.imageapp.ui.principalscreen.data

import dev.alexisvillarruel.imageapp.ui.principalscreen.data.network.dashboardService
import dev.alexisvillarruel.imageapp.ui.principalscreen.data.network.response.searchResponse
import jakarta.inject.Inject

class DashboardRepository @Inject constructor(
    private val dashboardService: dashboardService
) {
    suspend fun getCarrouselPhotos(count: Int): List<String> {
        return dashboardService.getcarrouselphotos(count)
    }

    suspend fun searchPhotos(query: String): Result<searchResponse>{
        return dashboardService.searchPhotos(query)
    }

}