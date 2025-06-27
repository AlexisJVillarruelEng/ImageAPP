package dev.alexisvillarruel.imageapp.ui.principalscreen.data

import dev.alexisvillarruel.imageapp.ui.principalscreen.data.network.dashboardService
import jakarta.inject.Inject

class DashboardRepository @Inject constructor(
    private val dashboardService: dashboardService
) {
    suspend fun getCarrouselPhotos(count: Int): List<String> {
        return dashboardService.getcarrouselphotos(count)
    }

}