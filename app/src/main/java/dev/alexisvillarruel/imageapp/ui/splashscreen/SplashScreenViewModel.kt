package dev.alexisvillarruel.imageapp.ui.splashscreen

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.alexisvillarruel.imageapp.repository.ImageappRepository
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

@HiltViewModel
class SplashScreenViewModel @Inject constructor(  private val repository : ImageappRepository   ) : ViewModel() {
    //private val repository = ImageappRepository()

    private val _url = MutableLiveData<String>("")
    val url: MutableLiveData<String> get() = _url

    init {
        fetchRandomPhoto()
    }

    private fun fetchRandomPhoto() {
        viewModelScope.launch(Dispatchers.IO) {

            val urls = repository.getRandomPhotos("nature", "landscape")
            withContext(Dispatchers.Main) {
                _url.value = urls?.regular
                Log.d("URL", _url.value.toString())
            }
        }
    }
}