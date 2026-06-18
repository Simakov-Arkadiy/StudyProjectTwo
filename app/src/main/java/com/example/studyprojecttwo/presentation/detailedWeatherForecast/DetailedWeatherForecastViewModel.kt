package com.example.studyprojecttwo.presentation.detailedWeatherForecast

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studyprojecttwo.data.WeatherForecastRepository
import com.example.studyprojecttwo.domain.DetailedWeatherForecast
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale

@HiltViewModel
internal class DetailedWeatherForecastViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    val repository: WeatherForecastRepository,
) : ViewModel() {

    private val _item = MutableStateFlow<DetailedWeatherForecast?>(null)
    val item = _item.asStateFlow()
    val date: String = savedStateHandle["date"] ?: "2022-07-01"
    val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    init {
        viewModelScope.launch {
            val result = repository.getDetailedWeatherForecast(formatter.parse(date))
            result.onSuccess { value -> _item.emit(value) }
        }
    }
}


