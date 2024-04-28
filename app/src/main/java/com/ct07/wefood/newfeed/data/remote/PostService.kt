// PostService.kt
package com.ct07.wefood.newfeed.data.remote

import com.ct07.wefood.newfeed.model.Post
import retrofit2.http.GET
import retrofit2.http.Query

interface PostService {
    @GET("/post/all")
    suspend fun getPostList(): List<Post>
    @GET("/post/like")
    suspend fun getPostLikes(@Query("postId") postId: Int): Int

}