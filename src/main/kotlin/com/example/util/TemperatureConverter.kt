package com.example.util

import java.util.*

fun fromKelvinToCelsius(temp: Double): Double {
    println("${Date().time} ${Thread.currentThread()} fromKelvinToCelsius")
    return temp - 273.15
}

suspend fun coroutineFromKelvinToCelsius(temp: Double): Double {
    println("${Date().time} ${Thread.currentThread()} coroutineFromKelvinToCelsius")
    return temp - 273.15
}