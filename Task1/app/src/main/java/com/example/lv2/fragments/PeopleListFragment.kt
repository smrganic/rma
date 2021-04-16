package com.example.lv2.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lv2.data.PeopleRepository
import com.example.lv2.databinding.FragmentRecyclerPersonListBinding
import com.example.lv2.listeners.OnSelectedPersonListener
import com.example.lv2.listeners.fabOnClickListener
import com.example.lv2.recycler.PersonAdapter

class PeopleListFragment : Fragment() {
    private lateinit var onSelectedPersonListener: OnSelectedPersonListener
    private lateinit var fabOnClickListener: fabOnClickListener
    private lateinit var peopleListBinding: FragmentRecyclerPersonListBinding
    private val peopleRepository = PeopleRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        peopleListBinding = FragmentRecyclerPersonListBinding.inflate(inflater, container, false)
        setupRecycler()
        return peopleListBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnSelectedPersonListener) {
            onSelectedPersonListener = context
        }
        if (context is fabOnClickListener) {
            fabOnClickListener = context
        }
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

        peopleListBinding.fab.setOnClickListener { fabOnClickListener.fabOnClick() }
    }

    companion object {
        const val TAG = "People List Fragment"
    }
}