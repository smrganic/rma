package com.example.lv5_task_2.ui

class LocationData() {
    var latitude: String? = null
    var longitude: String? = null
    var address: String? = null
    var country: String? = null
    var city: String? = null

    constructor(
        latitude: String,
        longitude: String,
        address: String,
        country: String,
        city: String
    ) : this() {
        this.latitude = latitude
        this.longitude = longitude
        this.address = address
        this.country = country
        this.city = city
    }
}
