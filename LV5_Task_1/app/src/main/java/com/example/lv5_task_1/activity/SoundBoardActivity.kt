package com.example.lv5_task_1.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lv5_task_1.R
import com.example.lv5_task_1.databinding.ActivityBoardSoundBinding

class SoundBoardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBoardSoundBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoardSoundBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}