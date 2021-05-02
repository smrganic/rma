package com.example.lv4_task_2.data.repository

import com.example.lv4_task_2.data.api.ApiHelper
import com.example.lv4_task_2.data.model.User
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {

    fun getUsers(): Single<List<User>> {
        return apiHelper.getUsers()
    }

}