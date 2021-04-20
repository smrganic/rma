package com.example.lv3task1

import android.app.Application

class BirdWatch : Application() {
    companion object{
        lateinit var context: BirdWatch
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}