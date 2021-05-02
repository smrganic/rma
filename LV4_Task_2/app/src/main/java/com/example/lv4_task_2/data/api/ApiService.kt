package com.example.lv4_task_2.data.api

import com.example.lv4_task_2.data.model.User
import io.reactivex.Single

interface ApiService {

    fun getUsers(): Single<List<User>>

}