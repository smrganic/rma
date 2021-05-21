package com.example.lv5_task_2.di

import com.example.lv5_task_2.sounds.AudioPlayer
import com.example.lv5_task_2.sounds.SoundPoolPlayer
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single<AudioPlayer> { SoundPoolPlayer(androidContext()) }
}