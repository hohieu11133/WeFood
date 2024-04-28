package com.ct07.wefood.di

import com.ct07.wefood.newfeed.data.remote.PostService

object ServiceModule {
    val postService: PostService by lazy {
        RetrofitModule.retrofit.create(PostService::class.java)
    }
}