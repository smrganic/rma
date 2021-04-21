package com.example.lv3task2.model

import java.io.Serializable

data class InspiringPerson(
    val name: String,
    val dateOfBirth: String,
    val description: String,
    val quote: String,
    val imageLink: String
) : Serializable