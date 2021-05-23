package com.example.lv5_task_2

import android.app.Application
import com.example.lv5_task_2.di.appModule
import com.example.lv5_task_2.di.locationModule
import com.example.lv5_task_2.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WhereAmI : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WhereAmI)
            modules (appModule, locationModule, viewModelModule)
        }
    }
}