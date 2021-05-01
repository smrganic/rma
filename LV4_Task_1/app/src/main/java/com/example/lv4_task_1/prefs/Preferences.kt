package com.example.lv4_task_1.prefs

import android.content.Context
import com.example.lv4_task_1.BirdWatch

object Preferences {
    private const val FILE = "BirdWatchPreferences"
    private const val BIRD_COUNTER_KEY = "BirdCounter"
    private const val COLOR_KEY = "Color"

    private val preferences = BirdWatch.context.getSharedPreferences(FILE, Context.MODE_PRIVATE)
    private val prefsEditor = preferences.edit()

    // could also use prefsEditor.commit() for compatibility
    fun saveBirdCounter(counter: Int) = prefsEditor.putInt(BIRD_COUNTER_KEY, counter).apply()

    //default to 0 if there is no value
    fun getBirdCounter(): Int = preferences.getInt(BIRD_COUNTER_KEY, 0)

    fun saveColor(colorId: Int) = prefsEditor.putInt(COLOR_KEY, colorId).apply()

    fun getColor(): Int = preferences.getInt(COLOR_KEY, android.R.color.transparent)
}