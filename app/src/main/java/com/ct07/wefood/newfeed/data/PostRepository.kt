package com.ct07.wefood.newfeed.data

import com.ct07.wefood.newfeed.data.remote.PostService
import com.ct07.wefood.newfeed.model.Post

class PostRepository(private val postService: PostService) {

    suspend fun getPosts(): List<Post> {
        return postService.getPostList()
    }
     suspend fun getLikesForPost(postId: Int): Int {
        return postService.getPostLikes(postId)
    }
}