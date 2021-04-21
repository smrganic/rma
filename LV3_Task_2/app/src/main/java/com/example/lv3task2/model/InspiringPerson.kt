package com.example.lv3task2.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "people")
data class InspiringPerson(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    val dateOfBirth: String,
    val description: String,
    val quote: String,
    val imageLink: String
) : Serializable