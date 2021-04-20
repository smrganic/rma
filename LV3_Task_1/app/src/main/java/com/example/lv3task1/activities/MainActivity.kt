package com.example.lv3task1.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lv3task1.R
import com.example.lv3task1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private var birdCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setup()
    }

    private fun setup() {
        mainBinding.apply {
            tvBirdCounter.text = birdCounter.toString()
            btnEagle.setOnClickListener { onButtonClick(btnEagle.id) }
            btnFalcon.setOnClickListener { onButtonClick(btnFalcon.id) }
            btnHawk.setOnClickListener { onButtonClick(btnHawk.id) }
            btnOwl.setOnClickListener { onButtonClick(btnOwl.id) }
            btnReset.setOnClickListener { onButtonClick(btnReset.id) }
        }
    }

    private fun onButtonClick(id: Int) {
        mainBinding.apply {
            tvBirdCounter.text = (++birdCounter).toString()
            when (id) {
                btnEagle.id -> tvBirdCounter.setBackgroundColor(resources.getColor(R.color.green))
                btnFalcon.id -> tvBirdCounter.setBackgroundColor(resources.getColor(R.color.light_green))
                btnHawk.id -> tvBirdCounter.setBackgroundColor(resources.getColor(R.color.orange))
                btnOwl.id -> tvBirdCounter.setBackgroundColor(resources.getColor(R.color.red))
                btnReset.id -> {
                    tvBirdCounter.setBackgroundColor(resources.getColor(android.R.color.transparent))
                    birdCounter = 0
                    tvBirdCounter.text = birdCounter.toString()
                }
            }
        }
    }
}