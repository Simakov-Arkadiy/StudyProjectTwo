package com.example.studyprojecttwo.data

class APIResponse {
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

        val dailyWeatherForecastList = DailyWeatherForecastList()
        dailyWeatherForecastList.initList(response)

        val detailedWeatherForecastList = DetailedWeatherForecastList()
        detailedWeatherForecastList.initList(response)

        return dailyWeatherForecastList
    }
}