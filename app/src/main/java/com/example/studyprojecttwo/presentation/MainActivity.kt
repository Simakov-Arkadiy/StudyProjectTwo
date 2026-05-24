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
        composable(route = "DailyWeatherForecastScreen") {

            DailyWeatherForecastScreen(controller = navigateObject)
        }
        composable(
            route = "DetailedWeatherForecastScreen/{date}",
            arguments = listOf(navArgument(name = "date") {
                type = NavType.StringType
            })
        ) { entry ->
            val date = entry.arguments?.getString("date") ?: "2022-07-01T00:00"

            DetailedWeatherForecastScreen(controller = navigateObject, date = date)
        }
    }
}