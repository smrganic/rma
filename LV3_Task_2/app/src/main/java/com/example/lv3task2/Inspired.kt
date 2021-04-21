package com.example.lv3task2

import android.app.Application

class Inspired : Application() {
    companion object {
        lateinit var context: Application
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}