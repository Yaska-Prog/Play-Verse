package com.example.playverse.ui.screen.HomeScreen

import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.example.core.domain.model.GeneralGameEntity
import com.example.core.domain.usecase.GameDataUseCase
import com.example.playverse.ui.component.LandscapeCard
import com.example.playverse.ui.component.PortraitCard
import com.example.playverse.ui.theme.PlayVerseTheme
import com.example.core.utils.Output
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import org.koin.androidx.compose.viewModel
import org.koin.java.KoinJavaComponent.inject


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (Int) -> Unit,
    homeViewModel: HomeViewmodel = koinViewModel()) {
    val output by homeViewModel.uiState.collectAsState()
    val scrollState = rememberScrollState()
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()
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
            val top = gameList!!.slice(0..2)
            val trending = gameList.slice(2 until 10)
            val nostalgia = gameList.slice(10 until gameList.size)
            Column(modifier = modifier
                .background(color = Color.Black)
                .verticalScroll(scrollState)){
                Spacer(modifier = modifier.height(30.dp))
                HorizontalPager(pageCount = top.size, state = pagerState) {
                    LandscapeCard(content = top[it], navigateToDetail = navigateToDetail)
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
                    items(trending.count()){index ->
                        Spacer(modifier = modifier.width(5.dp))
                        PortraitCard(content = trending[index], navigateToDetail = navigateToDetail)
                    }
                }
                Text(text = "Nostalgia", style = MaterialTheme.typography.titleLarge, color = Color.White, modifier = modifier.padding(bottom = 10.dp))
                LazyRow(){
                    items(nostalgia.count()){index ->
                        Spacer(modifier = modifier.width(5.dp))
                        PortraitCard(content = nostalgia[index], navigateToDetail = navigateToDetail)
                    }
                }
            }
        }
        is Output.Idle -> {
            homeViewModel.getGameData()
        }
        is Output.Error -> {

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