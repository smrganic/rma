package com.example.lv2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lv2.R
import com.example.lv2.databinding.ActivityEditPersonBinding

class EditPerson : AppCompatActivity() {

    private lateinit var editPersonBinding: ActivityEditPersonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        editPersonBinding = ActivityEditPersonBinding.inflate(layoutInflater)



        setContentView(editPersonBinding.root)
    }
}