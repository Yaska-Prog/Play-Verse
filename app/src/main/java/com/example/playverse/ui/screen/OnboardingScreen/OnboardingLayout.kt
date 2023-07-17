package com.example.playverse.ui.screen.OnboardingScreen

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.playverse.R
import com.example.playverse.ui.component.PurpleButton
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingLayout(
    items: List<OnboardingsItem>,
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.animation_lk6k47pc))
    HorizontalPager(state = pagerState) {page ->
        Box(modifier = modifier.fillMaxWidth()){
            Column(
                modifier = modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if(page == 3){
                    Image(painter = painterResource(id = items[page].image), contentDescription = "Onboarding Image", modifier = modifier
                        .size(250.dp))
                }
                else{
                    Image(imageVector = ImageVector.vectorResource(id = items[page].image),
                        contentDescription = "Onboarding Image",
                        modifier = modifier.size(250.dp))
                }
                Text(text = items[page].title, style = MaterialTheme.typography.headlineLarge, color = Color.White, textAlign = TextAlign.Center)
                Spacer(modifier = modifier.height(15.dp))
                Text(text = items[page].desc, style = MaterialTheme.typography.bodyMedium, color = Color.White.copy(alpha = 0.5f), textAlign = TextAlign.Center)
                Spacer(modifier = modifier.height(18.dp))
                PagerIndicator(size = items.size, currentPage = pagerState.currentPage)
            }
        }

    }
}

@Composable
fun PagerIndicator(
    size: Int,
    currentPage: Int
) {
  Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
      repeat(size){
          if(it == currentPage){
              Icon(imageVector = ImageVector.vectorResource(id = R.drawable.gamepad),
                  contentDescription = "Gamepad",
              tint = Color.Unspecified)
          }
          else{
              Box(modifier = Modifier
                  .padding(2.dp)
                  .height(8.dp)
                  .width(8.dp)
                  .clip(CircleShape)
                  .background(Color.White))
          }
      }
      
  }  
}