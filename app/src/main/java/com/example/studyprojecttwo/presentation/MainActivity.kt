package com.example.studyprojecttwo.presentation


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import java.util.Date


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationScreen()
        }
    }
}

@Composable
fun NavigationScreen() {
    val navigateObject = rememberNavController()
    NavHost(navController = navigateObject, startDestination = "WeatherForecastDailyPeriodScreen") {
        composable("WeatherForecastDailyPeriodScreen") {

            WeatherForecastDailyPeriodScreen(navigateObject)
        }
        composable(
            "WeatherForecastHourlyPeriodScreen/{date}", arguments = listOf(navArgument("date") {
                type =
                    NavType.LongType
            })
        ) { entry ->
            val date = Date(entry.arguments?.getLong("date") ?: System.currentTimeMillis())


            WeatherForecastHourlyPeriodScreen(navigateObject, date = date)
        }
    }
}