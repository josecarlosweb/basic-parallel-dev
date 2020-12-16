package com.example.controller

import com.example.domain.WeatherStatus
import com.example.handler.CoroutineWeatherHandler
import kotlinx.coroutines.FlowPreview
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/coroutine")
class CoroutineWeatherController(
        private val coroutineWeatherHandler: CoroutineWeatherHandler
) {

    @FlowPreview
    @GetMapping("/{city}")
    suspend fun getByCity(@PathVariable city: String): WeatherStatus {
        return coroutineWeatherHandler.getByCity(city)
    }

}