package com.example.theweatherapp.data_class

data class WeatherResponse(
    val name: String,
    val sys: Sys,
    val main: Main,
    val weather: List<Weather>
)
data class Main(
    val temp: Double,
    val humidity: Int,
)
data class Weather(
    val description: String,
)
data class Sys(
    val country: String,
)
