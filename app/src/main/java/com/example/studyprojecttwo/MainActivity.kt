package com.example.studyprojecttwo



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.activity.compose.BackHandler



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                NavigationScreen()
        }
    }
}
var weathes : ArrayList<WeatherForecastForDay> = arrayListOf(WeatherForecastForDay("16.04.2026","thursday", 8,
    HourlyWeatherForecast(-2,9,6,-3)),
    WeatherForecastForDay("17.04.2026","friday", 11,
        HourlyWeatherForecast(-1,10,7,-2)),
    WeatherForecastForDay("18.04.2026","saturday", 7,
        HourlyWeatherForecast(-4,7,4,-5)),
    WeatherForecastForDay("19.04.2026","sunday", 9,
        HourlyWeatherForecast(-1,10,7,-2)),
    WeatherForecastForDay("20.04.2026","monday", 12,
        HourlyWeatherForecast(0,11,10,1)),
    WeatherForecastForDay("21.04.2026","tuesday", 13,
        HourlyWeatherForecast(-2,9,6,-3)),
    WeatherForecastForDay("22.04.2026","wednesday", 10,
        HourlyWeatherForecast(-2,9,6,-3)))
@Composable
fun WeatherForecastScreen(controller: NavHostController){
    Column(verticalArrangement = Arrangement.spacedBy(30.dp) ,modifier = Modifier.fillMaxWidth().background(Color(92, 10, 140)).padding(10.dp).verticalScroll(
        rememberScrollState())) {
        for(weather in weathes){
            Row(verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.SpaceAround,modifier = Modifier.fillMaxWidth().height(100.dp).background(Color(119, 13, 181), shape = RoundedCornerShape(25.dp)).padding(5.dp).clickable(onClick= {controller.navigate( "HourlyWeatherForecastScreen/${weather.hourlyWeather.temperatureInTheMorning}/" +
                    "${weather.hourlyWeather.temperatureInTheDay}/" +
                    "${weather.hourlyWeather.temperatureInTheEvening}/" +
                    "${weather.hourlyWeather.temperatureInTheNight}")})) {
               Column(){
                    Box(){
                       Text(text = weather.data, color = Color(189, 146, 214), fontSize = 20.sp)

                    }
                   Box(){
                       Text(text = weather.dayOfTheWeek, color = Color.White, fontSize = 40.sp)

                   }
               }
                Box(){
                    Text(text = "${weather.temperature}"+" *C", color = Color.White, fontSize = 30.sp)
                }
            }
        }
    }
}
@Composable
fun HourlyWeatherForecastScreen(controller: NavHostController,morning: Int?,day: Int?,evening: Int?,night: Int?){
    BackHandler {
        controller.popBackStack()  // Возврат на предыдущий экран
    }
    Column(verticalArrangement = Arrangement.SpaceEvenly,modifier = Modifier.fillMaxSize().background(Color(92, 10, 140)).padding(10.dp)) {
        Row(horizontalArrangement = Arrangement.SpaceAround,verticalAlignment = Alignment.CenterVertically,modifier = Modifier.fillMaxWidth()){
            Box{
                Text(text = "morning", color = Color(189, 146, 214), fontSize = 30.sp)
            }
           Box{
               Text(text = morning.toString()+" *C", color = Color(189, 146, 214), fontSize = 40.sp)
           }
        }
        Row(horizontalArrangement = Arrangement.SpaceAround,verticalAlignment = Alignment.CenterVertically,modifier = Modifier.fillMaxWidth()){
            Box{
                Text(text = "day", color = Color(189, 146, 214), fontSize = 30.sp)
            }
            Box{
                Text(text = day.toString()+" *C", color = Color(189, 146, 214), fontSize = 40.sp)
            }
        }
        Row(horizontalArrangement = Arrangement.SpaceAround,verticalAlignment = Alignment.CenterVertically,modifier = Modifier.fillMaxWidth()){
            Box{
                Text(text = "evening", color = Color(189, 146, 214), fontSize = 30.sp)
            }
            Box{
                Text(text = evening.toString()+" *C", color = Color(189, 146, 214), fontSize = 40.sp)
            }
        }
        Row(horizontalArrangement = Arrangement.SpaceAround,verticalAlignment = Alignment.CenterVertically,modifier = Modifier.fillMaxWidth()){
            Box{
                Text(text = "night", color = Color(189, 146, 214), fontSize = 30.sp)
            }
            Box{
                Text(text = night.toString()+" *C", color = Color(189, 146, 214), fontSize = 40.sp)
            }
        }
    }
}
@Composable
fun NavigationScreen(){
    val navigateObject = rememberNavController()
    NavHost(navController = navigateObject, startDestination = "WeatherForecastScreen") {
        composable("WeatherForecastScreen") {

            WeatherForecastScreen(navigateObject)
        }
        composable("HourlyWeatherForecastScreen/{morning}/{day}/{evening}/{night}", arguments = listOf(navArgument("morning") { type = NavType.IntType },
            navArgument("day") { type = NavType.IntType },
            navArgument("evening") { type = NavType.IntType },
            navArgument("night") { type = NavType.IntType })) {

                entry ->
            val morning = entry.arguments?.getInt("morning")
            val day = entry.arguments?.getInt("day")
            val evening = entry.arguments?.getInt("evening")
            val night = entry.arguments?.getInt("night")

            HourlyWeatherForecastScreen(navigateObject,morning,day,evening,night)
        }
    }
}
class WeatherForecastForDay(adata: String,adayOfTheWeek: String,atemperature: Int,ahourlyWeather: HourlyWeatherForecast){
     val data: String = adata
     val dayOfTheWeek: String = adayOfTheWeek
     val temperature: Int = atemperature
     val hourlyWeather: HourlyWeatherForecast = ahourlyWeather
}
class HourlyWeatherForecast(atemperatureInTheMorning: Int,atemperatureInTheDay: Int,atemperatureInTheEvening: Int,atemperatureInTheNight: Int){
    val temperatureInTheMorning: Int = atemperatureInTheMorning
    val temperatureInTheDay: Int = atemperatureInTheDay
    val temperatureInTheEvening: Int = atemperatureInTheEvening
    val temperatureInTheNight: Int = atemperatureInTheNight
}