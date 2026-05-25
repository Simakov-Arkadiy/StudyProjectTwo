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
    val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    fun mapToDailyWeatherForecast(response: WeatherForecastResponse): List<DailyWeatherForecast> {
        return response.dailyDto.dates.zip(response.dailyDto.averageTemperature)
            .mapNotNull { (date, temperature) ->
                if (date != null && temperature != null) {
                    DailyWeatherForecast(
                        date = format.parse(date),
                        weatherInfo = WeatherInfoShort(averageTemperature = temperature),
                    )
                } else {
                    null
                }
            }
    }

    fun mapToDetailedWeatherForecast(response: WeatherForecastResponse): List<DetailedWeatherForecast> {
        val weatherInfoAdvancedList =
            response.hourlyDto.averageTemperature.zip(response.hourlyDto.averageWindSpeed)
                .mapNotNull { (temperature, windSpeed) ->
                    if (temperature != null && windSpeed != null) {
                        WeatherInfoAdvanced(
                            averageTemperature = temperature,
                            averageWindSpeed = windSpeed,
                            precipitation = Precipitation.SNOW
                        )
                    } else {
                        null
                    }
                }


        return response.hourlyDto.dateTimes.mapIndexed { index, date ->
            if (index % 4 == 0 && weatherInfoAdvancedList.size >= (index + 3)) {
                DetailedWeatherForecast(
                    date = date,
                    morningForecast = weatherInfoAdvancedList[index],
                    dayForecast = weatherInfoAdvancedList[index + 1],
                    eveningForecast = weatherInfoAdvancedList[index + 2],
                    nightForecast = weatherInfoAdvancedList[index + 3],
                )
            } else {
                null
            }
        }.filterNotNull()
    }
}