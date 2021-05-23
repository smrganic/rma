package com.example.lv5_task_2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MapsViewModel(private val locationData: LocationData) : ViewModel() {

    private val _position = MutableLiveData(locationData)
    val position: LiveData<LocationData> = _position

    fun updatePosition(locationData: LocationData) = _position.postValue(locationData)
}