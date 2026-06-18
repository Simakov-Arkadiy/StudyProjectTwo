package com.example.studyprojecttwo.domain

import android.app.Application
import com.example.studyprojecttwo.data.WeatherForecastRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

internal class StartPeriodicUpdateWeatherForecastUseCase @Inject constructor(
    val repository: WeatherForecastRepository,
    val updateWeatherForecastUseCase: UpdateWeatherForecastUseCase,
) {
    suspend fun invoke(application: Application) {
        repository.startPeriodicUpdateWeatherForecast(application)
        updateWeatherForecastUseCase.invoke()
    }
}