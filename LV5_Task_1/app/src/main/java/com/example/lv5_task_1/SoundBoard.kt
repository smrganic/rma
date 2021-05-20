package com.example.lv5_task_1

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SoundBoard : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SoundBoard)
        }
    }
}