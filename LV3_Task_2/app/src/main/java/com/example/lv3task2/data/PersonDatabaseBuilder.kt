package com.example.lv3task2.data

import androidx.room.Room
import com.example.lv3task2.Inspired

object PersonDatabaseBuilder {

    private var instance: PersonDatabase? = null

    fun getInstance(): PersonDatabase {
        synchronized(PersonDatabase::class) {
            if (instance == null)
                instance = buildDatabase()
        }
        return instance!!
    }

    private fun buildDatabase(): PersonDatabase {
        return Room.databaseBuilder(
            Inspired.context,
            PersonDatabase::class.java,
            PersonDatabase.NAME
        ).allowMainThreadQueries().build() // MainThreadQueries seems like a bad idea...
    }
}