package com.example.studyprojecttwo.domain

import com.example.studyprojecttwo.data.WeatherForecastRepository
import jakarta.inject.Inject
import java.util.Date

internal class GetDetailedWeatherForecastUseCase @Inject constructor(
    val repository: WeatherForecastRepository
) {
    suspend fun invoke(date: Date){
        repository.getDetailedWeatherForecast(date)
    }
}