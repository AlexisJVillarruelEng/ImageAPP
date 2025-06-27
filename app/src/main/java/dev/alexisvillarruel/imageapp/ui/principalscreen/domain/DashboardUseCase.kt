package dev.alexisvillarruel.imageapp.ui.principalscreen.domain

import dev.alexisvillarruel.imageapp.ui.principalscreen.data.DashboardRepository
import javax.inject.Inject

class DashboardUseCase @Inject constructor(
    private val dashboardRepository: DashboardRepository
) {
    suspend operator fun  invoke (count: Int): List<String> {
        return dashboardRepository.getCarrouselPhotos(count)
    }
}