package com.example.studyprojecttwo.data

import com.example.studyprojecttwo.domain.DailyWeatherForecast
import com.example.studyprojecttwo.domain.WeatherInfoShort
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
internal data class DailyWeatherForecastList(

    var list: List<DailyWeatherForecast> = listOf(
        DailyWeatherForecast(Date(nowTime), WeatherInfoShort(-8F)),
        DailyWeatherForecast(Date(nowTime + 24 * 60 * 60 * 1000L), WeatherInfoShort(-5F)),
        DailyWeatherForecast(Date(nowTime + 2 * 24 * 60 * 60 * 1000L), WeatherInfoShort(-7F)),
        DailyWeatherForecast(Date(nowTime + 3 * 24 * 60 * 60 * 1000L), WeatherInfoShort(-2F)),
        DailyWeatherForecast(Date(nowTime + 4 * 24 * 60 * 60 * 1000L), WeatherInfoShort(6F)),
        DailyWeatherForecast(Date(nowTime + 5 * 24 * 60 * 60 * 1000L), WeatherInfoShort(11F)),
        DailyWeatherForecast(Date(nowTime + 6 * 24 * 60 * 60 * 1000L), WeatherInfoShort(10F)),
        DailyWeatherForecast(Date(nowTime + 7 * 24 * 60 * 60 * 1000L), WeatherInfoShort(-3F)),
        DailyWeatherForecast(Date(nowTime + 8 * 24 * 60 * 60 * 1000L), WeatherInfoShort(-2F)),
        DailyWeatherForecast(Date(nowTime + 9 * 24 * 60 * 60 * 1000L), WeatherInfoShort(-1F)),
        DailyWeatherForecast(Date(nowTime + 10 * 24 * 60 * 60 * 1000L), WeatherInfoShort(1F)),
        DailyWeatherForecast(Date(nowTime + 11 * 24 * 60 * 60 * 1000L), WeatherInfoShort(5F)),
        DailyWeatherForecast(Date(nowTime + 12 * 24 * 60 * 60 * 1000L), WeatherInfoShort(4F)),
        DailyWeatherForecast(Date(nowTime + 13 * 24 * 60 * 60 * 1000L), WeatherInfoShort(8F)),
        DailyWeatherForecast(Date(nowTime + 14 * 24 * 60 * 60 * 1000L), WeatherInfoShort(-1F)),
        DailyWeatherForecast(Date(nowTime + 15 * 24 * 60 * 60 * 1000L), WeatherInfoShort(-3F)),
        DailyWeatherForecast(Date(nowTime + 16 * 24 * 60 * 60 * 1000L), WeatherInfoShort(-11F)),
        DailyWeatherForecast(Date(nowTime + 17 * 24 * 60 * 60 * 1000L), WeatherInfoShort(-10F)),
    )
) {
    fun initList(response: APIModel) {

        val dailyWeatherForecastList: MutableList<DailyWeatherForecast> = mutableListOf()
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        for (item in 0..(response.daily.time.size - 1)) {

            val date: String
            val temperature: Float

            if (response.daily.time[item] == null) {
                date = "2022-07-01"
            } else {
                date = response.daily.time[item]
            }

            if (response.daily.temperatureM[item] == null) {
                temperature = 0F
            } else {
                temperature = response.daily.temperatureM[item]
            }

            val dailyWeatherForecast = DailyWeatherForecast(
                format.parse(date),
                WeatherInfoShort(temperature)
            )

            dailyWeatherForecastList.add(dailyWeatherForecast)

        }
        list = dailyWeatherForecastList
    }
}
val nowTime = System.currentTimeMillis()