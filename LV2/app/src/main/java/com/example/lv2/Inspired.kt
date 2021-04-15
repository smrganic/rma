package com.example.lv2

import android.app.Application

class Inspired : Application() {
    companion object {
        private lateinit var context: Application
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}