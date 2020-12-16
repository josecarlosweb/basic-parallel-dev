package com.example.controller

import com.example.domain.WeatherStatus
import com.example.handler.WeatherHandler
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/")
class WeatherController(
        private val weatherHandler: WeatherHandler
) {

    private val log = LoggerFactory.getLogger(WeatherController::class.java)

    @GetMapping("/{city}")
    fun getByCity(@PathVariable city: String): Mono<WeatherStatus> {
        return weatherHandler.getByCity(city)
                .doOnSubscribe {
                    log.info("Thread ${Thread.currentThread()} subscribe")
                }
    }

}