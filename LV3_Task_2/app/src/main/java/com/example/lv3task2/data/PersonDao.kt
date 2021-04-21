package com.example.lv3task2.data

import androidx.room.*
import com.example.lv3task2.model.InspiringPerson

@Dao
interface PersonDao {
    @Query("SELECT * FROM people")
    fun getPeople(): List<InspiringPerson>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(person: InspiringPerson)

    @Delete
    fun delete(person: InspiringPerson)

    @Query("SELECT * FROM people WHERE id=:id")
    fun getPerson(id: Long): InspiringPerson
}