package com.example.academy_proj2_githubapp.login.data

import com.example.academy_proj2_githubapp.login.data.models.AccessToken
import com.example.academy_proj2_githubapp.login.data.models.User
import retrofit2.http.*

interface LoginService {

    @Headers("Accept: application/json")
    @POST("login/oauth/access_token")
    @FormUrlEncoded
    suspend fun getAccessToken(
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String,
        @Field("code") code: String,
    ): AccessToken

    @Headers("Accept: application/vnd.github.v3+json")
    @GET("/user")
    suspend fun getUser(@Header("Authorization") auth: String): User

    @Headers("Accept: application/vnd.github.v3+json")
    @GET("/repositories")
    suspend fun getRepos(@Header("Authorization") auth: String): User

}