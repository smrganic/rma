package com.example.lv4_task_1.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.lv4_task_1.R
import com.example.lv4_task_1.databinding.ActivityMainBinding
import com.example.lv4_task_1.viewmodel.BirdCounterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val birdCounterViewModel by viewModel<BirdCounterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setup()
    }

    private fun setup() {
        binding.apply {
            btnFalcon.setOnClickListener { birdCounterViewModel.seeFalcon() }
            btnOwl.setOnClickListener { birdCounterViewModel.seeOwl() }
            btnHawk.setOnClickListener { birdCounterViewModel.seeHawk() }
            btnEagle.setOnClickListener { birdCounterViewModel.seeEagle() }
            btnReset.setOnClickListener { birdCounterViewModel.reset() }
        }
        birdCounterViewModel.birdsSeen.observe(this, { binding.tvBirdCounter.text = it.toString() })
    }
}