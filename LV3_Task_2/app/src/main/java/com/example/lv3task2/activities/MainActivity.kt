package com.example.lv3task2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lv3task2.R
import com.example.lv3task2.databinding.ActivityMainBinding
import com.example.lv3task2.fragments.EditPersonFragment
import com.example.lv3task2.fragments.PeopleListFragment
import com.example.lv3task2.listeners.FabOnClickListener
import com.example.lv3task2.listeners.OnSelectedPersonListener
import com.example.lv3task2.model.InspiringPerson

class MainActivity : AppCompatActivity(), OnSelectedPersonListener, FabOnClickListener {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        setFragment(savedInstanceState)
    }

    private fun setFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fl_fragmentContainer, PeopleListFragment(), PeopleListFragment.TAG)
                .commit()
        }
    }

    override fun onSelected(person: InspiringPerson) {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fl_fragmentContainer,
                EditPersonFragment.create(person),
                EditPersonFragment.TAG
            )
            .addToBackStack(null)
            .commit()
    }


    override fun onClick() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fl_fragmentContainer,
                EditPersonFragment.create(),
                EditPersonFragment.TAG
            )
            .addToBackStack(null)
            .commit()
    }
}