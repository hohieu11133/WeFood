package com.ct07.myapplication.posts.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ct07.myapplication.posts.model.Post
import com.ct07.myapplication.posts.network.ApiService
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    var postListResponse: MutableState<List<Post>> = mutableStateOf(listOf())
    var errorMess: MutableState<String> = mutableStateOf("")

    fun getPostList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val postList = apiService.getPostList()
                postListResponse.value = postList
            } catch (e: Exception) {
                errorMess.value = e.message.toString()
            }
        }
    }
}