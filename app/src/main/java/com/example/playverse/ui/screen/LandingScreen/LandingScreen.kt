package com.example.playverse.ui.screen.LandingScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.playverse.R
import com.example.playverse.ui.component.PurpleButton
import com.example.playverse.ui.theme.PlayVerseTheme
import kotlinx.coroutines.delay

@Composable
fun LandingScreen(
    modifier: Modifier = Modifier,
    onComplete: () -> Unit
) {
    Box(modifier = modifier
        .fillMaxSize()
        .background(color = Color.Black)
    ){
        Box(modifier = modifier
            .align(alignment = Alignment.Center)
            .height(300.dp)){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = modifier.height(30.dp))
                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.logo),
                    contentDescription = "App Logo",
                tint = Color.Unspecified,
                modifier = modifier.height(178.dp))
            }
        }
        Box(modifier = modifier
            .align(alignment = Alignment.Center)
            .width(220.dp)){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = modifier.height(190.dp))
                Text(text = "PlayVerse",
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color(android.graphics.Color.parseColor("#E7698E")))
                Text(text = "See your favorite games update anywhere",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White,
                textAlign = TextAlign.Center,
                modifier = modifier.padding(top = 8.dp))
            }
        }
    }
    LaunchedEffect(Unit){
        delay(3000)
        onComplete()
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun LandingScreenPreview() {
    PlayVerseTheme {
//        LandingScreen()
    }
}