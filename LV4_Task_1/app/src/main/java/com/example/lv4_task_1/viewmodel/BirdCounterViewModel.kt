package com.example.lv4_task_1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.lv4_task_1.model.BirdCounter

class BirdCounterViewModel(private val birdCounter: BirdCounter) : ViewModel() {

    private val _falconNumber = MutableLiveData(birdCounter.falconCounter)
    val falconNumber: LiveData<Int> = _falconNumber

    private val _owlNumber = MutableLiveData(birdCounter.owlCounter)
    val owlNumber: LiveData<Int> = _owlNumber

    private val _hawkNumber = MutableLiveData(birdCounter.hawkCounter)
    val hawkNumber: LiveData<Int> = _hawkNumber

    private val _eagleNumber = MutableLiveData(birdCounter.eagleCounter)
    val eagleNumber: LiveData<Int> = _eagleNumber

    private val _birdsSeen = MutableLiveData(birdCounter.birdsSeen)
    val birdsSeen: LiveData<Int> = _birdsSeen

    fun seeFalcon() {
        birdCounter.seeFalcon()
        _falconNumber.postValue(birdCounter.falconCounter)
        _birdsSeen.postValue(birdCounter.birdsSeen)
    }

    fun seeOwl() {
        birdCounter.seeOwl()
        _owlNumber.postValue(birdCounter.owlCounter)
        _birdsSeen.postValue(birdCounter.birdsSeen)
    }

    fun seeHawk() {
        birdCounter.seeHawk()
        _hawkNumber.postValue(birdCounter.hawkCounter)
        _birdsSeen.postValue(birdCounter.birdsSeen)
    }

    fun seeEagle() {
        birdCounter.seeEagle()
        _eagleNumber.postValue(birdCounter.eagleCounter)
        _birdsSeen.postValue(birdCounter.birdsSeen)
    }

    fun reset() {
        birdCounter.reset()
        _falconNumber.postValue(birdCounter.falconCounter)
        _owlNumber.postValue(birdCounter.owlCounter)
        _hawkNumber.postValue(birdCounter.hawkCounter)
        _eagleNumber.postValue(birdCounter.eagleCounter)
        _birdsSeen.postValue(birdCounter.birdsSeen)
    }
}