package com.ct07.wefood.newfeed.data.remote

import com.ct07.wefood.newfeed.model.Post
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PostService {
    @GET("/getfeed")
    suspend fun getPostList(): List<Post>

    companion object {
        var postService: PostService? = null
        fun getInstance(): PostService {
            if (postService == null) {
                postService = Retrofit.Builder()
                    .baseUrl("https://f18a4081-d805-4799-9be5-64c81af682bd.mock.pstmn.io")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(PostService::class.java)
            }
            return postService!!
        }
    }
}