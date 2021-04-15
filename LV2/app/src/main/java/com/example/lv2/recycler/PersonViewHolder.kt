package com.example.lv2.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lv2.Inspired
import com.example.lv2.R
import com.example.lv2.databinding.RecyclerItemBinding
import com.example.lv2.model.Person

class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(person: Person) {
        val itemBinding = RecyclerItemBinding.bind(itemView)
        itemBinding.tvRecyclerItemName.text = person.name
        itemBinding.tvRecyclerItemBDay.text = person.dateOfBirth
        itemBinding.tvRecyclerItemQuote.text = person.quote
        Glide.with(itemView.context)
            .load(person.imageLink)
            .into(itemBinding.ivRecyclerItemProfile)
    }
}