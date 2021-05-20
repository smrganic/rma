package com.example.lv5_task_1.sounds

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import com.example.lv5_task_1.R

class SoundPoolPlayer(private val context: Context) : AudioPlayer {

    private val priority: Int = 1
    private val maxStreams: Int = 3
    private val srcQuality: Int = 1

    private val leftVolume = 1f
    private val rightVolume = 1f
    private val shouldLoop = 0
    private val playbackRate = 1f

    private val soundPool: SoundPool

    init {
        val audioAttributes = AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .setUsage(AudioAttributes.USAGE_GAME)
            .build()
        soundPool = SoundPool.Builder()
            .setAudioAttributes(audioAttributes)
            .setMaxStreams(maxStreams)
            .build()
    }

    override fun playSound(id: Int) {
        val rollingSoundId = soundPool.load(context, id, priority)
        soundPool.play(rollingSoundId, leftVolume, rightVolume, priority, shouldLoop, playbackRate)
    }
}