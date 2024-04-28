package com.ct07.wefood.newfeed.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ct07.wefood.newfeed.data.remote.PostService
import com.ct07.wefood.newfeed.model.Post
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    var postListResponse: MutableState<List<Post>> = mutableStateOf(listOf())
    var errorMess: MutableState<String> = mutableStateOf("")

    fun getPostList() {
        viewModelScope.launch {
            val apiService = PostService.getInstance()
            try {
                val postList = apiService.getPostList()
                postListResponse.value = postList
            } catch (e: Exception) {
                errorMess.value = e.message.toString()
            }
        }
    }
}