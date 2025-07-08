package dev.alexisvillarruel.imageapp.ui.principalscreen.domain

import dev.alexisvillarruel.imageapp.ui.principalscreen.data.DashboardRepository
import dev.alexisvillarruel.imageapp.ui.principalscreen.data.network.response.searchResponse
import javax.inject.Inject

class DashboardUseCase @Inject constructor(
    private val dashboardRepository: DashboardRepository
) {
    suspend operator fun  invoke (count: Int): List<String> {
        return dashboardRepository.getCarrouselPhotos(count)
    }

    suspend  fun Search(query: String): Result<searchResponse> {
        return dashboardRepository.searchPhotos(query)
    }
}