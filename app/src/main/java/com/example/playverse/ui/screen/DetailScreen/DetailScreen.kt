package com.example.playverse.ui.screen.DetailScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.playverse.ui.component.ButtonAddFavorite
import com.example.playverse.ui.component.ScoreBox
import com.example.playverse.ui.component.TopAppBar
import com.example.playverse.ui.theme.PlayVerseTheme

@Composable
fun DetailScreen(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    var expanded by remember{
        mutableStateOf(false)
    }
    val text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eu malesuada enim. Duis efficitur lorem eget ipsum volutpat tempus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Interdum et malesuada fames ac ante ipsum primis in faucibus. Donec blandit ultricies nisi, in fringilla massa. Cras cursus tincidunt dolor nec rhoncus. Maecenas sem massa, lacinia at dolor sit amet, finibus aliquam magna. Donec quis faucibus metus, in malesuada dolor. Duis eu nunc non arcu gravida sagittis in eget orci. Ut rutrum diam vitae ligula viverra, a iaculis ex ullamcorper. Proin ac nunc ut lacus maximus interdum. Donec ac blandit mi. Sed porttitor nunc vel urna aliquam, in auctor lorem porttitor. Quisque sit amet orci a tellus pellentesque fermentum.\n" +
            "\n" +
            "Duis ut ante in lacus cursus sodales quis id elit. Nulla ut turpis vel justo vestibulum semper. Aliquam venenatis risus ut mauris porta consectetur. In lacinia pellentesque sapien, ut lacinia velit. Cras id tempor ipsum. Sed ut lacinia turpis. Ut sodales pharetra pretium. Praesent ullamcorper non nunc eget malesuada. Vivamus eget nulla luctus, porta ante vitae, laoreet risus. Nam odio sapien, malesuada ac consectetur in, molestie sit amet mauris. Donec et est eleifend, posuere leo a, finibus quam. Integer posuere libero nec sapien vehicula, vel vehicula nibh posuere."
    val annotatedText = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.White)){
            append(if(expanded) text else text.take(280) + "... ")
        }
        if(!expanded){
            pushStringAnnotation(
                tag = "ReadMore",
                annotation = "Read More!"
            )
            withStyle(
                style = SpanStyle(color = Color(android.graphics.Color.parseColor("#E7698E")))
            ){
                append("Read More!")
            }
        }
        else{
            pushStringAnnotation(
                tag = "ShowLess",
                annotation = "Show less"
            )
            withStyle(
                style = SpanStyle(color = Color(android.graphics.Color.parseColor("#E7698E")))
            ){
                append(" Show Less")
            }
        }
        pop()
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally,
    modifier = modifier
        .background(color = Color.Black)
        .fillMaxSize()
        .verticalScroll(scrollState)
        .padding(start = 10.dp, end = 10.dp)) {
        Row(modifier = modifier
            .fillMaxWidth(0.9f)
            .padding(bottom = 10.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Detail", style = MaterialTheme.typography.titleLarge, color = Color.White)
            ButtonAddFavorite()
        }
        Text(text = "The Witcher 3: Wild Hunt!", style = MaterialTheme.typography.bodyLarge, color = Color.White)
        Spacer(modifier = modifier.height(10.dp))
        AsyncImage(
            model = "https://media.rawg.io/media/games/456/456dea5e1c7e3cd07060c14e96612001.jpg",
            contentDescription = "Rawg Pictures",
            modifier = modifier
                .width(360.dp)
                .height(160.dp)
                .clip(shape = RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = modifier.height(20.dp))
        Row(modifier = modifier.fillMaxWidth(0.9f), horizontalArrangement = Arrangement.SpaceBetween) {
            Column(modifier = modifier.fillMaxWidth(0.5f), horizontalAlignment = Alignment.Start) {
                Text(
                    text = "MetaScore",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(android.graphics.Color.parseColor("#E7698E"))
                )
                ScoreBox(score = 99)
            }
            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    text = "Platform",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(android.graphics.Color.parseColor("#E7698E"))
                )
                Text(text = "Playstation4, Playstation 5, Xbox One, Xbox S", style = MaterialTheme.typography.bodySmall, color = Color.White)
            }
        }
        Row(modifier = modifier.fillMaxWidth(0.9f), horizontalArrangement = Arrangement.SpaceBetween) {
            Column(modifier = modifier.fillMaxWidth(0.5f), horizontalAlignment = Alignment.Start) {
                Text(
                    text = "Genre",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(android.graphics.Color.parseColor("#E7698E"))
                )
                Text(text = "Action, Sci Fi, Fiction, Adventure", style = MaterialTheme.typography.bodySmall, color = Color.White)
            }
            Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
                Text(
                    text = "Publihers",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(android.graphics.Color.parseColor("#E7698E"))
                )
                Text(text = "CD Projekt Red", style = MaterialTheme.typography.bodySmall, color = Color.White)
            }
        }
        Spacer(modifier = modifier.height(15.dp))
        Text(
            text = "About Witcher 3: The wild hunt",
            style = MaterialTheme.typography.headlineSmall,
            color = Color(android.graphics.Color.parseColor("#E7698E"))
        )
        ClickableText(modifier = modifier.fillMaxWidth(0.9f), text = annotatedText, onClick = {offset ->
            annotatedText.getStringAnnotations(
                tag = "ReadMore",
                start = offset,
                end = offset
            ).firstOrNull()?.let {
                expanded = true
            }
            annotatedText.getStringAnnotations(
                tag = "ShowLess",
                start = offset,
                end = offset
            ).firstOrNull()?.let {
                expanded = false
            }
        }, style = MaterialTheme.typography.titleMedium)
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    PlayVerseTheme {
        DetailScreen()
    }
}