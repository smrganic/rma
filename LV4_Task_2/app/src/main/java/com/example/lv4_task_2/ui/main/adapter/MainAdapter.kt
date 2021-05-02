package com.example.lv4_task_2.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lv4_task_2.R
import com.example.lv4_task_2.data.model.User
import com.example.lv4_task_2.databinding.ItemLayoutBinding

class MainAdapter(
    private val users: ArrayList<User>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            val itemBinding = ItemLayoutBinding.bind(itemView)
            itemBinding.textViewUserName.text = user.name
            itemBinding.textViewUserEmail.text = user.email
            Glide.with(itemBinding.imageViewAvatar.context)
                .load(user.avatar)
                .into(itemBinding.imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(users[position])

    fun addData(list: List<User>) {
        users.addAll(list)
    }

}