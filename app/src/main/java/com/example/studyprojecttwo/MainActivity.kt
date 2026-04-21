package com.example.studyprojecttwo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavType
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationScreen()
        }
    }
}
// TODO: val
var weathes: ArrayList<DayTemperature> = arrayListOf(
    DayTemperature(
        "16.04.2026", R.string.thursday , 8,
        DayTemperatureDetails(-2, 9, 6, -3)
    ),
    DayTemperature(
        "17.04.2026", R.string.friday, 11,
        DayTemperatureDetails(-1, 10, 7, -2)
    ),
    DayTemperature(
        "18.04.2026", R.string.saturday, 7,
        DayTemperatureDetails(-4, 7, 4, -5)
    ),
    DayTemperature(
        "19.04.2026", R.string.sunday, 9,
        DayTemperatureDetails(-1, 10, 7, -2)
    ),
    DayTemperature(
        "20.04.2026", R.string.monday, 12,
        DayTemperatureDetails(0, 11, 10, 1)
    ),
    DayTemperature(
        "21.04.2026", R.string.tuesday, 13,
        DayTemperatureDetails(-2, 9, 6, -3)
    ),
    DayTemperature(
        "22.04.2026", R.string.wednesday, 10,
        DayTemperatureDetails(-2, 9, 6, -3)
    ),
    DayTemperature(
        "23.04.2026", R.string.thursday, 10,
        DayTemperatureDetails(-2, 9, 6, -3)
    ),
    DayTemperature(
        "24.04.2026", R.string.friday, 10,
        DayTemperatureDetails(-2, 9, 6, -3)
    ),
    DayTemperature(
        "25.04.2026", R.string.saturday, 10,
        DayTemperatureDetails(-2, 9, 6, -3)
    ),
    DayTemperature(
        "26.04.2026", R.string.sunday, 10,
        DayTemperatureDetails(-2, 9, 6, -3)
    )
)
@Composable
fun NavigationScreen() {
    val navigateObject = rememberNavController()
    NavHost(navController = navigateObject, startDestination = "WeatherForecastScreen") {
        composable("WeatherForecastScreen") {
            DayTemperatureListScreen(navigateObject,weathes)
        }
        composable(
            "HourlyWeatherForecastScreen/{morning}/{day}/{evening}/{night}", arguments = listOf(
                navArgument("morning") { type = NavType.IntType },
                navArgument("day") { type = NavType.IntType },
                navArgument("evening") { type = NavType.IntType },
                navArgument("night") { type = NavType.IntType })
        ) { entry ->
            // TODO: если не пришел какой-то параметр - выведи тост об ошибке
            val morning = entry.arguments?.getInt("morning")
            val day = entry.arguments?.getInt("day")
            val evening = entry.arguments?.getInt("evening")
            val night = entry.arguments?.getInt("night")

            HourlyWeatherForecastScreen(navigateObject, morning, day, evening, night)
        }
    }
}