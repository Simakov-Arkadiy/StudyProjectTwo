package com.example.studyprojecttwo.presentation

import androidx.lifecycle.ViewModel
import com.example.studyprojecttwo.domain.WeatherForecastHourlyPeriod
import com.example.studyprojecttwo.domain.repository.WeatherForecastHourlyPeriodList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Date

internal class WeatherForecastHourlyPeriodViewModel : ViewModel() {
    private val _items =
        MutableStateFlow(WeatherForecastHourlyPeriod(Date(), 0, 0, 0, 0, 0, 0, 0, 0))
    val items = _items.asStateFlow()
    fun getDataForState(date: Date) {
        val foundItem =
            WeatherForecastHourlyPeriodList().list.find { it.date.time == date.time }
        if (foundItem != null) {
            _items.value = foundItem
        }
    }
}


