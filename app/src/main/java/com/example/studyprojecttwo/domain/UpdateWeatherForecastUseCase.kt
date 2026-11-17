package com.example.studyprojecttwo.domain

import com.example.studyprojecttwo.data.WeatherForecastRepository
import jakarta.inject.Inject

internal class UpdateWeatherForecastUseCase @Inject constructor(
    val repository: WeatherForecastRepository
) {
    suspend fun invoke(){
        repository.updateWeatherForecast()
    }
}