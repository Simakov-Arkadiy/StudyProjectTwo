package com.example.studyprojecttwo.data.dataSource

import com.example.studyprojecttwo.domain.DailyWeatherForecast
import com.example.studyprojecttwo.domain.DetailedWeatherForecast
import com.example.studyprojecttwo.domain.Precipitation
import com.example.studyprojecttwo.domain.WeatherInfoAdvanced
import com.example.studyprojecttwo.domain.WeatherInfoShort
import jakarta.inject.Inject
import java.text.SimpleDateFormat
import java.util.Locale

internal class WeatherForecastMapper @Inject constructor() {
    fun responseMappingDailyWeatherForecast(response: WeatherForecastResponse): MutableList<DailyWeatherForecast> {

        val dailyWeatherForecastList: MutableList<DailyWeatherForecast> = mutableListOf()
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        for (day in 0..(response.dailyDto.time.size - 1)) {

            val date: String
            val temperature: Float

            if (response.dailyDto.time[day] == null) {
                date = "2022-07-01"
            } else {
                date = response.dailyDto.time[day]
            }

            if (response.dailyDto.temperatureM[day] == null) {
                temperature = 0F
            } else {
                temperature = response.dailyDto.temperatureM[day]
            }

            val dailyWeatherForecast = DailyWeatherForecast(
                format.parse(date),
                WeatherInfoShort(temperature)
            )

            dailyWeatherForecastList.add(dailyWeatherForecast)
        }
        return dailyWeatherForecastList
    }

    fun responseMappingDetailedWeatherForecast(response: WeatherForecastResponse): MutableList<DetailedWeatherForecast> {

        val detailedWeatherForecastList: MutableList<DetailedWeatherForecast> = mutableListOf()
        val weatherInfoAdvancedList: MutableList<WeatherInfoAdvanced> = mutableListOf()
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.getDefault())
        var counter: Int = 0

        for (day in 0..(response.hourlyDto.time.size - 1)) {
            counter += 1

            val date: String
            val temperature: Float
            val windSpeed: Float

            if (response.hourlyDto.temperatureM[day] == null) {
                temperature = 0F
            } else {
                temperature = response.hourlyDto.temperatureM[day]
            }

            if (response.hourlyDto.windSpeed[day] == null) {
                windSpeed = 0F
            } else {
                windSpeed = response.hourlyDto.windSpeed[day]
            }

            val weatherInfoAdvanced =
                WeatherInfoAdvanced(temperature, windSpeed, Precipitation.SNOW)

            weatherInfoAdvancedList.add(weatherInfoAdvanced)

            if (weatherInfoAdvancedList.size == 4) {
                if (response.hourlyDto.time[day] == null) {
                    date = "2022-07-01T00:00"
                } else {
                    date = response.hourlyDto.time[counter - 3]
                }

                val detailedWeatherForecast = DetailedWeatherForecast(
                    format.parse(date),
                    weatherInfoAdvancedList[0],
                    weatherInfoAdvancedList[1],
                    weatherInfoAdvancedList[2],
                    weatherInfoAdvancedList[3]
                )
                detailedWeatherForecastList.add(detailedWeatherForecast)
                weatherInfoAdvancedList.clear()
            }


        }
        return detailedWeatherForecastList
    }
}