package com.example.playverse.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.playverse.R
import com.example.playverse.ui.theme.PlayVerseTheme
import com.skydoves.cloudy.Cloudy

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier
) {
    Cloudy(radius = 10) {
        Box(modifier = modifier
            .width(260.dp)
            .height(50.dp)
            .background(Color.White.copy(alpha = 0.40f))){
        }
    }
    Box(modifier = modifier
        .width(260.dp)
        .height(50.dp)){
        Row(modifier = modifier
            .fillMaxSize()
            .padding(top = 2.dp, bottom = 2.dp), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically) {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.home_vector), contentDescription = "Home Vector", tint = Color.Unspecified, modifier = modifier.size(20.dp))
                Text(text = "Home", style = MaterialTheme.typography.displayMedium, color = Color.White)
            }
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search Icon", tint = Color.White, modifier = modifier.size(20.dp))
                Text(text = "Search", style = MaterialTheme.typography.displayMedium, color = Color.White)
            }
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.favorite_vector), contentDescription = "Favorite Vector", tint = Color.Unspecified, modifier = modifier.size(20.dp))
                Text(text = "Favorite", style = MaterialTheme.typography.displayMedium, color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    PlayVerseTheme {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black), contentAlignment = Alignment.BottomCenter){
            BottomNavigationBar()
        }
    }
}