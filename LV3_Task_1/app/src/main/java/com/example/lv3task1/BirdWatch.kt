package com.example.lv3task1

import android.app.Application
import android.content.Context

class BirdWatch : Application() {
    companion object{
        private lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}