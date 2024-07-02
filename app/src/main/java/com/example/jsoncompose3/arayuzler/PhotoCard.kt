package com.example.jsoncompose3.arayuzler

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.jsoncompose2.R
import com.example.jsoncompose3.data.Photo

@Composable
fun PhotoCard(photo: Photo, cardColor:Color=Color.Transparent) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .padding(6.dp)
            .height(125.dp)
            .background(cardColor)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = photo.thumbnailUrl,
                    builder = {
                        crossfade(true)
                        placeholder(R.drawable.ic_placeholder) // Place a default image in your drawable folder
                        error(R.drawable.ic_placeholder) // Place a default image in your drawable folder
                    }
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Column(modifier = Modifier.fillMaxSize()) {
                Text(text = photo.title, style = MaterialTheme.typography.bodyMedium)
                Text(text = "Album ID: ${photo.albumId}", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}