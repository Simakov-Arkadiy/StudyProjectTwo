package com.example.studyprojecttwo.data

import android.app.Application
import com.example.studyprojecttwo.data.dataSource.GetDetailedWeatherForecastUseCase
import com.example.studyprojecttwo.data.dataSource.ObserveDailyWeatherForecastUseCase
import com.example.studyprojecttwo.data.dataSource.StartPeriodicUpdateWeatherForecastUseCase
import com.example.studyprojecttwo.domain.DailyWeatherForecast
import com.example.studyprojecttwo.domain.DetailedWeatherForecast
import kotlinx.coroutines.flow.Flow
import java.util.Date
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
internal class WeatherForecastRepository @Inject constructor(
    val startPeriodicUpdateWeatherForecastUseCase: StartPeriodicUpdateWeatherForecastUseCase,
    val observeDailyWeatherForecastUseCase: ObserveDailyWeatherForecastUseCase,
    val getDetailedWeatherForecastUseCase: GetDetailedWeatherForecastUseCase,
) {
    suspend fun getDetailedWeatherForecast(date: Date): Result<DetailedWeatherForecast> {
        return getDetailedWeatherForecastUseCase.invoke(date)
    }

    suspend fun getDailyWeatherForecast(application: Application): Flow<List<DailyWeatherForecast>> {
        startPeriodicUpdateWeatherForecastUseCase.invoke(application)
        return observeDailyWeatherForecastUseCase.invoke()
    }
}