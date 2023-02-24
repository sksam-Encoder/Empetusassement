package com.example.newslist.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.newslist.R
import com.example.newslist.data.dto.NewsModelItem

@Composable
fun MoviesListDesign(data: NewsModelItem) {
    Card(
        elevation = 7.dp, modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            val painter =
                rememberAsyncImagePainter(model = data.imageUrl, placeholder =
                painterResource(id = R.drawable.no_images))
            Image(
                painter =  painter,
                contentDescription = null,
                modifier = Modifier
                    .weight(.1f)
                    .height(100.dp)
                    .padding(3.dp),
                contentScale = ContentScale.Crop
            )

            Column(verticalArrangement = Arrangement.Top, modifier = Modifier.weight(.2f)) {
                Text(
                    text = data.title ?: "" ,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold, modifier = Modifier.padding(vertical = 5.dp, horizontal = 4.dp)
                )
                Text(
                    text = data.summary ?: "" ,
                    fontSize = 10.sp,
                    maxLines = 3,
                    fontWeight = FontWeight.Normal ,modifier = Modifier.padding(vertical = 4.dp, horizontal = 4.dp)
                )
            }
        }
    }
}