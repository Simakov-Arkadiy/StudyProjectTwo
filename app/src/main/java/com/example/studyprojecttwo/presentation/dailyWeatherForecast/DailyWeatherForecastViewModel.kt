package com.example.studyprojecttwo.presentation.dailyWeatherForecast

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studyprojecttwo.data.WeatherForecastRepository
import com.example.studyprojecttwo.domain.DailyWeatherForecast
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
internal class DailyWeatherForecastViewModel @Inject constructor(val repository: WeatherForecastRepository) :
    ViewModel() {
    private val _items = MutableStateFlow(listOf<DailyWeatherForecast>())
    val items = _items.asStateFlow()

    init {
        viewModelScope.launch {
            val response = repository.getDailyWeatherForecastLis()
            _items.value = response?: emptyList()
        }
    }
}
