package com.example.handler

import com.example.api.OpenWeatherMapApi
import com.example.domain.WeatherStatus
import com.example.domain.dto.WeatherResponseDto
import com.example.util.coroutineFromKelvinToCelsius
import com.example.util.fromKelvinToCelsius
import kotlinx.coroutines.FlowPreview
import org.springframework.stereotype.Component
import java.util.*

@Component
class CoroutineWeatherHandler(
        private val openWeatherMapApi: OpenWeatherMapApi
) {

    @FlowPreview
    suspend fun getByCity(city: String): WeatherStatus {
        println("${Date().time}  ${Thread.currentThread()} getByCity")
        val weatherDto = openWeatherMapApi.coroutineWeatherByCity(city)
        return converter(weatherDto)
    }

    suspend fun converter(weatherResponseDto: WeatherResponseDto): WeatherStatus {
        println("${Date().time}  ${Thread.currentThread()} converter")
        return WeatherStatus(description = weatherResponseDto.weather[0].description,
                temperature = coroutineFromKelvinToCelsius(weatherResponseDto.main.temp),
                feelsLike = coroutineFromKelvinToCelsius(weatherResponseDto.main.feelsLike),
                tempMin = coroutineFromKelvinToCelsius(weatherResponseDto.main.tempMin),
                tempMax = coroutineFromKelvinToCelsius(weatherResponseDto.main.tempMax))
    }
}