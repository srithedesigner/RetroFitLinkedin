package com.example.retrofitlinkedin.models

data class User (
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val website: String,
    val company: Company

    )