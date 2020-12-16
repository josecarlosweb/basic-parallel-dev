package com.example.handler

import com.example.api.OpenWeatherMapApi
import com.example.domain.WeatherStatus
import com.example.domain.dto.WeatherResponseDto
import com.example.util.fromKelvinToCelsius
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class WeatherHandler(
        private val openWeatherMapApi: OpenWeatherMapApi
) {

    private val log = LoggerFactory.getLogger(WeatherHandler::class.java)

    fun getByCity(city: String): Mono<WeatherStatus> {
        return openWeatherMapApi.getWeatherInfoFromCity(city)
                .flatMap{ weatherResponseDto -> asyncConvert(weatherResponseDto) }
                .doOnSubscribe {
                    log.info("Thread ${Thread.currentThread()} subscribe")
                }
    }

    fun asyncConvert(weatherResponseDto: WeatherResponseDto): Mono<WeatherStatus> {
        return Mono.just(WeatherStatus(description = weatherResponseDto.weather[0].description,
                temperature = fromKelvinToCelsius(weatherResponseDto.main.temp),
                feelsLike = fromKelvinToCelsius(weatherResponseDto.main.feelsLike),
                tempMin = fromKelvinToCelsius(weatherResponseDto.main.tempMin),
                tempMax = fromKelvinToCelsius(weatherResponseDto.main.tempMax)))
    }

}