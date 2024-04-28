package com.ct07.myapplication.posts.network

import com.ct07.myapplication.posts.model.Post
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("/getfeed")
    suspend fun getPostList(): List<Post>

    companion object {
        var apiService: ApiService? = null
        fun getInstance(): ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://ae29514a-17a7-4562-8db2-cd8d9f8c3fed.mock.pstmn.io ")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}