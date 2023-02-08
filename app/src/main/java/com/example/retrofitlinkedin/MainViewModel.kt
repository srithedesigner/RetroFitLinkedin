package com.example.retrofitlinkedin

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitlinkedin.api.RetrofitInstance
import com.example.retrofitlinkedin.models.Post
import kotlinx.coroutines.launch

private const val TAG = "MainViewModel"

class MainViewModel : ViewModel(){

    var posts: List<Post> by mutableStateOf(listOf())

    fun fetchPosts(): List<Post> {
        viewModelScope.launch {
            val fetchedPosts = RetrofitInstance.api.getPosts()
//            Log.i(TAG, "FetchedPosts: $fetchedPosts")
            posts = fetchedPosts
        }
        return posts
    }


}