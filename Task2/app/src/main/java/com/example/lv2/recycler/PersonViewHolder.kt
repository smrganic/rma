package com.example.lv2.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lv2.databinding.RecyclerItemBinding
import com.example.lv2.listeners.OnSelectedPersonListener
import com.example.lv2.model.InspiringPerson

class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(person: InspiringPerson, listener: OnSelectedPersonListener) {
        val itemBinding = RecyclerItemBinding.bind(itemView)
        itemBinding.tvRecyclerItemName.text = person.name
        itemBinding.tvRecyclerItemBDay.text = person.dateOfBirth
        itemBinding.tvRecyclerItemQuote.text = person.quote
        itemBinding.tvRecyclerItemDescription.text = person.description
        Glide.with(itemView.context)
            .load(person.imageLink)
            .into(itemBinding.ivRecyclerItemProfile)
        itemBinding.ivRecyclerItemProfile.setOnClickListener { listener.onSelectedPerson(person) }
    }
}