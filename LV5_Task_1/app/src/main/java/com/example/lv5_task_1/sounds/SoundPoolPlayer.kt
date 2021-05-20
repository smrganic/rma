package com.example.lv5_task_1.sounds

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import com.example.lv5_task_1.R

class SoundPoolPlayer(context: Context) : AudioPlayer {

    private val priority: Int = 1
    private val maxStreams: Int = 3

    private val leftVolume = 1f
    private val rightVolume = 1f
    private val shouldLoop = 0
    private val playbackRate = 1f

    private val soundPool: SoundPool

    private var soundLoaded: Boolean = false
    var soundMap: HashMap<Int, Int> = HashMap()

    init {

        val audioAttributes = AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .setUsage(AudioAttributes.USAGE_GAME)
            .build()

        soundPool = SoundPool.Builder()
            .setAudioAttributes(audioAttributes)
            .setMaxStreams(maxStreams)
            .build()

        soundMap[R.raw.harley] = soundPool.load(context, R.raw.harley, priority)
        soundMap[R.raw.oldcar] = soundPool.load(context, R.raw.oldcar, priority)
        soundMap[R.raw.ufo] = soundPool.load(context, R.raw.ufo, priority)

        soundPool.setOnLoadCompleteListener { _, _, _ -> soundLoaded = true }
    }

    override fun playSound(id: Int) {
        if (soundLoaded)
            when (id) {
                R.raw.harley -> soundPool.play(
                    soundMap[id]!!,
                    leftVolume,
                    rightVolume,
                    priority,
                    shouldLoop,
                    playbackRate
                )
                R.raw.oldcar -> soundPool.play(
                    soundMap[id]!!,
                    leftVolume,
                    rightVolume,
                    priority,
                    shouldLoop,
                    playbackRate
                )
                R.raw.ufo -> soundPool.play(
                    soundMap[id]!!,
                    leftVolume,
                    rightVolume,
                    priority,
                    shouldLoop,
                    playbackRate
                )
            }
    }
}