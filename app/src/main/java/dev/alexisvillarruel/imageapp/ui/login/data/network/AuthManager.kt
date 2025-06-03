package dev.alexisvillarruel.imageapp.ui.login.data.network

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.OAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthManager @Inject constructor(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) {

    suspend fun registerWithEmailPassword(email: String, password: String, name: String): FirebaseUser {
        val result = auth.createUserWithEmailAndPassword(email, password).await()
        val user = result.user ?: throw Exception("Registro fallido")

        val userData = mapOf(
            "name" to name,
            "alias" to "",
            "email" to email
        )
        firestore.collection("users").document(user.uid).set(userData).await()
        return user
    }

    suspend fun loginWithEmailPassword(email: String, password: String): FirebaseUser {
        val result = auth.signInWithEmailAndPassword(email, password).await()
        return result.user ?: throw Exception("Login fallido")
    }

    suspend fun signInWithGoogle(idToken: String): FirebaseUser {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        val result = auth.signInWithCredential(credential).await()
        return result.user ?: throw Exception("Login con Google fallido")
    }

    suspend fun signInWithApple(idToken: String): FirebaseUser {
        val credential = OAuthProvider.newCredentialBuilder("apple.com")
            .setIdToken(idToken)
            .build()
        val result = auth.signInWithCredential(credential).await()
        return result.user ?: throw Exception("Login con Apple fallido")
    }

    suspend fun signInWithMicrosoft(idToken: String): FirebaseUser {
        val credential = OAuthProvider.newCredentialBuilder("microsoft.com")
            .setIdToken(idToken)
            .build()
        val result = auth.signInWithCredential(credential).await()
        return result.user ?: throw Exception("Login con Microsoft fallido")
    }

    suspend fun updateAlias(userId: String, alias: String) {
        firestore.collection("users").document(userId)
            .update("alias", alias).await()
    }

    fun getCurrentUser(): FirebaseUser? = auth.currentUser
}
