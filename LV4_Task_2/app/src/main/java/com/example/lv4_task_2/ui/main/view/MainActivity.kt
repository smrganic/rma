package com.example.lv4_task_2.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lv4_task_2.R
import com.example.lv4_task_2.data.api.ApiHelper
import com.example.lv4_task_2.data.api.ApiServiceImpl
import com.example.lv4_task_2.data.model.User
import com.example.lv4_task_2.databinding.ActivityMainBinding
import com.example.lv4_task_2.ui.base.ViewModelFactory
import com.example.lv4_task_2.ui.main.adapter.MainAdapter
import com.example.lv4_task_2.ui.main.viewmodel.MainViewModel
import com.example.lv4_task_2.utils.Status

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: MainAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupUI() {
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(applicationContext)
            adapter = MainAdapter(arrayListOf())
            recyclerView.addItemDecoration(
                DividerItemDecoration(
                    recyclerView.context,
                    (recyclerView.layoutManager as LinearLayoutManager).orientation
                )
            )
            recyclerView.adapter = adapter
        }
    }

    private fun setupObserver() {
        mainViewModel.getUsers().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    it.data?.let { users -> renderList(users) }
                    binding.recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(users: List<User>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(ApiServiceImpl()))
        ).get(MainViewModel::class.java)
    }
}