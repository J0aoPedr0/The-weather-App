package com.example.theweatherapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.theweatherapp.presentation.WeatherScreen
import com.example.theweatherapp.ui.theme.TheWeatherAppTheme
import com.example.theweatherapp.view_model.WeatherViewModel

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashScreen
        enableEdgeToEdge()
        setContent {
            val viewModel = viewModel<WeatherViewModel>()
            TheWeatherAppTheme {
                WeatherScreen(viewModel = viewModel)
            }
        }
    }
}
