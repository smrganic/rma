package com.example.lv2

import android.app.Application

class Inspired : Application() {
    companion object {
        private lateinit var context: Application
        fun getContext () = context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }


}