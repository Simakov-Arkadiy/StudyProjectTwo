package com.example.studyprojecttwo.domain.repository


import com.example.studyprojecttwo.domain.WeatherForecastHourlyPeriod
import java.util.Date

class WeatherForecastHourlyPeriodList(
    val list: List<WeatherForecastHourlyPeriod> = listOf(
        WeatherForecastHourlyPeriod(MyTime().nowTime, -8, -6, -5, -4, 10, 10, 10, 10),
        WeatherForecastHourlyPeriod(
            Date(MyTime().nowTime.time + 24 * 60 * 60 * 1000L),
            -5,
            -4,
            -3,
            -2,
            15,
            15,
            15,
            15
        ),
        WeatherForecastHourlyPeriod(
            Date(MyTime().nowTime.time + 2 * 24 * 60 * 60 * 1000L),
            -7,
            -6,
            -5,
            -4,
            9,
            9,
            9,
            9
        ),
        WeatherForecastHourlyPeriod(
            Date(MyTime().nowTime.time + 3 * 24 * 60 * 60 * 1000L),
            -2,
            -1,
            0,
            1,
            2,
            8,
            8,
            8
        ),
        WeatherForecastHourlyPeriod(
            Date(MyTime().nowTime.time + 4 * 24 * 60 * 60 * 1000L),
            6,
            7,
            8,
            9,
            11,
            11,
            11,
            11
        ),
        WeatherForecastHourlyPeriod(
            Date(MyTime().nowTime.time + 5 * 24 * 60 * 60 * 1000L),
            11,
            12,
            13,
            14,
            8,
            8,
            8,
            8
        ),
        WeatherForecastHourlyPeriod(
            Date(MyTime().nowTime.time + 6 * 24 * 60 * 60 * 1000L),
            10,
            11,
            12,
            13,
            12,
            12,
            12,
            12
        ),
        WeatherForecastHourlyPeriod(
            Date(MyTime().nowTime.time + 7 * 24 * 60 * 60 * 1000L),
            -3,
            -2,
            -1,
            0,
            15,
            15,
            15,
            15
        ),
        WeatherForecastHourlyPeriod(
            Date(MyTime().nowTime.time + 8 * 24 * 60 * 60 * 1000L),
            -2,
            -1,
            0,
            1,
            3,
            3,
            3,
            3
        ),
        WeatherForecastHourlyPeriod(
            Date(MyTime().nowTime.time + 9 * 24 * 60 * 60 * 1000L),
            -1,
            0,
            1,
            2,
            2,
            2,
            2,
            2
        ),
        WeatherForecastHourlyPeriod(
            Date(MyTime().nowTime.time + 10 * 24 * 60 * 60 * 1000L),
            1,
            2,
            3,
            4,
            4,
            4,
            4,
            4
        ),
        WeatherForecastHourlyPeriod(
            Date(MyTime().nowTime.time + 11 * 24 * 60 * 60 * 1000L),
            5,
            6,
            7,
            8,
            8,
            8,
            8,
            8
        ),
        WeatherForecastHourlyPeriod(
            Date(MyTime().nowTime.time + 12 * 24 * 60 * 60 * 1000L),
            4,
            5,
            6,
            7,
            7,
            7,
            7,
            7
        ),
        WeatherForecastHourlyPeriod(
            Date(MyTime().nowTime.time + 13 * 24 * 60 * 60 * 1000L),
            8,
            9,
            10,
            11,
            11,
            11,
            11,
            11
        ),
        WeatherForecastHourlyPeriod(
            Date(MyTime().nowTime.time + 14 * 24 * 60 * 60 * 1000L),
            -1,
            1,
            2,
            3,
            3,
            3,
            3,
            3
        ),
        WeatherForecastHourlyPeriod(
            Date(MyTime().nowTime.time + 15 * 24 * 60 * 60 * 1000L),
            -3,
            -2,
            -1,
            0,
            0,
            0,
            0,
            0
        ),
        WeatherForecastHourlyPeriod(
            Date(MyTime().nowTime.time + 16 * 24 * 60 * 60 * 1000L),
            -11,
            -10,
            -9,
            -8,
            5,
            5,
            5,
            5
        ),
        WeatherForecastHourlyPeriod(
            Date(MyTime().nowTime.time + 17 * 24 * 60 * 60 * 1000L),
            -10,
            -9,
            -8,
            -7,
            3,
            3,
            3,
            3
        ),
    )
) {
}