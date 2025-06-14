package dev.alexisvillarruel.imageapp.ui.login.data.network



import dev.alexisvillarruel.imageapp.ui.login.data.network.response.LoginResponse
import javax.inject.Inject

class FirebaseLoginClient @Inject constructor(
    private val authManager: AuthManager
) : LoginClient {

    override suspend fun loginWithEmail(email: String, password: String): LoginResponse? {
        val user = authManager.loginWithEmailPassword(email, password)
        return LoginResponse(user.uid, user.email.toString())
    }

    override suspend fun registerWithEmail(email: String, password: String, name: String, alias: String): LoginResponse? {
        val user = authManager.registerWithEmailPassword(email, password, name)
        authManager.updateAlias(user.uid, alias)
        return LoginResponse(user.uid, user.email.toString())
    }

}
