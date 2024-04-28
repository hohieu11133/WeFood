package com.ct07.wefood.newfeed.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.ct07.wefood.newfeed.model.Post
import com.ct07.wefood.R

@Composable
fun NewFeed(post: Post) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
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
            if (post.postImgs.size == 1) {
                // Khi chỉ có một hình ảnh, sử dụng Modifier.fillMaxWidth() để nó chiếm trọn chiều rộng
                Image(
                    painter = rememberImagePainter(data = post.postImgs.first().url),
                    contentDescription = post.postImgs.first().name,
                    contentScale = ContentScale.Crop, // Cắt để vừa vặn với chiều rộng
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                )
            } else {
                // Khi có nhiều hình ảnh, sử dụng LazyVertical Grid hoặc LazyRow để hiển thị danh sách
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(post.postImgs) { img ->
                        Image(
                            painter = rememberImagePainter(data = img.url),
                            contentDescription = img.name,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(100.dp) // Đặt một kích thước cố định hoặc sử dụng tỷ lệ phù hợp
                                .padding(4.dp)
                        )
                    }
                }
            }

        }
    }

}