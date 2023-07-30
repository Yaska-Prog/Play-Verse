package com.example.playverse.ui.screen.SearchScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.playverse.ui.component.PortraitCard
import com.example.playverse.ui.component.SearchBar
import com.example.playverse.ui.component.TopAppBar
import com.example.playverse.ui.screen.HomeScreen.LandscapeCardContent
import com.example.playverse.ui.theme.PlayVerseTheme

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (Int) -> Unit
) {
    var text by remember {
        mutableStateOf("")
    }
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
        .fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = modifier.height(10.dp))
        SearchBar(text = text, onValueChange = {text = it})
        Spacer(modifier = modifier.height(20.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(3)
        ){
            items(list){
                PortraitCard(content = it, navigateToDetail = navigateToDetail)
            }
        }
    }
}

@Preview
@Composable
fun SearchScreenPreview() {
    PlayVerseTheme {
//        SearchScreen()
    }
}