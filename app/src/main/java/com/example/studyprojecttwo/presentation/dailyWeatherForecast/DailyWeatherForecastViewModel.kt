package com.example.studyprojecttwo.presentation.dailyWeatherForecast

import androidx.lifecycle.ViewModel
import com.example.studyprojecttwo.domain.DailyWeatherForecast
import com.example.studyprojecttwo.data.DailyWeatherForecastList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


internal class DailyWeatherForecastViewModel : ViewModel() {
    private val _items = MutableStateFlow(listOf<DailyWeatherForecast>())
    val items = _items.asStateFlow()

    init {
        _items.value = DailyWeatherForecastList().list
    }
}
