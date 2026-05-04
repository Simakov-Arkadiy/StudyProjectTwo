package com.example.studyprojecttwo.data


import com.example.studyprojecttwo.R
import com.example.studyprojecttwo.domain.DayWeatherForecast
import com.example.studyprojecttwo.domain.DetailedWeatherForecast
import com.example.studyprojecttwo.domain.EveningWeatherForecast
import com.example.studyprojecttwo.domain.MorningWeatherForecast
import com.example.studyprojecttwo.domain.NightWeatherForecast

class DetailedWeatherForecastList(

    val list: List<DetailedWeatherForecast> = listOf(
        DetailedWeatherForecast(
            MorningWeatherForecast(3, 7, R.drawable.cloudy),
            DayWeatherForecast(3, 6, R.drawable.snow),
            EveningWeatherForecast(3, 5, R.drawable.lightrain),
            NightWeatherForecast(3, 0, R.drawable.sunny),
            0
        ),
        DetailedWeatherForecast(
            MorningWeatherForecast(6, 2, R.drawable.cloudy),
            DayWeatherForecast(5, 1, R.drawable.snow),
            EveningWeatherForecast(4, 0, R.drawable.lightrain),
            NightWeatherForecast(3, 1, R.drawable.sunny),
            1
        ),
        DetailedWeatherForecast(
            MorningWeatherForecast(7, 3, R.drawable.cloudy),
            DayWeatherForecast(7, 2, R.drawable.snow),
            EveningWeatherForecast(7, 1, R.drawable.lightrain),
            NightWeatherForecast(7, 2, R.drawable.sunny),
            2
        ),
        DetailedWeatherForecast(
            MorningWeatherForecast(6, 5, R.drawable.cloudy),
            DayWeatherForecast(6, 6, R.drawable.snow),
            EveningWeatherForecast(6, 4, R.drawable.lightrain),
            NightWeatherForecast(6, 7, R.drawable.sunny),
            3
        ),
        DetailedWeatherForecast(
            MorningWeatherForecast(5, 5, R.drawable.cloudy),
            DayWeatherForecast(5, 4, R.drawable.snow),
            EveningWeatherForecast(5, 6, R.drawable.lightrain),
            NightWeatherForecast(5, 3, R.drawable.sunny),
            4
        ),
        DetailedWeatherForecast(
            MorningWeatherForecast(8, 8, R.drawable.cloudy),
            DayWeatherForecast(8, 7, R.drawable.snow),
            EveningWeatherForecast(8, 9, R.drawable.lightrain),
            NightWeatherForecast(8, 5, R.drawable.sunny),
            5
        ),
        DetailedWeatherForecast(
            MorningWeatherForecast(-5, 4, R.drawable.cloudy),
            DayWeatherForecast(-5, 3, R.drawable.snow),
            EveningWeatherForecast(-4, 2, R.drawable.lightrain),
            NightWeatherForecast(-3, 9, R.drawable.sunny),
            6
        ),
        DetailedWeatherForecast(
            MorningWeatherForecast(-6, 7, R.drawable.cloudy),
            DayWeatherForecast(-5, 8, R.drawable.snow),
            EveningWeatherForecast(4, 9, R.drawable.lightrain),
            NightWeatherForecast(3, 5, R.drawable.sunny),
            7
        ),
        DetailedWeatherForecast(
            MorningWeatherForecast(3, 7, R.drawable.cloudy),
            DayWeatherForecast(3, 6, R.drawable.snow),
            EveningWeatherForecast(3, 5, R.drawable.lightrain),
            NightWeatherForecast(3, 0, R.drawable.sunny),
            8
        ),
        DetailedWeatherForecast(
            MorningWeatherForecast(0, 2, R.drawable.cloudy),
            DayWeatherForecast(0, 3, R.drawable.snow),
            EveningWeatherForecast(0, 4, R.drawable.lightrain),
            NightWeatherForecast(0, 9, R.drawable.sunny),
            9
        ),
        DetailedWeatherForecast(
            MorningWeatherForecast(8, 5, R.drawable.cloudy),
            DayWeatherForecast(8, 6, R.drawable.snow),
            EveningWeatherForecast(-8, 7, R.drawable.lightrain),
            NightWeatherForecast(-8, 8, R.drawable.sunny),
            10
        ),
        DetailedWeatherForecast(
            MorningWeatherForecast(5, 2, R.drawable.cloudy),
            DayWeatherForecast(-5, 3, R.drawable.snow),
            EveningWeatherForecast(5, 4, R.drawable.lightrain),
            NightWeatherForecast(-3, 2, R.drawable.sunny),
            11
        ),
        DetailedWeatherForecast(
            MorningWeatherForecast(6, 3, R.drawable.cloudy),
            DayWeatherForecast(5, 4, R.drawable.snow),
            EveningWeatherForecast(4, 3, R.drawable.lightrain),
            NightWeatherForecast(3, 4, R.drawable.sunny),
            12
        ),
        DetailedWeatherForecast(
            MorningWeatherForecast(8, 5, R.drawable.cloudy),
            DayWeatherForecast(7, 5, R.drawable.snow),
            EveningWeatherForecast(6, 5, R.drawable.lightrain),
            NightWeatherForecast(6, 5, R.drawable.sunny),
            13
        ),
        DetailedWeatherForecast(
            MorningWeatherForecast(6, 4, R.drawable.cloudy),
            DayWeatherForecast(6, 4, R.drawable.snow),
            EveningWeatherForecast(7, 0, R.drawable.lightrain),
            NightWeatherForecast(8, 0, R.drawable.sunny),
            14
        ),
        DetailedWeatherForecast(
            MorningWeatherForecast(3, 0, R.drawable.cloudy),
            DayWeatherForecast(2, 0, R.drawable.snow),
            EveningWeatherForecast(2, 0, R.drawable.lightrain),
            NightWeatherForecast(2, 0, R.drawable.sunny),
            15
        ),
        DetailedWeatherForecast(
            MorningWeatherForecast(10, 2, R.drawable.cloudy),
            DayWeatherForecast(10, 4, R.drawable.snow),
            EveningWeatherForecast(10, 6, R.drawable.lightrain),
            NightWeatherForecast(0, 8, R.drawable.sunny),
            16
        ),
        DetailedWeatherForecast(
            MorningWeatherForecast(9, 1, R.drawable.cloudy),
            DayWeatherForecast(9, 3, R.drawable.snow),
            EveningWeatherForecast(9, 5, R.drawable.lightrain),
            NightWeatherForecast(9, 7, R.drawable.sunny),
            17
        ),
    )
) {
    fun getDetailedWeatherForecast(id: Int): DetailedWeatherForecast {
        return list.find { it.id == id }!!
    }
}