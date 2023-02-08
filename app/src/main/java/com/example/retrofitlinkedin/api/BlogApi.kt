package com.example.retrofitlinkedin.api

import com.example.retrofitlinkedin.models.Post
import retrofit2.http.GET
import retrofit2.http.Path

interface BlogApi {

    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("posts/{id}")
    suspend fun getPost(@Path("id") postId: Int): Post
}