package com.ct07.myapplication.posts.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.ct07.myapplication.posts.model.Post
import com.ct07.myapplication.posts.model.PostImg
import com.ct07.myapplication.R
@Composable
fun NewFeed(post: Post) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(200.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_account),
                    contentDescription = "User Icon",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Column {
                    Text(
                        text = post.userName,
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        // Assuming createAt is a DateTime converted to a String
                        text = "Posted on: ${post.createAt}",
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = post.title,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Text(
                text = post.content,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )

            post.postImgs.forEach { img ->
                Image(
                    painter = rememberImagePainter(img.url),
                    contentDescription = img.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NewFeedPreview() {
    val post = Post(
        id = 1,
        userId = 1,
        userName = "John Doe",
        title = "Sample Post Title",
        content = "This is a sample post content. Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        postImgs = listOf(
            PostImg(
                id = 1,
                name = "Image 1",
                url = "https://via.placeholder.com/300",
                postId = 1
            ),
            PostImg(
                id = 2,
                name = "Image 2",
                url = "https://via.placeholder.com/300",
                postId = 1
            )
        ),
        createAt = "2024-04-25"
    )

    NewFeed(post = post)
}