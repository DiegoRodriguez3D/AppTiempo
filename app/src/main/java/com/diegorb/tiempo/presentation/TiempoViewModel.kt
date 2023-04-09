package com.diegorb.tiempo.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegorb.tiempo.domain.location.LocationTracker
import com.diegorb.tiempo.domain.repository.TiempoRepository
import com.diegorb.tiempo.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TiempoViewModel @Inject constructor(
    private val repository: TiempoRepository,
    private val locationTracker: LocationTracker
): ViewModel() {
    var state by mutableStateOf(TiempoState())
        private set

    fun loadTiempoInfo(){
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            locationTracker.getCurrentLocation()?.let { location ->
                when(val result = repository.getTiempoData(location.latitude, location.longitude)){
                    is Resource.Exito -> {
                        state = state.copy(
                            tiempoInfo = result.data,
                            isLoading = false,
                            error = null
                        )
                    }

                    is Resource.Error -> {
                        state = state.copy(
                            tiempoInfo = null,
                            isLoading = false,
                            error = result.msg
                        )
                    }
                }
            } ?: kotlin.run {
                state = state.copy(
                    isLoading = false,
                    error = "No se pudo recuperar la ubicación del dispositivo. Asegúrate de activar la ubicación y conceder los permisos necesarios."
                )
            }
        }
    }
}