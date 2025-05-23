package dev.alexisvillarruel.imageapp.ui.splashscreen.domain

import dev.alexisvillarruel.imageapp.ui.splashscreen.data.ImageappRepository
import javax.inject.Inject

class SplashUseCase @Inject constructor( private val repository: ImageappRepository) {

    suspend operator fun invoke(query: String, orientation: String): String? {
        return repository.getRandomPhoto(query, orientation)
    }

}