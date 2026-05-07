package com.example.studyprojecttwo.presentation


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.studyprojecttwo.presentation.dailyWeatherForecast.DailyWeatherForecastScreen
import com.example.studyprojecttwo.presentation.detailedWeatherForecast.DetailedWeatherForecastScreen
import com.example.studyprojecttwo.presentation.detailedWeatherForecast.DetailedWeatherForecastViewModel


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
                    NavType.IntType
            })
        ) { entry ->
            val date = entry.arguments?.getLong("date") ?: 0
            val dsgg = DetailedWeatherForecastViewModel()

            DetailedWeatherForecastScreen(navigateObject, viewModel()  ,date = date )
        }
    }
}