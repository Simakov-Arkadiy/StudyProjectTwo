package com.example.studyprojecttwo.presentation.detailedWeatherForecast

import androidx.lifecycle.ViewModel
import com.example.studyprojecttwo.R
import com.example.studyprojecttwo.data.DetailedWeatherForecastList
import com.example.studyprojecttwo.domain.DayWeatherForecast
import com.example.studyprojecttwo.domain.DetailedWeatherForecast
import com.example.studyprojecttwo.domain.EveningWeatherForecast
import com.example.studyprojecttwo.domain.MorningWeatherForecast
import com.example.studyprojecttwo.domain.NightWeatherForecast
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class DetailedWeatherForecastViewModel : ViewModel() {
    private val _items =
        MutableStateFlow(
            DetailedWeatherForecast(
                MorningWeatherForecast(0, 0, R.drawable.snow),
                DayWeatherForecast(0, 0, R.drawable.snow),
                EveningWeatherForecast(0, 0, R.drawable.snow),
                NightWeatherForecast(0, 0, R.drawable.snow),
                0
            )
        )
    val items = _items.asStateFlow()

    fun searchWeatherForecast(id: Int) {
        val weatherForecastHourlyPeriodList = DetailedWeatherForecastList()
        _items.value = weatherForecastHourlyPeriodList.getDetailedWeatherForecast(id)
    }
}


