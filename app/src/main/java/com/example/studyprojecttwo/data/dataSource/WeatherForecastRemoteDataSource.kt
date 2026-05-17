package com.example.studyprojecttwo.data.dataSource

import retrofit2.Retrofit
import jakarta.inject.Inject

internal class WeatherForecastRemoteDataSource @Inject constructor(val weatherForecastService: WeatherForecastService) {
    internal suspend fun fetchWeather(): WeatherForecastResponse {

        val response = weatherForecastService.getWeather(
            latitude = 55.4636,
            longitude = 65.3431,
            daily = "temperature_2m_max",
            hourly = "temperature_2m,wind_speed_10m",
            current = "temperature_2m,wind_speed_10m",
            timezone = "GMT+5",
            forecatDay = 16,
            windspeedunit = "ms",
            temporalresolution = "hourly_6"
        )
        return response
    }
}