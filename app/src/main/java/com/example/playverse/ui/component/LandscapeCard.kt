package com.example.playverse.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.playverse.R
import com.example.core.domain.model.GeneralGameEntity
import com.example.playverse.ui.screen.HomeScreen.LandscapeCardContent
import com.example.playverse.ui.theme.PlayVerseTheme

@Composable
fun LandscapeCard(
    modifier: Modifier = Modifier,
    content: GeneralGameEntity,
    navigateToDetail: (Int) -> Unit
) {
    var totalStar = 1
    if(content.metacritic >= 80 && content.metacritic < 100){
        totalStar = 4
    }
    else if(content.metacritic < 80 && content.metacritic > 50){
        totalStar = 3
    }
    else if(content.metacritic in 30..50){
        totalStar = 2
    }

    Box(modifier = modifier
        .height(200.dp)
        .width(350.dp)
        .clip(RoundedCornerShape(15.dp))
        .clickable { navigateToDetail(content.id) }){
        AsyncImage(
            model = content.image,
            contentDescription = "Grand Theft Auto",
            modifier = modifier
                .height(200.dp)
                .width(350.dp)
                .clip(RoundedCornerShape(15.dp)),
            contentScale = ContentScale.Fit
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .height(34.dp)
                .background(color = Color.Black.copy(alpha = 0.5f))
                .clip(
                    RoundedCornerShape(bottomEnd = 15.dp, bottomStart = 15.dp)
                )
        ){
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier.padding(start = 8.dp, top = 2.dp)) {
                Column() {
                    Text(text = content.title, style = MaterialTheme.typography.bodySmall, color = Color(android.graphics.Color.parseColor("#E7698E")))
                    Text(text = content.releaseDate, style = MaterialTheme.typography.displaySmall, color = Color(android.graphics.Color.parseColor("#E7698E")))
                }
                Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.CenterEnd){
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(5.dp), modifier = modifier.padding(end = 10.dp)) {
                        Text(text = content.metacritic.toString(), style = MaterialTheme.typography.displayLarge, color = Color(android.graphics.Color.parseColor("#DB00FF")))
                        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                            repeat(5){
                                if(it < totalStar){
                                    Icon(
                                        imageVector = ImageVector.vectorResource(id = R.drawable.baseline_star_filled_24),
                                        contentDescription = "Star Filled",
                                        tint = Color(android.graphics.Color.parseColor("#DB00FF")),
                                        modifier = modifier.size(15.dp))
                                }
                                else{
                                    Icon(
                                        imageVector = ImageVector.vectorResource(id = R.drawable.baseline_star_outline_24),
                                        contentDescription = "Star Filled",
                                        tint = Color(android.graphics.Color.parseColor("#DB00FF")),
                                        modifier = modifier.size(15.dp))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LandscapeCardPreview() {
    PlayVerseTheme {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter){
//            LandscapeCard()
        }
    }
}