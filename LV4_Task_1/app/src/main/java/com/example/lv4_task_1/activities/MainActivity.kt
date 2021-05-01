package com.example.lv4_task_1.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lv4_task_1.databinding.ActivityMainBinding
import com.example.lv4_task_1.viewmodel.BirdCounterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val birdCounterViewModel by viewModel<BirdCounterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}