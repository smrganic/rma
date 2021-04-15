package com.example.lv2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lv2.R
import com.example.lv2.fragments.PeopleListFragment
import com.example.lv2.listeners.OnSelectedPersonListener
import com.example.lv2.model.Person

class MainActivity : AppCompatActivity(), OnSelectedPersonListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.fl_fragmentContainer, PeopleListFragment(), PeopleListFragment.TAG)
                .commit()
        }
    }

    override fun onSelectedPerson(person: Person) {
        TODO("Not yet implemented")
    }
}