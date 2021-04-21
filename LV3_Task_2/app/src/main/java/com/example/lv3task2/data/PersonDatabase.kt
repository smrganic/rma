package com.example.lv3task2.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lv3task2.model.InspiringPerson

@Database(entities = [InspiringPerson::class], version = 1)
abstract class PersonDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao

    companion object{
        const val NAME = "personDB"
    }
}