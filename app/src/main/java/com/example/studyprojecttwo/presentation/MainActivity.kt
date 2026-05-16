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
import com.example.studyprojecttwo.presentation.dailyWeatherForecast.DailyWeatherForecastScreen
import com.example.studyprojecttwo.presentation.detailedWeatherForecast.DetailedWeatherForecastScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
    NavHost(navController = navigateObject, startDestination = "DailyWeatherForecastScreen") {
        composable("DailyWeatherForecastScreen") {

            DailyWeatherForecastScreen(navigateObject)
        }
        composable(
            "DetailedWeatherForecastScreen/{date}", arguments = listOf(navArgument("date") {
                type =
                    NavType.LongType
            })
        ) { entry ->
            val date = entry.arguments?.getLong("date") ?: 0

            DetailedWeatherForecastScreen(navigateObject,date = date )
        }
    }
}