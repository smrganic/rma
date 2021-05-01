package com.example.lv4_task_1.model

class BirdCounter {
    var falconCounter = 0
        private set
    var owlCounter = 0
        private set
    var hawkCounter = 0
        private set
    var eagleCounter = 0
        private set

    val birdsSeen = falconCounter + owlCounter + hawkCounter + eagleCounter

    fun seeFalcon() = falconCounter++
    fun seeOwl() = owlCounter++
    fun seeHawk() = hawkCounter++
    fun seeEagle() = eagleCounter++
}