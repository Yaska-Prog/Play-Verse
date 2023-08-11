package com.example.playverse.ui.screen.SearchScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.domain.model.GeneralGameEntity
import com.example.playverse.ui.component.PortraitCard
import com.example.playverse.ui.component.SearchBar
import com.example.playverse.ui.component.TopAppBar
import com.example.playverse.ui.screen.HomeScreen.LandscapeCardContent
import com.example.playverse.ui.theme.PlayVerseTheme
import com.example.core.utils.Output
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (Int) -> Unit,
    searchViewModel: SearchViewModel = koinViewModel()
) {
    var text by remember {
        mutableStateOf("")
    }
    val output by searchViewModel.uiState.collectAsState()
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
            val gameList = (output as Output.Success<List<GeneralGameEntity>>).data
            Column(modifier = modifier
                .background(color = Color.Black)
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = modifier.height(10.dp))
                SearchBar(text = text, onValueChange = {text = it}, onEnterClick = {
                    searchViewModel.getSearchResult("${text}%")
                })
                Spacer(modifier = modifier.height(20.dp))
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3)
                ){
                    items(gameList!!.size){
                        PortraitCard(content = gameList[it], navigateToDetail = navigateToDetail)
                    }
                }
            }
        }
        is Output.Idle -> {
            searchViewModel.getSearchResult("%%")
        }
        is Output.Error -> {

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