package com.example.lv4_task_1.prefs

import android.content.Context
import com.example.lv4_task_1.BirdWatch

object Preferences {
    private const val FILE = "BirdWatchPreferences"
    private const val BIRD_COUNTER_KEY = "BIRD_COUNTER_KEY"
    private const val FALCON_COUNTER_KEY = "FALCON_COUNTER_KEY"
    private const val OWL_COUNTER_KEY = "OWL_COUNTER_KEY"
    private const val HAWK_COUNTER_KEY = "HAWK_COUNTER_KEY"
    private const val EAGLE_COUNTER_KEY = "EAGLE_COUNTER_KEY"
    private const val COLOR_KEY = "Color"

    private val preferences = BirdWatch.context.getSharedPreferences(FILE, Context.MODE_PRIVATE)
    private val prefsEditor = preferences.edit()

    // could also use prefsEditor.commit() for compatibility
    fun saveBirdCounter(counter: Int) = prefsEditor.putInt(BIRD_COUNTER_KEY, counter).apply()

    fun saveFalconCounter(counter: Int) = prefsEditor.putInt(FALCON_COUNTER_KEY, counter).apply()
    fun saveOwlCounter(counter: Int) = prefsEditor.putInt(OWL_COUNTER_KEY, counter).apply()
    fun saveHawkCounter(counter: Int) = prefsEditor.putInt(HAWK_COUNTER_KEY, counter).apply()
    fun saveEagleCounter(counter: Int) = prefsEditor.putInt(EAGLE_COUNTER_KEY, counter).apply()

    //default to 0 if there is no value
    fun getBirdCounter(): Int = preferences.getInt(BIRD_COUNTER_KEY, 0)

    fun getFalconCounter(): Int = preferences.getInt(FALCON_COUNTER_KEY, 0)
    fun getOwlCounter(): Int = preferences.getInt(OWL_COUNTER_KEY, 0)
    fun getHawkCounter(): Int = preferences.getInt(HAWK_COUNTER_KEY, 0)
    fun getEagleCounter(): Int = preferences.getInt(EAGLE_COUNTER_KEY, 0)

    fun saveColor(colorId: Int) = prefsEditor.putInt(COLOR_KEY, colorId).apply()

    fun getColor(): Int = preferences.getInt(COLOR_KEY, android.R.color.transparent)
}