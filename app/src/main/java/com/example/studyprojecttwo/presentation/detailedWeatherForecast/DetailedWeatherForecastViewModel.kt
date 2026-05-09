package com.example.studyprojecttwo.presentation.detailedWeatherForecast

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.studyprojecttwo.data.DetailedWeatherForecastList
import com.example.studyprojecttwo.domain.DetailedWeatherForecast
import com.example.studyprojecttwo.domain.Precipitation
import com.example.studyprojecttwo.domain.WeatherInfoAdvanced
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Date

@HiltViewModel
internal class DetailedWeatherForecastViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _items =
        MutableStateFlow(
            DetailedWeatherForecast(
                Date(0),
                WeatherInfoAdvanced(0, 0, Precipitation.SNOW),
                WeatherInfoAdvanced(0, 0, Precipitation.SNOW),
                WeatherInfoAdvanced(0, 0, Precipitation.SNOW),
                WeatherInfoAdvanced(0, 0, Precipitation.SNOW)
            )
        )
    val items = _items.asStateFlow()

    val date: Long = savedStateHandle["date"] ?: 0

    init {
        _items.value = DetailedWeatherForecastList.getDetailedWeatherForecast(date)
    }
}


