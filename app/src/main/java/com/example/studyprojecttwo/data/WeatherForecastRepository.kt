package com.example.studyprojecttwo.data

import com.example.studyprojecttwo.data.dataSource.WeatherForecastRemoteDataSource
import com.example.studyprojecttwo.data.dataSource.WeatherForecastMapper
import com.example.studyprojecttwo.data.dataSource.WeatherLocalDataSource
import com.example.studyprojecttwo.domain.DailyWeatherForecast
import com.example.studyprojecttwo.domain.DetailedWeatherForecast
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class WeatherForecastRepository @Inject constructor(
    val mapper: WeatherForecastMapper,
    val weatherForecastRemoteDataSource: WeatherForecastRemoteDataSource,
    var weatherForecastLocalDataSource: WeatherLocalDataSource,
) {
    suspend fun getDetailedWeatherForecast(date: String): Result<DetailedWeatherForecast> {

        val forecast =
            weatherForecastLocalDataSource.getDetailedWeatherForecast()?.find { item ->

                item.date?.substringBefore("T") == date
            }
        if (forecast != null) {
            return forecast.let { Result.success(it) }
        } else {
            return Result.failure(IllegalArgumentException("Прогноз для даты $date не найден"))
        }
    }

    suspend fun getDailyWeatherForecast(): Result<List<DailyWeatherForecast>?> {
        val result = Result.runCatching { weatherForecastRemoteDataSource.getWeatherForecast() }
        result.onSuccess { response ->
            weatherForecastLocalDataSource.setDailyWeatherForecast(
                mapper.mapToDailyWeatherForecast(
                    response = response
                )
            )
            weatherForecastLocalDataSource.setDetailedWeatherForecast(
                mapper.mapToDetailedWeatherForecast(
                    response = response
                )
            )
        }

        return Result.success(weatherForecastLocalDataSource.getDailyWeatherForecast())
    }
}