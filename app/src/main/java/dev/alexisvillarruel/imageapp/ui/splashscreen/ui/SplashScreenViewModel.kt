package dev.alexisvillarruel.imageapp.ui.splashscreen.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.alexisvillarruel.imageapp.ui.splashscreen.data.ImageappRepository
import dev.alexisvillarruel.imageapp.ui.splashscreen.domain.SplashUseCase
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class SplashScreenViewModel @Inject constructor(  private val splashUseCase: SplashUseCase) : ViewModel() {


    private val _url = MutableStateFlow("")
    val url: StateFlow<String> get() = _url

    init {
        fetchRandomPhoto()
    }

    private fun fetchRandomPhoto() {
        viewModelScope.launch(Dispatchers.IO) {

            val urls = splashUseCase("nature", "landscape")
            withContext(Dispatchers.Main) {
                _url.value = urls?: ""
                Log.d("URL", _url.value.toString())
            }
        }
    }
}