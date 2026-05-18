package com.example.studyprojecttwo.presentation.detailedWeatherForecast

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studyprojecttwo.data.WeatherForecastRepository
import com.example.studyprojecttwo.domain.DetailedWeatherForecast
import com.example.studyprojecttwo.domain.Precipitation
import com.example.studyprojecttwo.domain.WeatherInfoAdvanced
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Date

@HiltViewModel
internal class DetailedWeatherForecastViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    val repository: WeatherForecastRepository,
) : ViewModel() {
    private val _item =
        MutableStateFlow(
            DetailedWeatherForecast(
                "2022-07-01",
                WeatherInfoAdvanced(0F, 0F, Precipitation.SNOW),
                WeatherInfoAdvanced(0F, 0F, Precipitation.SNOW),
                WeatherInfoAdvanced(0F, 0F, Precipitation.SNOW),
                WeatherInfoAdvanced(0F, 0F, Precipitation.SNOW)
            )
        )
    val item = _item.asStateFlow()
    val date: String = savedStateHandle["date"] ?: "2022-07-01"

    init {
        viewModelScope.launch {
            val result = repository.getDetailedWeatherForecast(date)
            result.onSuccess { value -> _item.value = value }
        }
    }
}


