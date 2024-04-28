package com.ct07.wefood.newfeed.model


data class Post(
    val id: Long,
    val userId: Long,
    val userName: String,
    val title: String,
    val content: String,
    val postImgs: List<PostImg>,
    val createAt: String,
)

data class PostImg(
    val id: Long,
    val name: String,
    val url: String,
    val postId: Long,
)