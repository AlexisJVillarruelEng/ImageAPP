package dev.alexisvillarruel.imageapp.ui.principalscreen.ui

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.alexisvillarruel.imageapp.ui.principalscreen.domain.DashboardUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class homeScreenViewModel @Inject constructor(
    private val dashboardUseCase: DashboardUseCase
) : ViewModel() {

    private val _carrouselPhotos = MutableStateFlow<List<String>>(emptyList())
    val carrouselPhotos: StateFlow<List<String>> get() = _carrouselPhotos

     fun carruselfotos(){
        viewModelScope.launch(Dispatchers.IO) {

            val urls = dashboardUseCase((5..10).random())
            withContext(Dispatchers.Main) {
                _carrouselPhotos.value = urls
                Log.d("URL", _carrouselPhotos.value.toString())
            }
        }
    }
}