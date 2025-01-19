package com.example.theweatherapp.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.theweatherapp.data_class.WeatherResponse
import com.example.theweatherapp.service_interface_and_retrofit_instance.WeatherApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val _weatherData = MutableStateFlow<WeatherResponse?>(value = null)
    var weatherData: MutableStateFlow<WeatherResponse?> = _weatherData

    private val weatherApi = WeatherApi.create()

    fun fetchWeather(city: String, apiKey: String) {
        viewModelScope.launch {
            try {
                val response = weatherApi.GetWeather(city, apiKey)
                _weatherData.value = response
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}