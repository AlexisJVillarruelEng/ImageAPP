package dev.alexisvillarruel.imageapp.ui.login.data.network

import dev.alexisvillarruel.imageapp.ui.login.data.network.response.LoginResponse

interface LoginClient {
    suspend fun loginWithEmail(email: String, password: String): LoginResponse?
    suspend fun registerWithEmail(email: String, password: String, name: String, alias: String): LoginResponse?


}