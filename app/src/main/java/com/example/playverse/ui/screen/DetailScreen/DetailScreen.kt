package com.example.playverse.ui.screen.DetailScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import com.example.playverse.core.domain.model.DetailGameEntity
import com.example.playverse.ui.component.ButtonAddFavorite
import com.example.playverse.ui.component.ScoreBox
import com.example.playverse.ui.component.TopAppBar
import com.example.playverse.ui.theme.PlayVerseTheme
import com.example.playverse.ui.utils.Output
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    detailViewModel: DetailViewModel = koinViewModel(),
    id: Int
) {
    val output by detailViewModel.uiState.collectAsState()
    when(output){
        is Output.Loading -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize().background(color = Color.Black)
            ) {
                CircularProgressIndicator(
                    color = Color.Blue,
                    strokeWidth = 4.dp,
                    modifier = Modifier.size(48.dp)
                )
            }
        }
        is Output.Success -> {
            val game = (output as Output.Success<DetailGameEntity>).data
            val scrollState = rememberScrollState()
            var expanded by remember{
                mutableStateOf(false)
            }
            val text = game?.description
            val annotatedText = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.White)){
                    append(if(expanded) text else text?.take(280) + "... ")
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
                Text(text = game!!.title as String, style = MaterialTheme.typography.bodyLarge, color = Color.White)
                Spacer(modifier = modifier.height(10.dp))
                AsyncImage(
                    model = game.image,
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
                        ScoreBox(score = game.metaScore as Int)
                    }
                    Column(horizontalAlignment = Alignment.Start) {
                        Text(
                            text = "Platform",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color(android.graphics.Color.parseColor("#E7698E"))
                        )
                        Text(text = game.platform as String, style = MaterialTheme.typography.bodySmall, color = Color.White)
                    }
                }
                Row(modifier = modifier.fillMaxWidth(0.9f), horizontalArrangement = Arrangement.SpaceBetween) {
                    Column(modifier = modifier.fillMaxWidth(0.5f), horizontalAlignment = Alignment.Start) {
                        Text(
                            text = "Genre",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color(android.graphics.Color.parseColor("#E7698E"))
                        )
                        Text(text = game.genre as String, style = MaterialTheme.typography.bodySmall, color = Color.White)
                    }
                    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
                        Text(
                            text = "Publihers",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color(android.graphics.Color.parseColor("#E7698E"))
                        )
                        Text(text = game.publishers as String, style = MaterialTheme.typography.bodySmall, color = Color.White)
                    }
                }
                Spacer(modifier = modifier.height(15.dp).fillMaxWidth(0.9f))
                Text(
                    text = "About ${game.title}",
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
        is Output.Idle -> {
            detailViewModel.getDetailGame(id = id)
        }
        is Output.Error -> {

        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    PlayVerseTheme {
//        DetailScreen()
    }
}