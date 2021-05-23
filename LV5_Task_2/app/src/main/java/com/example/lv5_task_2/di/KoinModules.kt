package com.example.lv5_task_2.di

import com.example.lv5_task_2.sounds.AudioPlayer
import com.example.lv5_task_2.sounds.SoundPoolPlayer
import com.example.lv5_task_2.ui.LocationData
import com.example.lv5_task_2.ui.MapsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<AudioPlayer> { SoundPoolPlayer(androidContext()) }
}

val locationModule = module {
    factory { LocationData() }
}

val viewModelModule = module {
    viewModel { MapsViewModel(get()) }
}