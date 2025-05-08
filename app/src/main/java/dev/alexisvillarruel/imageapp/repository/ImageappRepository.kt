package dev.alexisvillarruel.imageapp.repository

import dev.alexisvillarruel.imageapp.service.ImageappApiService
import dev.alexisvillarruel.imageapp.service.RetrofitInstance

class ImageappRepository {
    private val imageappApiService: ImageappApiService = RetrofitInstance.api
    // Define your repository methods here


}