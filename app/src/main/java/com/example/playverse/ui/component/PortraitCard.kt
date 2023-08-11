package com.example.playverse.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.example.core.domain.model.GeneralGameEntity
import com.example.playverse.ui.screen.HomeScreen.LandscapeCardContent
import com.example.playverse.ui.theme.PlayVerseTheme

@Composable
fun PortraitCard(
    modifier: Modifier = Modifier,
    content: GeneralGameEntity,
    navigateToDetail: (Int) -> Unit
) {
    val rating = content.metacritic.div(100f)
    Box(modifier = modifier
        .height(234.dp)
        .width(135.dp)
        .clickable { navigateToDetail(content.id) }){
        AsyncImage(
            model = content.image,
            contentDescription = "Grand Theft Auto",
            modifier = modifier.fillMaxSize()
        )
        Box(modifier = modifier
            .fillMaxSize()
            .background(color = Color.Black.copy(0.2f)),
        contentAlignment = Alignment.TopEnd){
            CircularProgressBar(percentage = rating!!.toFloat(), number = 100)
        }
    }
}

@Preview
@Composable
fun PortraitCardPreview() {
    PlayVerseTheme {
//        PortraitCard()
    }
}