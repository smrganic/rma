package com.example.lv2.activity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lv2.Inspired
import com.example.lv2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainBinding.fab.setOnClickListener { onFabClick() }
        setContentView(mainBinding.root)
    }

    private fun onFabClick() {
        val editIntent =  Intent(this, EditPerson::class.java)
        startActivity(editIntent)
    }
}