package com.example.studyprojecttwo.data

class ApiResponse {
    internal suspend fun fetchWeather(): DailyWeatherForecastList {

        val response = RetrofitClient.apiService.getWeather(
            55.4636,
            65.3431,
            "temperature_2m_max",
            "temperature_2m,wind_speed_10m",
            "temperature_2m,wind_speed_10m",
            "GMT+5",
            16,
            "ms",
            "hourly_6"
        )
        println("=== API Response: $response ===")

        var dailyWeatherForecastList = DailyWeatherForecastList()
        dailyWeatherForecastList = dailyWeatherForecastList.copy(dailyWeatherForecastList.getData(response))

        var detailedWeatherForecastList = DetailedWeatherForecastList()
        detailedWeatherForecastList = detailedWeatherForecastList.copy(detailedWeatherForecastList.getData(response))

        return dailyWeatherForecastList
    }
}