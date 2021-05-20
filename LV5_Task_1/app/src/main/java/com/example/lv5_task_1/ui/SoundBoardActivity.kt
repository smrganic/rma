package com.example.lv5_task_1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.DEBUG
import android.widget.ImageButton
import com.example.lv5_task_1.R
import com.example.lv5_task_1.databinding.ActivityBoardSoundBinding
import com.example.lv5_task_1.sounds.AudioPlayer
import com.example.lv5_task_1.sounds.SoundPoolPlayer
import org.koin.android.ext.android.inject

class SoundBoardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBoardSoundBinding
    private lateinit var imageButtons: List<ImageButton>
    private val audioPlayer by inject<AudioPlayer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoardSoundBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            imageButtons = listOf(ibHarley, ibOldCar, ibUfo)
            imageButtons.forEach { imageButton -> imageButton.setOnClickListener { onImageClick(it.id) } }
        }
    }

    private fun onImageClick(id: Int) {
        when (id) {
            R.id.ib_harley -> audioPlayer.playSound(R.raw.harley)
            R.id.ib_oldCar -> audioPlayer.playSound(R.raw.oldcar)
            R.id.ib_ufo -> audioPlayer.playSound(R.raw.ufo)
        }
    }
}




