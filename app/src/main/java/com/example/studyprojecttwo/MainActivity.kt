package com.example.studyprojecttwo


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
val nawDate = Date()
internal var weathes: ArrayList<DayTemperature> = arrayListOf(
    DayTemperature(
       nawDate, 8,
        DayTemperatureDetails(-2, 9, 6, -3)
    ),
    DayTemperature(
        Date(nawDate.time+24*60*60*1000L), 11,
        DayTemperatureDetails(-1, 10, 7, -2)
    ),
    DayTemperature(
        Date(nawDate.time+2*24*60*60*1000L), 7,
        DayTemperatureDetails(-4, 7, 4, -5)
    ),
    DayTemperature(
        Date(nawDate.time+3*24*60*60*1000L), 9,
        DayTemperatureDetails(-1, 10, 7, -2)
    ),
    DayTemperature(
        Date(nawDate.time+4*24*60*60*1000L), 12,
        DayTemperatureDetails(0, 11, 10, 1)
    ),
    DayTemperature(
        Date(nawDate.time+5*24*60*60*1000L), 13,
        DayTemperatureDetails(-2, 9, 6, -3)
    ),
    DayTemperature(
        Date(nawDate.time+6*24*60*60*1000L), 10,
        DayTemperatureDetails(-2, 9, 6, -3)
    ),
    DayTemperature(
        Date(nawDate.time+7*24*60*60*1000L), 10,
        DayTemperatureDetails(-2, 9, 6, -3)
    ),
    DayTemperature(
        Date(nawDate.time+8*24*60*60*1000L), 10,
        DayTemperatureDetails(-2, 9, 6, -3)
    ),
    DayTemperature(
        Date(nawDate.time+9*24*60*60*1000L), 10,
        DayTemperatureDetails(-2, 9, 6, -3)
    ),
    DayTemperature(
        Date(nawDate.time+10*24*60*60*1000L), 10,
        DayTemperatureDetails(-2, 9, 6, -3)
    )
)
@Composable
fun NavigationScreen() {
    val navigateObject = rememberNavController()
    val model: DayTemperatureDetailsModel = viewModel()
    NavHost(navController = navigateObject, startDestination = "DayTemperatureListScreen") {
        composable("DayTemperatureListScreen") {

            DayTemperatureListScreen(navigateObject,weathes, model)
        }
        composable(
            "HourlyWeatherForecastScreen") {

            DayTemperatureDetailsScreen(navigateObject, model)
        }
    }
}