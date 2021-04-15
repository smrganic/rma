package com.example.lv2.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lv2.R
import com.example.lv2.listeners.onSelectedPersonListener
import com.example.lv2.model.Person

class PersonAdapter(
    people: List<Person>,
    private val listener: onSelectedPersonListener
)
    : RecyclerView.Adapter<PersonViewHolder>() {

    private val people: MutableList<Person> = mutableListOf()
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
        holder.bind(person)
        holder.itemView.setOnClickListener { listener.onSelectedPerson(person) }
    }

    override fun getItemCount() = people.size
}