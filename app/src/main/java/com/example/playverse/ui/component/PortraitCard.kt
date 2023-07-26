package com.example.playverse.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.playverse.ui.theme.PlayVerseTheme

@Composable
fun PortraitCard(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier
        .height(234.dp)
        .width(135.dp)){
        AsyncImage(
            model = "https://media.rawg.io/media/games/456/456dea5e1c7e3cd07060c14e96612001.jpg",
            contentDescription = "Grand Theft Auto",
            modifier = modifier.fillMaxSize()
        )
        Box(modifier = modifier
            .fillMaxSize()
            .background(color = Color.Black.copy(0.2f)),
        contentAlignment = Alignment.TopEnd){
            CircularProgressBar(percentage = 0.8f, number = 100)
        }
    }
}

@Preview
@Composable
fun PortraitCardPreview() {
    PlayVerseTheme {
        PortraitCard()
    }
}