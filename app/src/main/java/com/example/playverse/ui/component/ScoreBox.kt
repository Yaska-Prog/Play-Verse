package com.example.playverse.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun ScoreBox(
    modifier: Modifier = Modifier,
    score: Int
) {
    Box(modifier = modifier
        .size(30.dp)
        .border(BorderStroke(0.4.dp, Color.Green), shape = RoundedCornerShape(5.dp)),
        contentAlignment = Alignment.Center){
        Text(
            text = score.toString(),
            style = MaterialTheme.typography.displayLarge,
            color = Color.Green
        )
    }
}

@Preview
@Composable
fun ScoreBoxPreview() {
    PlayVerseTheme {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)){
            ScoreBox(score = 99)
        }
    }
}