package com.example.studyprojecttwo.data


import com.example.studyprojecttwo.R
import com.example.studyprojecttwo.domain.DetailedWeatherForecast
import com.example.studyprojecttwo.domain.Precipitation
import com.example.studyprojecttwo.domain.WeatherInfoAdvanced
import java.util.Date

internal class DetailedWeatherForecastList(

    val list: List<DetailedWeatherForecast> = listOf(
        DetailedWeatherForecast(
            Date(nowTime),
            WeatherInfoAdvanced(2,2, Precipitation.SNOW),
            WeatherInfoAdvanced(2,2, Precipitation.SNOW),
            WeatherInfoAdvanced(2,2, Precipitation.SNOW),
            WeatherInfoAdvanced(2,2, Precipitation.SNOW)
        ),
        DetailedWeatherForecast(
            Date(nowTime + 24 * 60 * 60 * 1000L),
            WeatherInfoAdvanced(3,3, Precipitation.SUNNY),
            WeatherInfoAdvanced(3,3, Precipitation.SUNNY),
            WeatherInfoAdvanced(3,3, Precipitation.SUNNY),
            WeatherInfoAdvanced(3,3, Precipitation.SUNNY)
        ),
        DetailedWeatherForecast(
            Date(nowTime + 2*24 * 60 * 60 * 1000L),
            WeatherInfoAdvanced(4,4, Precipitation.CLOUDY),
            WeatherInfoAdvanced(4,4, Precipitation.CLOUDY),
            WeatherInfoAdvanced(4,4, Precipitation.CLOUDY),
            WeatherInfoAdvanced(4,4, Precipitation.CLOUDY)
        ),
        DetailedWeatherForecast(
            Date(nowTime + 3*24 * 60 * 60 * 1000L),
            WeatherInfoAdvanced(5,5, Precipitation.LIGHT_RAIN),
            WeatherInfoAdvanced(5,5, Precipitation.LIGHT_RAIN),
            WeatherInfoAdvanced(5,5, Precipitation.LIGHT_RAIN),
            WeatherInfoAdvanced(5,5, Precipitation.LIGHT_RAIN)
        ),
        DetailedWeatherForecast(
            Date(nowTime + 4*24 * 60 * 60 * 1000L),
            WeatherInfoAdvanced(6,6, Precipitation.SNOW),
            WeatherInfoAdvanced(6,6, Precipitation.SNOW),
            WeatherInfoAdvanced(6,6, Precipitation.SNOW),
            WeatherInfoAdvanced(6,6, Precipitation.SNOW)
        ),
        DetailedWeatherForecast(
            Date(nowTime + 5*24 * 60 * 60 * 1000L),
            WeatherInfoAdvanced(7,7, Precipitation.SUNNY),
            WeatherInfoAdvanced(7,7, Precipitation.SUNNY),
            WeatherInfoAdvanced(7,7, Precipitation.SUNNY),
            WeatherInfoAdvanced(7,7, Precipitation.SUNNY)
        ),
        DetailedWeatherForecast(
            Date(nowTime + 6*24 * 60 * 60 * 1000L),
            WeatherInfoAdvanced(8,8, Precipitation.CLOUDY),
            WeatherInfoAdvanced(8,8, Precipitation.CLOUDY),
            WeatherInfoAdvanced(8,8, Precipitation.CLOUDY),
            WeatherInfoAdvanced(8,8, Precipitation.CLOUDY)
        ),
        DetailedWeatherForecast(
            Date(nowTime + 7*24 * 60 * 60 * 1000L),
            WeatherInfoAdvanced(9,9, Precipitation.LIGHT_RAIN),
            WeatherInfoAdvanced(9,9, Precipitation.LIGHT_RAIN),
            WeatherInfoAdvanced(9,9, Precipitation.LIGHT_RAIN),
            WeatherInfoAdvanced(9,9, Precipitation.LIGHT_RAIN)
        ),
        DetailedWeatherForecast(
            Date(nowTime + 8*24 * 60 * 60 * 1000L),
            WeatherInfoAdvanced(10,10, Precipitation.SUNNY),
            WeatherInfoAdvanced(10,10, Precipitation.SUNNY),
            WeatherInfoAdvanced(10,10, Precipitation.SUNNY),
            WeatherInfoAdvanced(10,10, Precipitation.SUNNY)
        ),
        DetailedWeatherForecast(
            Date(nowTime + 9*24 * 60 * 60 * 1000L),
            WeatherInfoAdvanced(11,11, Precipitation.SNOW),
            WeatherInfoAdvanced(11,11, Precipitation.SNOW),
            WeatherInfoAdvanced(11,11, Precipitation.SNOW),
            WeatherInfoAdvanced(11,11, Precipitation.SNOW)
        ),
        DetailedWeatherForecast(
            Date(nowTime + 10*24 * 60 * 60 * 1000L),
            WeatherInfoAdvanced(12,12, Precipitation.SNOW),
            WeatherInfoAdvanced(12,12, Precipitation.SNOW),
            WeatherInfoAdvanced(12,12, Precipitation.SNOW),
            WeatherInfoAdvanced(12,12, Precipitation.SNOW)
        ),
        DetailedWeatherForecast(
            Date(nowTime + 11*24 * 60 * 60 * 1000L),
            WeatherInfoAdvanced(13,13, Precipitation.SNOW),
            WeatherInfoAdvanced(13,13, Precipitation.SNOW),
            WeatherInfoAdvanced(13,13, Precipitation.SNOW),
            WeatherInfoAdvanced(13,13, Precipitation.SNOW)
        ),
        DetailedWeatherForecast(
            Date(nowTime + 12*24 * 60 * 60 * 1000L),
            WeatherInfoAdvanced(14,14, Precipitation.SNOW),
            WeatherInfoAdvanced(14,14, Precipitation.SNOW),
            WeatherInfoAdvanced(14,14, Precipitation.SNOW),
            WeatherInfoAdvanced(14,14, Precipitation.SNOW)
        ),
        DetailedWeatherForecast(
            Date(nowTime + 13*24 * 60 * 60 * 1000L),
            WeatherInfoAdvanced(15,15, Precipitation.SNOW),
            WeatherInfoAdvanced(15,15, Precipitation.SNOW),
            WeatherInfoAdvanced(15,15, Precipitation.SNOW),
            WeatherInfoAdvanced(15,15, Precipitation.SNOW)
        ),
        DetailedWeatherForecast(
            Date(nowTime + 14*24 * 60 * 60 * 1000L),
            WeatherInfoAdvanced(16,16, Precipitation.SNOW),
            WeatherInfoAdvanced(16,16, Precipitation.SNOW),
            WeatherInfoAdvanced(16,16, Precipitation.SNOW),
            WeatherInfoAdvanced(16,16, Precipitation.SNOW)
        ),
        DetailedWeatherForecast(
            Date(nowTime + 15*24 * 60 * 60 * 1000L),
            WeatherInfoAdvanced(17,17, Precipitation.SNOW),
            WeatherInfoAdvanced(17,17, Precipitation.SNOW),
            WeatherInfoAdvanced(17,17, Precipitation.SNOW),
            WeatherInfoAdvanced(17,17, Precipitation.SNOW)
        ),
        DetailedWeatherForecast(
            Date(nowTime + 16*24 * 60 * 60 * 1000L),
            WeatherInfoAdvanced(18,18, Precipitation.SNOW),
            WeatherInfoAdvanced(18,18, Precipitation.SNOW),
            WeatherInfoAdvanced(18,18, Precipitation.SNOW),
            WeatherInfoAdvanced(18,18, Precipitation.SNOW)
        ),
        DetailedWeatherForecast(
            Date(nowTime + 17*24 * 60 * 60 * 1000L),
            WeatherInfoAdvanced(19,19, Precipitation.SNOW),
            WeatherInfoAdvanced(19,19, Precipitation.SNOW),
            WeatherInfoAdvanced(19,19, Precipitation.SNOW),
            WeatherInfoAdvanced(19,19, Precipitation.SNOW)
        ),
    )
) {
    fun getDetailedWeatherForecast(date: Long): DetailedWeatherForecast {
        return list.find { it.date.time == date }!!
    }
}