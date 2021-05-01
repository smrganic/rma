package com.example.lv4_task_1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.lv4_task_1.R
import com.example.lv4_task_1.model.BirdCounter
import com.example.lv4_task_1.prefs.Preferences

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

    fun setUpFromSharedPrefs() {
        birdCounter.falconCounter = Preferences.getFalconCounter()
        birdCounter.owlCounter = Preferences.getOwlCounter()
        birdCounter.hawkCounter = Preferences.getHawkCounter()
        birdCounter.eagleCounter = Preferences.getEagleCounter()
        postValues()
    }

    private fun postValues() {
        _falconNumber.postValue(birdCounter.falconCounter)
        _owlNumber.postValue(birdCounter.owlCounter)
        _hawkNumber.postValue(birdCounter.hawkCounter)
        _eagleNumber.postValue(birdCounter.eagleCounter)
        _birdsSeen.postValue(birdCounter.birdsSeen)
    }

    fun seeFalcon() {
        birdCounter.seeFalcon()
        _falconNumber.postValue(birdCounter.falconCounter)
        _birdsSeen.postValue(birdCounter.birdsSeen)
        Preferences.saveFalconCounter(birdCounter.falconCounter)
        Preferences.saveBirdCounter(birdCounter.birdsSeen)
        Preferences.saveColor(R.color.light_green)
    }

    fun seeOwl() {
        birdCounter.seeOwl()
        _owlNumber.postValue(birdCounter.owlCounter)
        _birdsSeen.postValue(birdCounter.birdsSeen)
        Preferences.saveOwlCounter(birdCounter.owlCounter)
        Preferences.saveBirdCounter(birdCounter.birdsSeen)
        Preferences.saveColor(R.color.red)
    }

    fun seeHawk() {
        birdCounter.seeHawk()
        _hawkNumber.postValue(birdCounter.hawkCounter)
        _birdsSeen.postValue(birdCounter.birdsSeen)
        Preferences.saveHawkCounter(birdCounter.hawkCounter)
        Preferences.saveBirdCounter(birdCounter.birdsSeen)
        Preferences.saveColor(R.color.orange)
    }

    fun seeEagle() {
        birdCounter.seeEagle()
        _eagleNumber.postValue(birdCounter.eagleCounter)
        _birdsSeen.postValue(birdCounter.birdsSeen)
        Preferences.saveEagleCounter(birdCounter.eagleCounter)
        Preferences.saveBirdCounter(birdCounter.birdsSeen)
        Preferences.saveColor(R.color.green)
    }

    fun reset() {
        birdCounter.reset()
        Preferences.saveFalconCounter(0)
        Preferences.saveOwlCounter(0)
        Preferences.saveHawkCounter(0)
        Preferences.saveEagleCounter(0)
        Preferences.saveBirdCounter(0)
        Preferences.saveColor(android.R.color.transparent)
        postValues()
    }
}