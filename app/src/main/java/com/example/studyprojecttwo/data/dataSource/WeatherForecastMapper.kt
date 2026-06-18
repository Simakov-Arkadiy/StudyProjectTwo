package com.example.studyprojecttwo.data.dataSource

import com.example.studyprojecttwo.data.dataSource.dataBase.EntityDailyWeatherForecast
import com.example.studyprojecttwo.data.dataSource.dataBase.EntityDetailedWeatherForecast
import com.example.studyprojecttwo.data.dataSource.dataBase.EntityPrecipitation
import com.example.studyprojecttwo.data.dataSource.dataBase.EntityWeatherInfoAdvanced
import com.example.studyprojecttwo.data.dataSource.dataBase.EntityWeatherInfoShort
import jakarta.inject.Inject
import java.text.SimpleDateFormat
import java.util.Locale

internal class WeatherForecastMapper @Inject constructor() {
    val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    fun mapToEntityDailyWeatherForecast(response: WeatherForecastResponse): List<EntityDailyWeatherForecast> {
        return response.dailyDto.dates.zip(response.dailyDto.averageTemperature)
            .mapNotNull { (date, temperature) ->
                (if (date != null && temperature != null) {
                    EntityDailyWeatherForecast(
                        id = 0L,
                        date = format.parse(date),
                        weatherInfo = EntityWeatherInfoShort(averageTemperature = temperature),
                    )
                } else {
                    null
                })
            }
    }

    fun mapToEntityDetailedWeatherForecast(response: WeatherForecastResponse): List<EntityDetailedWeatherForecast> {
        val weatherInfoAdvancedList =
            response.hourlyDto.averageTemperature.zip(response.hourlyDto.averageWindSpeed)
                .mapNotNull { (temperature, windSpeed) ->
                    if (temperature != null && windSpeed != null) {
                        EntityWeatherInfoAdvanced(
                            averageTemperature = temperature,
                            averageWindSpeed = windSpeed,
                            precipitation = EntityPrecipitation.SNOW
                        )
                    } else {
                        null
                    }
                }


        return response.hourlyDto.dateTimes.mapIndexed { index, date ->
            if (index % 4 == 0 && weatherInfoAdvancedList.size >= (index + 3)) {
                EntityDetailedWeatherForecast(
                    date = format.parse(date),
                    morningForecast = weatherInfoAdvancedList[index],
                    dayForecast = weatherInfoAdvancedList[index + 1],
                    eveningForecast = weatherInfoAdvancedList[index + 2],
                    nightForecast = weatherInfoAdvancedList[index + 3],
                    id = 0L
                )
            } else {
                null
            }
        }.filterNotNull()
    }
}