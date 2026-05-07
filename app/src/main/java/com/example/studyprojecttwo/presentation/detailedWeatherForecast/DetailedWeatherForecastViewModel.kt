package com.example.studyprojecttwo.presentation.detailedWeatherForecast

import androidx.lifecycle.ViewModel
import com.example.studyprojecttwo.R
import com.example.studyprojecttwo.data.DetailedWeatherForecastList
import com.example.studyprojecttwo.domain.DetailedWeatherForecast
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class DetailedWeatherForecastViewModel( date: Long) : ViewModel() {
    private val _items =
        MutableStateFlow(
            DetailedWeatherForecast()
        )
    val items = _items.asStateFlow()

}


