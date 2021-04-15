package com.example.lv2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lv2.data.PeopleRepository
import com.example.lv2.databinding.FragmentRecyclerPersonListBinding
import com.example.lv2.listeners.onSelectedPersonListener
import com.example.lv2.recycler.PersonAdapter

class PeopleListFragment : Fragment() {
    private lateinit var onSelectedPersonListener: onSelectedPersonListener
    private lateinit var peopleListBinding: FragmentRecyclerPersonListBinding
    private val peopleRepository = PeopleRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        peopleListBinding = FragmentRecyclerPersonListBinding.inflate(inflater, container, false)
        setupRecycler()
        return peopleListBinding.root
    }

    private fun setupRecycler() {
        peopleListBinding.rvPeople.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        peopleListBinding
            .rvPeople
            .adapter = PersonAdapter(peopleRepository.getPeople(), onSelectedPersonListener)
    }
}