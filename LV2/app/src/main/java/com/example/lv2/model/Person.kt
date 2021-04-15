package com.example.lv2.model

import java.io.Serializable

data class Person(
    val name: String,
    val dateOfBirth: String,
    val description: String,
    val quote: String,
    val imageLink: String
) : Serializable