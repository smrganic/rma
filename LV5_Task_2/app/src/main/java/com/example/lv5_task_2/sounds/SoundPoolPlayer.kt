package com.example.lv5_task_2.sounds

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool

class SoundPoolPlayer(context: Context) : AudioPlayer {

    private val priority: Int = 1
    private val maxStreams: Int = 3

    private val leftVolume = 1f
    private val rightVolume = 1f
    private val shouldLoop = 0
    private val playbackRate = 1f

    private val soundPool: SoundPool

    private var soundLoaded: Boolean = false

    init {

        val audioAttributes = AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .setUsage(AudioAttributes.USAGE_GAME)
            .build()

        soundPool = SoundPool.Builder()
            .setAudioAttributes(audioAttributes)
            .setMaxStreams(maxStreams)
            .build()


        soundPool.setOnLoadCompleteListener { _, _, _ -> soundLoaded = true }
    }

    override fun playSound(id: Int) {
        TODO("Not yet implemented")
    }
}