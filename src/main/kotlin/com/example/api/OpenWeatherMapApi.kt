package com.example.api

import com.example.domain.dto.WeatherResponseDto
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import reactor.core.publisher.Mono
import java.util.*

@Component
class OpenWeatherMapApi {

    private val log = LoggerFactory.getLogger(OpenWeatherMapApi::class.java)
    private val apiClient = WebClient.create("http://api.openweathermap.org/data/2.5")
    private val apiKey = "38ac289b552552e575cdec17019b95f4"

    fun getWeatherInfoFromCity(city: String): Mono<WeatherResponseDto> {
        return apiClient.get()
                .uri("/weather?q={city}&appid=$apiKey&lang=pt_br", city)
                .retrieve()
                .bodyToMono(WeatherResponseDto::class.java)
                .doOnSubscribe {
                    log.info("Thread ${Thread.currentThread()} subscribe")
                }

    }

    suspend fun coroutineWeatherByCity(city: String): WeatherResponseDto {
        println("${Date().time}  ${Thread.currentThread()} coroutineWeatherByCity")
        return apiClient.get()
                .uri("/weather?q={city}&appid=$apiKey&lang=pt_br", city)
                .retrieve()
                .awaitBody<WeatherResponseDto>()
    }

}