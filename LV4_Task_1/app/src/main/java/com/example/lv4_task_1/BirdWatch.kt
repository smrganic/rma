package com.example.lv4_task_1

import android.app.Application

class BirdWatch : Application() {
    companion object {
        lateinit var context: Application
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}