package com.example.theweatherapp.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.theweatherapp.R
import com.example.theweatherapp.components.CardWeather
import com.example.theweatherapp.ui.theme.Pink40
import com.example.theweatherapp.ui.theme.Purple40
import com.example.theweatherapp.ui.theme.TheWeatherAppTheme
import com.example.theweatherapp.view_model.WeatherViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val context = LocalContext.current
    val weatherData by viewModel.weatherData.collectAsState()
    var city by remember { mutableStateOf(value = "") }
    val apiKey = "52f6a1b6489a878343b670e1be7174e5"

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.weather_image2),
                contentScale = ContentScale.FillBounds
            )
    ) {

        Text(
            text = "Weather App",
            style = TextStyle(
                fontSize = 52.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                color = Pink40
            ),
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .padding(start = 24.dp, top = 66.dp)
        )

        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(Modifier.height(180.dp))
            OutlinedTextField(
                value = city,
                onValueChange = { newValue -> city = newValue },
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 50.dp),
                label = {
                    Text(
                        text = "Enter city:",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                placeholder = { Text(text = "City name") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White,
                    focusedPlaceholderColor = Purple40,
                    focusedLabelColor = Purple40,
                    focusedBorderColor = Purple40,
                ),
                shape = RoundedCornerShape(24.dp),

                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),

                )
            Button(
                onClick = {
                    viewModel.fetchWeather(city, apiKey)
                    if (city.isEmpty()) {
                        Toast.makeText(context,"Please, insert a City", Toast.LENGTH_SHORT).show()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Pink40,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Get Weather", style = TextStyle(
                        fontSize = 16.sp,
                    )
                )
            }
            Spacer(Modifier.height(18.dp))

            weatherData?.let {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CardWeather(
                        label = "City", value = it.name,
                        icon = Icons.Default.Place)
                    CardWeather(
                        label = "Temperature", value = "${it.main.temp} ºC",
                        icon = Icons.Default.Star
                    )
                }
                Spacer(Modifier.height(6.dp))

                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Absolute.SpaceEvenly
                ) {
                    CardWeather(
                        label = "Humidity", value = "${it.main.humidity}%",
                        icon = Icons.Default.Warning
                    )
                    CardWeather(
                        label = "Description", value = it.weather[0].description,
                        icon = Icons.Default.Info
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WeatherScreenPreview() {
    TheWeatherAppTheme {
        WeatherScreen(WeatherViewModel())
    }
}