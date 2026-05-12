package com.example.studyprojecttwo.presentation.dailyWeatherForecast

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studyprojecttwo.data.ApiResponse
import com.example.studyprojecttwo.domain.DailyWeatherForecast
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


internal class DailyWeatherForecastViewModel : ViewModel() {
    private val _items = MutableStateFlow(listOf<DailyWeatherForecast>())
    val items = _items.asStateFlow()

    val api = ApiResponse()

    init {
        viewModelScope.launch{
            val listWeather = api.fetchWeather()
            _items.value = listWeather.list
        }
    }
}
