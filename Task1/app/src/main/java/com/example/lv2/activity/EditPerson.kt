package com.example.lv2.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lv2.R
import com.example.lv2.databinding.ActivityEditPersonBinding
import com.example.lv2.model.InspiringPerson

class EditPerson : AppCompatActivity() {

    private lateinit var editPersonBinding: ActivityEditPersonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        editPersonBinding = ActivityEditPersonBinding.inflate(layoutInflater)
        setContentView(editPersonBinding.root)
        editPersonBinding.btnEditSave.setOnClickListener { onSave() }
    }

    private fun onSave() {
        val editedPerson = InspiringPerson(
            editPersonBinding.etEditPersonName.text.toString(),
            editPersonBinding.etEditPersonBDay.text.toString(),
            editPersonBinding.etEditPersonDescription.text.toString(),
            editPersonBinding.etEditPersonQuote.text.toString(),
            editPersonBinding.etEditPersonImageLink.text.toString()
        )
        val outputIntent = Intent()
        outputIntent.putExtra("PERSON", editedPerson)
        setResult(RESULT_OK, outputIntent)
        finish()
    }

    companion object{
        const val activityResultCode: Int = 1;
    }
}