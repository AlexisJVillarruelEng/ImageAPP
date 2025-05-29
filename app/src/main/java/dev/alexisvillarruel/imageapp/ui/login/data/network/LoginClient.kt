import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.OAuthProvider
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthManager @Inject constructor(
        private val auth: FirebaseAuth,
        private val firestore: FirebaseFirestore
    ) {

        // Login con Google
        suspend fun signInWithGoogle(idToken: String): FirebaseUser? {
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            return auth.signInWithCredential(credential).await().user?.also {
                saveUserToFirestore(it)
            }
        }

        // Login con Apple
        suspend fun signInWithApple(idToken: String): FirebaseUser? {
            val credential = OAuthProvider.newCredentialBuilder("apple.com")
                .setIdToken(idToken)
                .build()
            return auth.signInWithCredential(credential).await().user?.also {
                saveUserToFirestore(it)
            }
        }

        // Login con Microsoft
        suspend fun signInWithMicrosoft(idToken: String): FirebaseUser? {
            val credential = OAuthProvider.newCredentialBuilder("microsoft.com")
                .setIdToken(idToken)
                .build()
            return auth.signInWithCredential(credential).await().user?.also {
                saveUserToFirestore(it)
            }
        }

        // Registro con email, contraseña y nombre
        suspend fun registerWithEmailPassword(email: String, password: String, name: String): FirebaseUser? {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            val user = result.user ?: return null

            // Actualizar displayName en FirebaseAuth
            val profileUpdates = UserProfileChangeRequest.Builder()
                .setDisplayName(name)
                .build()
            user.updateProfile(profileUpdates).await()

            // Guardar usuario en Firestore con nombre y alias vacío
            saveUserToFirestore(user, name)

            return user
        }

        // Login con email y contraseña
        suspend fun loginWithEmailPassword(email: String, password: String): FirebaseUser? {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            val user = result.user ?: return null

            return user
        }

        // Guardar usuario en Firestore (para proveedores sociales o registro)
        private suspend fun saveUserToFirestore(user: FirebaseUser, name: String? = null) {
            val userDoc = firestore.collection("users").document(user.uid)

            val data = mapOf(
                "name" to (name ?: user.displayName ?: "Sin nombre"),
                "email" to (user.email ?: ""),
                "alias" to "" // alias vacío inicialmente
            )

            userDoc.set(data, SetOptions.merge()).await()
        }

        // Actualizar alias en Firestore
        suspend fun updateAlias(uid: String, alias: String) {
            firestore.collection("users").document(uid)
                .update("alias", alias).await()
        }

        fun getCurrentUser(): FirebaseUser? = auth.currentUser
    }

