package com.example.studyprojecttwo.data


import com.example.studyprojecttwo.domain.DetailedWeatherForecast
import com.example.studyprojecttwo.domain.Precipitation
import com.example.studyprojecttwo.domain.WeatherInfoAdvanced
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

internal class DetailedWeatherForecastList {
    companion object {
        var list: List<DetailedWeatherForecast> = listOf(
            DetailedWeatherForecast(
                Date(nowTime),
                WeatherInfoAdvanced(2F, 2F, Precipitation.SNOW),
                WeatherInfoAdvanced(2F, 2F, Precipitation.SNOW),
                WeatherInfoAdvanced(2F, 2F, Precipitation.SNOW),
                WeatherInfoAdvanced(2F, 2F, Precipitation.SNOW)
            ),
            DetailedWeatherForecast(
                Date(nowTime + 24 * 60 * 60 * 1000L),
                WeatherInfoAdvanced(3F, 3F, Precipitation.SUNNY),
                WeatherInfoAdvanced(3F, 3F, Precipitation.SUNNY),
                WeatherInfoAdvanced(3F, 3F, Precipitation.SUNNY),
                WeatherInfoAdvanced(3F, 3F, Precipitation.SUNNY)
            ),
            DetailedWeatherForecast(
                Date(nowTime + 2 * 24 * 60 * 60 * 1000L),
                WeatherInfoAdvanced(4F, 4F, Precipitation.CLOUDY),
                WeatherInfoAdvanced(4F, 4F, Precipitation.CLOUDY),
                WeatherInfoAdvanced(4F, 4F, Precipitation.CLOUDY),
                WeatherInfoAdvanced(4F, 4F, Precipitation.CLOUDY)
            ),
            DetailedWeatherForecast(
                Date(nowTime + 3 * 24 * 60 * 60 * 1000L),
                WeatherInfoAdvanced(5F, 5F, Precipitation.LIGHT_RAIN),
                WeatherInfoAdvanced(5F, 5F, Precipitation.LIGHT_RAIN),
                WeatherInfoAdvanced(5F, 5F, Precipitation.LIGHT_RAIN),
                WeatherInfoAdvanced(5F, 5F, Precipitation.LIGHT_RAIN)
            ),
            DetailedWeatherForecast(
                Date(nowTime + 4 * 24 * 60 * 60 * 1000L),
                WeatherInfoAdvanced(6F, 6F, Precipitation.SNOW),
                WeatherInfoAdvanced(6F, 6F, Precipitation.SNOW),
                WeatherInfoAdvanced(6F, 6F, Precipitation.SNOW),
                WeatherInfoAdvanced(6F, 6F, Precipitation.SNOW)
            ),
            DetailedWeatherForecast(
                Date(nowTime + 5 * 24 * 60 * 60 * 1000L),
                WeatherInfoAdvanced(7F, 7F, Precipitation.SUNNY),
                WeatherInfoAdvanced(7F, 7F, Precipitation.SUNNY),
                WeatherInfoAdvanced(7F, 7F, Precipitation.SUNNY),
                WeatherInfoAdvanced(7F, 7F, Precipitation.SUNNY)
            ),
            DetailedWeatherForecast(
                Date(nowTime + 6 * 24 * 60 * 60 * 1000L),
                WeatherInfoAdvanced(8F, 8F, Precipitation.CLOUDY),
                WeatherInfoAdvanced(8F, 8F, Precipitation.CLOUDY),
                WeatherInfoAdvanced(8F, 8F, Precipitation.CLOUDY),
                WeatherInfoAdvanced(8F, 8F, Precipitation.CLOUDY)
            ),
            DetailedWeatherForecast(
                Date(nowTime + 7 * 24 * 60 * 60 * 1000L),
                WeatherInfoAdvanced(9F, 9F, Precipitation.LIGHT_RAIN),
                WeatherInfoAdvanced(9F, 9F, Precipitation.LIGHT_RAIN),
                WeatherInfoAdvanced(9F, 9F, Precipitation.LIGHT_RAIN),
                WeatherInfoAdvanced(9F, 9F, Precipitation.LIGHT_RAIN)
            ),
            DetailedWeatherForecast(
                Date(nowTime + 8 * 24 * 60 * 60 * 1000L),
                WeatherInfoAdvanced(10F, 10F, Precipitation.SUNNY),
                WeatherInfoAdvanced(10F, 10F, Precipitation.SUNNY),
                WeatherInfoAdvanced(10F, 10F, Precipitation.SUNNY),
                WeatherInfoAdvanced(10F, 10F, Precipitation.SUNNY)
            ),
            DetailedWeatherForecast(
                Date(nowTime + 9 * 24 * 60 * 60 * 1000L),
                WeatherInfoAdvanced(11F, 11F, Precipitation.SNOW),
                WeatherInfoAdvanced(11F, 11F, Precipitation.SNOW),
                WeatherInfoAdvanced(11F, 11F, Precipitation.SNOW),
                WeatherInfoAdvanced(11F, 11F, Precipitation.SNOW)
            ),
            DetailedWeatherForecast(
                Date(nowTime + 10 * 24 * 60 * 60 * 1000L),
                WeatherInfoAdvanced(12F, 12F, Precipitation.SNOW),
                WeatherInfoAdvanced(12F, 12F, Precipitation.SNOW),
                WeatherInfoAdvanced(12F, 12F, Precipitation.SNOW),
                WeatherInfoAdvanced(12F, 12F, Precipitation.SNOW)
            ),
            DetailedWeatherForecast(
                Date(nowTime + 11 * 24 * 60 * 60 * 1000L),
                WeatherInfoAdvanced(13F, 13F, Precipitation.SNOW),
                WeatherInfoAdvanced(13F, 13F, Precipitation.SNOW),
                WeatherInfoAdvanced(13F, 13F, Precipitation.SNOW),
                WeatherInfoAdvanced(13F, 13F, Precipitation.SNOW)
            ),
            DetailedWeatherForecast(
                Date(nowTime + 12 * 24 * 60 * 60 * 1000L),
                WeatherInfoAdvanced(14F, 14F, Precipitation.SNOW),
                WeatherInfoAdvanced(14F, 14F, Precipitation.SNOW),
                WeatherInfoAdvanced(14F, 14F, Precipitation.SNOW),
                WeatherInfoAdvanced(14F, 14F, Precipitation.SNOW)
            ),
            DetailedWeatherForecast(
                Date(nowTime + 13 * 24 * 60 * 60 * 1000L),
                WeatherInfoAdvanced(15F, 15F, Precipitation.SNOW),
                WeatherInfoAdvanced(15F, 15F, Precipitation.SNOW),
                WeatherInfoAdvanced(15F, 15F, Precipitation.SNOW),
                WeatherInfoAdvanced(15F, 15F, Precipitation.SNOW)
            ),
            DetailedWeatherForecast(
                Date(nowTime + 14 * 24 * 60 * 60 * 1000L),
                WeatherInfoAdvanced(16F, 16F, Precipitation.SNOW),
                WeatherInfoAdvanced(16F, 16F, Precipitation.SNOW),
                WeatherInfoAdvanced(16F, 16F, Precipitation.SNOW),
                WeatherInfoAdvanced(16F, 16F, Precipitation.SNOW)
            ),
            DetailedWeatherForecast(
                Date(nowTime + 15 * 24 * 60 * 60 * 1000L),
                WeatherInfoAdvanced(17F, 17F, Precipitation.SNOW),
                WeatherInfoAdvanced(17F, 17F, Precipitation.SNOW),
                WeatherInfoAdvanced(17F, 17F, Precipitation.SNOW),
                WeatherInfoAdvanced(17F, 17F, Precipitation.SNOW)
            ),
            DetailedWeatherForecast(
                Date(nowTime + 16 * 24 * 60 * 60 * 1000L),
                WeatherInfoAdvanced(18F, 18F, Precipitation.SNOW),
                WeatherInfoAdvanced(18F, 18F, Precipitation.SNOW),
                WeatherInfoAdvanced(18F, 18F, Precipitation.SNOW),
                WeatherInfoAdvanced(18F, 18F, Precipitation.SNOW)
            ),
            DetailedWeatherForecast(
                Date(nowTime + 17 * 24 * 60 * 60 * 1000L),
                WeatherInfoAdvanced(19F, 19F, Precipitation.SNOW),
                WeatherInfoAdvanced(19F, 19F, Precipitation.SNOW),
                WeatherInfoAdvanced(19F, 19F, Precipitation.SNOW),
                WeatherInfoAdvanced(19F, 19F, Precipitation.SNOW)
            ),
        )

        fun getDetailedWeatherForecast(date: Long): DetailedWeatherForecast {

            val formatter = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
            val searchDateStr = formatter.format(Date(date))

            return list.find { formatter.format(it.date) == searchDateStr }!!
        }
    }
    fun initList(response: APIModel) {

        val detailedWeatherForecastList: MutableList<DetailedWeatherForecast> = mutableListOf()
        val weatherInfoAdvancedList: MutableList<WeatherInfoAdvanced> = mutableListOf()

        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.getDefault())
        var counter: Int = 0


        for (item in 0..(response.hourly.time.size - 1)) {
            counter += 1

            val date: String
            val temperature: Float
            val windSpeed: Float

            if (response.hourly.temperatureM[item] == null) {
                temperature = 0F
            } else {
                temperature = response.hourly.temperatureM[item]
            }

            if (response.hourly.windSpeed[item] == null) {
                windSpeed = 0F
            } else {
                windSpeed = response.hourly.windSpeed[item]
            }

            val weatherInfoAdvanced =
                WeatherInfoAdvanced(temperature, windSpeed, Precipitation.SNOW)

            weatherInfoAdvancedList.add(weatherInfoAdvanced)

            if (weatherInfoAdvancedList.size == 4) {
                if (response.hourly.time[item] == null) {
                    date = "2022-07-01T00:00"
                } else {
                    date = response.hourly.time[counter - 3]
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
        list = detailedWeatherForecastList
    }
}