package com.example.lv2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lv2.R
import com.example.lv2.databinding.ActivityMainBinding
import com.example.lv2.fragments.EditPersonFragment
import com.example.lv2.fragments.PeopleListFragment
import com.example.lv2.listeners.OnSelectedPersonListener
import com.example.lv2.listeners.fabOnClickListener
import com.example.lv2.model.Person

class MainActivity : AppCompatActivity(), OnSelectedPersonListener, fabOnClickListener {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fl_fragmentContainer, PeopleListFragment(), PeopleListFragment.TAG)
                .commit()
        }
    }

    override fun fabOnClick() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fl_fragmentContainer,
                EditPersonFragment.create(),
                EditPersonFragment.TAG
            )
            .addToBackStack(null)
            .commit()
    }

    override fun onSelectedPerson(person: Person) {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fl_fragmentContainer,
                EditPersonFragment.create(person),
                EditPersonFragment.TAG
            )
            .addToBackStack(null)
            .commit()
    }
}