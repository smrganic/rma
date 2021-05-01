package com.example.lv4_task_1.di

import com.example.lv4_task_1.model.BirdCounter
import com.example.lv4_task_1.viewmodel.BirdCounterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory { BirdCounter() }
}

val viewModelModule = module {
    viewModel { BirdCounterViewModel(get()) }
}