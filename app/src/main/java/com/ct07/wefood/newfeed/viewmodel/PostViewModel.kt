package com.ct07.wefood.newfeed.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ct07.wefood.newfeed.data.PostRepository
import com.ct07.wefood.newfeed.model.Post
import kotlinx.coroutines.launch

class PostViewModel(private val postRepository: PostRepository) : ViewModel() {

    val postsLiveData = MutableLiveData<List<Post>>()
    val postLikesLiveData = MutableLiveData<Map<Long, Int>>() // Map Post ID to Likes
    val errorMessage = MutableLiveData<String>()

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                val posts = postRepository.getPosts()
                postsLiveData.value = posts
                // Tải số lượng likes cho mỗi post
                val likesMap = posts.associate { it.id to 0 }.toMutableMap()
                for (postId in likesMap.keys) {
                    likesMap[postId] = postRepository.getLikesForPost(postId.toInt())
                }
                postLikesLiveData.value = likesMap
            } catch (e: Exception) {
                errorMessage.value = e.message
            }
        }
    }
}