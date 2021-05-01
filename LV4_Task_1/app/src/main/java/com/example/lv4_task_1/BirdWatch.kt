package com.example.lv4_task_1

import android.app.Application
import com.example.lv4_task_1.di.appModule
import com.example.lv4_task_1.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BirdWatch : Application() {
    companion object {
        lateinit var context: Application
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = this

        startKoin {
            androidContext(this@BirdWatch)
            modules(appModule, viewModelModule)
        }
    }
}