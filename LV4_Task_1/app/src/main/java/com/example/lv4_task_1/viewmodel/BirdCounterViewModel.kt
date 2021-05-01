package com.example.lv4_task_1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.lv4_task_1.model.BirdCounter

class BirdCounterViewModel(private val birdCounter: BirdCounter) : ViewModel() {
    private val counter = MutableLiveData(birdCounter)

    val falconNumber = Transformations.map(counter) { it.falconCounter }
    val owlNumber = Transformations.map(counter) { it.owlCounter }
    val hawkNumber = Transformations.map(counter) { it.hawkCounter }
    val eagleNumber = Transformations.map(counter) { it.eagleCounter }

    fun seeFalcon() = counter.value?.seeFalcon()
    fun seeOwl() = counter.value?.seeOwl()
    fun seeHawk() = counter.value?.seeHawk()
    fun seeEagle() = counter.value?.seeEagle()
}