package dev.alexisvillarruel.imageapp.ui.login.ui

import AuthManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//
//@HiltViewModel
//class LoginViewModel @Inject constructor(
//    private val authManager: AuthManager
//) : ViewModel() {
//    private val _user = MutableStateFlow<FirebaseUser?>(null)
//    val user: StateFlow<FirebaseUser?> = _user
//
//    private val _aliasSaved = MutableStateFlow(false)
//    val aliasSaved: StateFlow<Boolean> = _aliasSaved
//
//    private val _error = MutableStateFlow<String?>(null)
//    val error: StateFlow<String?> = _error
//
//    fun loginWithProvider(provider: String, idToken: String) {
//        viewModelScope.launch {
//            try {
//                val user = when (provider) {
//                    "google" -> authManager.signInWithGoogle(idToken)
//                    "apple" -> authManager.signInWithApple(idToken)
//                    "microsoft" -> authManager.signInWithMicrosoft(idToken)
//                    else -> null
//                }
//                _user.value = user
//                _error.value = null
//            } catch (e: Exception) {
//                _error.value = e.message
//            }
//        }
//    }
//
//    fun registerWithEmail(email: String, password: String, name: String) {
//        viewModelScope.launch {
//            try {
//                val user = authManager.registerWithEmailPassword(email, password, name)
//                _user.value = user
//                _error.value = null
//            } catch (e: Exception) {
//                _error.value = e.message
//            }
//        }
//    }
//
//    fun loginWithEmail(email: String, password: String) {
//        viewModelScope.launch {
//            try {
//                val user = authManager.loginWithEmailPassword(email, password)
//                _user.value = user
//                _error.value = null
//            } catch (e: Exception) {
//                _error.value = e.message
//            }
//        }
//    }
//
//    fun saveAlias(alias: String) {
//        viewModelScope.launch {
//            authManager.getCurrentUser()?.let {
//                authManager.updateAlias(it.uid, alias)
//                _aliasSaved.value = true
//            }
//        }
//    }
//
//}