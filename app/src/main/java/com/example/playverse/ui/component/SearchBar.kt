package com.example.playverse.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.playverse.ui.theme.PlayVerseTheme

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier
        .width(300.dp)
        .height(35.dp)
        .clip(shape = RoundedCornerShape(10.dp))
        .background(color = Color.White.copy(0.3f))){
        Row(modifier = modifier.fillMaxSize().padding(start = 5.dp), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search Icon", tint = Color.White.copy(0.4f), modifier = modifier.size(22.dp).padding(end = 5.dp))
            Text(
                text = "Search Here...",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White.copy(0.5f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchBarPrev() {
    PlayVerseTheme {
        Box(modifier = Modifier.fillMaxSize().background(color = Color.Black), contentAlignment = Alignment.TopCenter){
            SearchBar()
        }
    }
}