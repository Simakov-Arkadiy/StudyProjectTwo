package com.example.studyprojecttwo.presentation.dailyWeatherForecast

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studyprojecttwo.data.ApiResponse
import com.example.studyprojecttwo.data.Repository
import com.example.studyprojecttwo.data.WeatherLocalDataSource
import com.example.studyprojecttwo.domain.DailyWeatherForecast
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


internal class DailyWeatherForecastViewModel : ViewModel() {
    private val _items = MutableStateFlow(listOf<DailyWeatherForecast>())
    val items = _items.asStateFlow()
    val dataWeather = WeatherLocalDataSource()

    init {
        viewModelScope.launch {
            val newDataWeather = dataWeather.getDataSource()
            Repository.heshDataSource = newDataWeather
            _items.value = newDataWeather.dailyWeatherForecastList
        }
    }
}
