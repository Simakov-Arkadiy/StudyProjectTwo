package com.example.studyprojecttwo.domain

import com.example.studyprojecttwo.data.WeatherForecastRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

internal class ObserveDailyWeatherForecastUseCase @Inject constructor(
    private val repository: WeatherForecastRepository
) {
    suspend fun invoke():Flow<List<DailyWeatherForecast>>{
        return repository.observerDailyWeatherForecast()
    }
}