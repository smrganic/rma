package com.example.lv3task2.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lv3task2.R
import com.example.lv3task2.listeners.OnSelectedPersonListener
import com.example.lv3task2.model.InspiringPerson

class PersonAdapter (
    people: List<InspiringPerson>,
    private val listener: OnSelectedPersonListener
)
    : RecyclerView.Adapter<PersonViewHolder>() {

    private val people: MutableList<InspiringPerson> = mutableListOf()

    init {
        this.people.clear()
        this.people.addAll(people)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recycler_item, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = people[position]
        holder.bind(person, listener)
    }

    override fun getItemCount() = people.size
}