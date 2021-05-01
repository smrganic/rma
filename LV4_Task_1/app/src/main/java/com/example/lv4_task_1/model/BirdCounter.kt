package com.example.lv4_task_1.model

class BirdCounter() {
    var falconCounter = 0
    var owlCounter = 0
    var hawkCounter = 0
    var eagleCounter = 0

    val birdsSeen get() = (falconCounter + owlCounter + hawkCounter + eagleCounter)

    fun seeFalcon() = falconCounter++
    fun seeOwl() = owlCounter++
    fun seeHawk() = hawkCounter++
    fun seeEagle() = eagleCounter++
    fun reset() {
        falconCounter = 0
        owlCounter = 0
        hawkCounter = 0
        eagleCounter = 0
    }
}