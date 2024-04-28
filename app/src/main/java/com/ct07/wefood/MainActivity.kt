package com.ct07.wefood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ct07.wefood.newfeed.model.Post
import com.ct07.wefood.newfeed.view.NewFeed
import com.ct07.wefood.newfeed.viewmodel.PostViewModel
import com.ct07.wefood.ui.theme.WeFoodTheme

class MainActivity : ComponentActivity() {
    val postviewModel by viewModels<PostViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeFoodTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    postList(postList = postviewModel.postListResponse.value)
                    postviewModel.getPostList()
                }
            }
        }
    }
}
@Composable

fun postList(postList: List<Post>){
    LazyColumn{
        itemsIndexed(postList){index, post ->
            NewFeed(post = post)
            post
        }
    }

}
