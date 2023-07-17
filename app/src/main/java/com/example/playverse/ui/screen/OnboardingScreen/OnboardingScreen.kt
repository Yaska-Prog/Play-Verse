package com.example.playverse.ui.screen.OnboardingScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.playverse.R
import com.example.playverse.ui.component.PurpleButton
import com.example.playverse.ui.theme.PlayVerseTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier
) {
    val dataOnboarding = listOf<OnboardingsItem>(
        OnboardingsItem(R.drawable.onboarding_1, "Boost Your Game Knowledge", "Discover millions of games information out there such as Game’s rating, genres, platform and many more. "),
        OnboardingsItem(R.drawable.onboarding_2, "Easy Search & Relevant Result", "With just one tap you can search any favorite game you want. We provide a complete data about all the games you love, "),
        OnboardingsItem(R.drawable.onboarding_3, "Detailed Information", "Every game that are shown will have a detailed explanation information about the game. Browse and research any game you like within a click! "),
        OnboardingsItem(R.drawable.onboarding_4_png, "100% Free!", "Every game that are shown will have a detailed explanation information about the game. Browse and research any game you like within a click! "),
        OnboardingsItem(R.drawable.onboarding_5, "Create your own private library!", "Every game that are shown will have a detailed explanation information about the game. Browse and research any game you like within a click! "),
        )
    val pagerState = rememberPagerState(pageCount = dataOnboarding.size, initialOffscreenLimit = 4, infiniteLoop = false, initialPage = 0)
    Box(modifier = modifier
        .fillMaxSize()
        .background(Color.Black), contentAlignment = Alignment.TopEnd){
        Text(text = "Skip", style = MaterialTheme.typography.bodyMedium, color = Color.White)
    }
    OnboardingLayout(items = dataOnboarding, pagerState = pagerState)
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
        PurpleButton(text = "Next", icon = Icons.Default.ArrowForward)
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    PlayVerseTheme {
        OnboardingScreen()
    }
}