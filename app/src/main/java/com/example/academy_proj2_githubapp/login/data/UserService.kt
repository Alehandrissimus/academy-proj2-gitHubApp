package com.example.academy_proj2_githubapp.login.data

import com.example.academy_proj2_githubapp.login.data.models.User
import com.example.academy_proj2_githubapp.repository.data.models.UserModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface UserService {

    @GET("/user")
    suspend fun getUser(): UserModel
}