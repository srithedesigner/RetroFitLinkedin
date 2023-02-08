package com.example.retrofitlinkedin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitlinkedin.api.BlogApi
import com.example.retrofitlinkedin.api.RetrofitInstance
import com.example.retrofitlinkedin.models.Post
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {


    var post: Post by mutableStateOf(Post())

    fun getPost(postId: Int) {
        viewModelScope.launch {
            post = RetrofitInstance.api.getPost(postId)
        }
    }

}