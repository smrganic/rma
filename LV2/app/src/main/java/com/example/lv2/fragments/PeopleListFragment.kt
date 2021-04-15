package com.example.lv2.fragments

import androidx.fragment.app.Fragment
import com.example.lv2.data.PeopleRepository
import com.example.lv2.listeners.onSelectedPersonListener

class PeopleListFragment : Fragment() {
    private lateinit var onSelectedPersonListener: onSelectedPersonListener
    private val peopleRepository = PeopleRepository
}