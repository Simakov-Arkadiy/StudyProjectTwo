package com.example.studyprojecttwo.presentation

import androidx.lifecycle.ViewModel
import com.example.studyprojecttwo.domain.WeatherForecastDailyPeriod
import com.example.studyprojecttwo.domain.repository.WeatherForecastDailyPeriodList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class WeatherForecastDailyPeriodViewModel : ViewModel() {
    private val _items = MutableStateFlow(listOf<WeatherForecastDailyPeriod>())
    val items = _items.asStateFlow()

    init {
        _items.value = WeatherForecastDailyPeriodList().list
    }
}
