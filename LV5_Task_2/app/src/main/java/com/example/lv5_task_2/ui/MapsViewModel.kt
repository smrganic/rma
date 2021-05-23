package com.example.lv5_task_2.ui

import android.content.Context
import android.location.Geocoder
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng

class MapsViewModel(private val locationData: LocationData) :
    ViewModel() {

    private val _position = MutableLiveData(locationData)
    val position: LiveData<LocationData> = _position

    fun updatePosition(context: Context, position: LatLng) {

        val geoCoder = Geocoder(context)
        val address = geoCoder.getFromLocation(position.latitude, position.longitude, 1)[0]

        locationData.latitude = position.latitude.toString()
        locationData.longitude = position.longitude.toString()
        locationData.address = address.getAddressLine(0)
        locationData.country = address.countryName
        locationData.city = address.locality

        _position.postValue(locationData)
    }
}