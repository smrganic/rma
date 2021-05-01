package com.example.lv4_task_1.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.lv4_task_1.R
import com.example.lv4_task_1.databinding.ActivityCounterBinding
import com.example.lv4_task_1.prefs.Preferences
import com.example.lv4_task_1.viewmodel.BirdCounterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CounterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCounterBinding
    private val birdCounterViewModel by viewModel<BirdCounterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCounterBinding.inflate(layoutInflater)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_counter)
        binding.birdCounterViewModel = birdCounterViewModel
        binding.lifecycleOwner = this
        setup()
    }

    override fun onResume() {
        super.onResume()
        if(Preferences.getBirdCounter() != 0) birdCounterViewModel.setUpFromSharedPrefs()
        binding.tvBirdCounter.setBackgroundColor(resources.getColor(Preferences.getColor()))
    }

    private fun setup() {
        binding.apply {
            btnFalcon.setOnClickListener { onButtonClick(btnFalcon.id) }
            btnOwl.setOnClickListener { onButtonClick(btnOwl.id) }
            btnHawk.setOnClickListener { onButtonClick(btnHawk.id) }
            btnEagle.setOnClickListener { onButtonClick(btnEagle.id) }
            btnReset.setOnClickListener { onButtonClick(btnReset.id) }
        }
    }

    private fun onButtonClick(id: Int) {
        binding.apply {
            when (id) {
                btnFalcon.id -> birdCounterViewModel?.seeFalcon()
                btnOwl.id -> birdCounterViewModel?.seeOwl()
                btnHawk.id -> birdCounterViewModel?.seeHawk()
                btnEagle.id -> birdCounterViewModel?.seeEagle()
                btnReset.id -> birdCounterViewModel?.reset()
            }
            tvBirdCounter.setBackgroundColor(resources.getColor(Preferences.getColor()))
        }
    }
}