package com.example.lv2.activity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lv2.Inspired
import com.example.lv2.data.PeopleRepository
import com.example.lv2.databinding.ActivityMainBinding
import com.example.lv2.listeners.OnSelectedPersonListener
import com.example.lv2.model.InspiringPerson
import com.example.lv2.recycler.PersonAdapter


class MainActivity : AppCompatActivity(), OnSelectedPersonListener {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var onSelectedPersonListener: OnSelectedPersonListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainBinding.fab.setOnClickListener { onFabClick() }
        setContentView(mainBinding.root)
        setUpRecycler()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (
            requestCode == EditPerson.activityResultCode
            && resultCode == RESULT_OK
            && data != null
        ) {
            val person = data.getSerializableExtra("PERSON") as InspiringPerson
            PeopleRepository.insertPerson(person)
            setUpRecycler()
        }
    }

    private fun setUpRecycler() {

        mainBinding.rvPeople.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        onSelectedPersonListener = this

        mainBinding.rvPeople.adapter = PersonAdapter(
            PeopleRepository.getPeople(),
            onSelectedPersonListener
        )
    }

    private fun onFabClick() {
        val editIntent = Intent(this, EditPerson::class.java)
        startActivityForResult(editIntent, EditPerson.activityResultCode)
    }

    override fun onSelectedPerson(person: InspiringPerson) {
        Toast.makeText(this, person.quote, Toast.LENGTH_SHORT).show()
    }
}