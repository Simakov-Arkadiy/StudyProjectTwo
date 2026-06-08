package com.example.studyprojecttwo.data.dataSource

import com.example.studyprojecttwo.data.dataSource.dataBase.WeatherForecastDataBase
import com.example.studyprojecttwo.domain.DetailedWeatherForecast
import com.example.studyprojecttwo.domain.Precipitation
import com.example.studyprojecttwo.domain.WeatherInfoAdvanced
import jakarta.inject.Inject
import java.util.Date

internal class GetDetailedWeatherForecastUseCase @Inject constructor(
    val dataBase: WeatherForecastDataBase,
) {
    suspend fun invoke(date: Date): Result<DetailedWeatherForecast> {
        val forecast = dataBase.detailedWeatherForecastDao().getByDate(date)
        if (forecast != null) {
            return forecast.let {
                Result.success(
                    DetailedWeatherForecast(
                        it.date,
                        WeatherInfoAdvanced(
                            it.morningForecast.averageTemperature,
                            it.morningForecast.averageWindSpeed,
                            Precipitation.valueOf(it.morningForecast.precipitation.name)
                        ),
                        WeatherInfoAdvanced(
                            it.dayForecast.averageTemperature,
                            it.dayForecast.averageWindSpeed,
                            Precipitation.valueOf(it.dayForecast.precipitation.name)
                        ),
                        WeatherInfoAdvanced(
                            it.eveningForecast.averageTemperature,
                            it.eveningForecast.averageWindSpeed,
                            Precipitation.valueOf(it.eveningForecast.precipitation.name)
                        ),
                        WeatherInfoAdvanced(
                            it.nightForecast.averageTemperature,
                            it.nightForecast.averageWindSpeed,
                            Precipitation.valueOf(it.nightForecast.precipitation.name)
                        )
                    )
                )
            }
        } else {
            return Result.failure(IllegalArgumentException("Прогноз для даты $date не найден"))
        }
    }
}