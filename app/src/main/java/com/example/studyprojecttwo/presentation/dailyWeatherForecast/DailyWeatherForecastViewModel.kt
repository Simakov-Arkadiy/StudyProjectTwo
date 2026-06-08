package com.example.studyprojecttwo.presentation.dailyWeatherForecast

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studyprojecttwo.data.WeatherForecastRepository
import com.example.studyprojecttwo.domain.DailyWeatherForecast
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
internal class DailyWeatherForecastViewModel @Inject constructor(
    application: Application,
    val repository: WeatherForecastRepository,
) : ViewModel() {
    private var _items = MutableStateFlow(listOf<DailyWeatherForecast>())
    var items = _items.asStateFlow()

    init {
        viewModelScope.launch {
            items = repository.getDailyWeatherForecast(application).stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )
        }
    }
}
