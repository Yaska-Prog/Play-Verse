package com.example.playverse.ui.screen.HomeScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.playverse.R
import com.example.playverse.ui.component.LandscapeCard
import com.example.playverse.ui.component.PortraitCard
import com.example.playverse.ui.component.TopAppBar
import com.example.playverse.ui.theme.PlayVerseTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (Int) -> Unit) {
    val scrollState = rememberScrollState()
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()
    val list = listOf<LandscapeCardContent>(
        LandscapeCardContent(
            image = "https://i.etsystatic.com/13367669/r/il/013579/3107621028/il_570xN.3107621028_hfi8.jpg",
            title = "grand-theft-auto-v",
            date = "2013-09-17",
            rating = 50
        ),
        LandscapeCardContent(
            image = "https://media.rawg.io/media/games/456/456dea5e1c7e3cd07060c14e96612001.jpg",
            title = "grand-theft-auto-v",
            date = "2013-09-17",
            rating = 80
        ),
        LandscapeCardContent(
            image = "https://media.rawg.io/media/games/456/456dea5e1c7e3cd07060c14e96612001.jpg",
            title = "grand-theft-auto-v",
            date = "2013-09-17",
            rating = 50
        ),
        LandscapeCardContent(
            image = "https://media.rawg.io/media/games/456/456dea5e1c7e3cd07060c14e96612001.jpg",
            title = "grand-theft-auto-v",
            date = "2013-09-17",
            rating = 50
        ),
        LandscapeCardContent(
            image = "https://media.rawg.io/media/games/456/456dea5e1c7e3cd07060c14e96612001.jpg",
            title = "grand-theft-auto-v",
            date = "2013-09-17",
            rating = 50
        )
    )
    Column(modifier = modifier
        .background(color = Color.Black)
        .verticalScroll(scrollState)){
        Spacer(modifier = modifier.height(30.dp))
        HorizontalPager(pageCount = list.size, state = pagerState) {
            LandscapeCard(content = list[it], navigateToDetail = navigateToDetail)
        }
            Box(modifier = modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 10.dp),
                contentAlignment = Alignment.Center){
                Row(
                    modifier
                        .width(100.dp)
                        .height(40.dp)
                        .clip(shape = RoundedCornerShape(20.dp))
                        .background(color = Color.White.copy(0.4f)), horizontalArrangement = Arrangement.Center) {
                    IconButton(onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    }) {
                        Icon(imageVector = ImageVector.vectorResource(id = R.drawable.arrow_left),
                            contentDescription = "Arrow Left", tint = Color.Black,
                            modifier = modifier.padding(start = 2.dp, end = 2.dp))
                    }
                    IconButton(onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }) {
                        Icon(imageVector = ImageVector.vectorResource(id = R.drawable.arrow_right),
                            contentDescription = "Arrow Left", tint = Color.Black,
                            modifier = modifier.padding(start = 2.dp, end = 2.dp))
                    }
                }
            }
        Text(text = "Trending", style = MaterialTheme.typography.titleLarge, color = Color.White, modifier = modifier.padding(bottom = 10.dp))
        LazyRow(){
            items(list.count()){index ->
                Spacer(modifier = modifier.width(5.dp))
                PortraitCard(content = list[index], navigateToDetail = navigateToDetail)
            }
        }
        Text(text = "Nostalgia", style = MaterialTheme.typography.titleLarge, color = Color.White, modifier = modifier.padding(bottom = 10.dp))
        LazyRow(){
            items(list.count()){index ->
                Spacer(modifier = modifier.width(5.dp))
                PortraitCard(content = list[index], navigateToDetail = navigateToDetail)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    PlayVerseTheme {
//        HomeScreen()
    }
}