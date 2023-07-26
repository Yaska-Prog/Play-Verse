package com.example.playverse.ui.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.playverse.ui.theme.PlayVerseTheme

@Composable
fun CircularProgressBar(
    percentage: Float,
    number: Int,
    fontSize: TextUnit = 7.sp,
    radius: Dp = 10.dp,
    color: Color = Color.Green,
    strokeWidth: Dp = 3.dp,
    animeDuration: Int = 1000,
    animeDelay: Int = 0
) {
    var animationPlayed by remember{
        mutableStateOf(false)
    }
    val currentPercent = animateFloatAsState(
        targetValue = if (animationPlayed) percentage else 0f,
    animationSpec = tween(
        durationMillis = animeDuration,
        delayMillis = animeDelay
    )
    )

    LaunchedEffect(key1 = true){
        animationPlayed = true
    }

    Box(modifier = Modifier.size(radius * 2f), contentAlignment = Alignment.Center){
        Canvas(modifier = Modifier.size(radius * 2f)){
            drawArc(
                color = color,
                -90f,
                360 * currentPercent.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
            drawCircle(
                color = Color.Black,
                center = Offset(28f, 30f),
                radius = 23f
            )
        }
        Text(text = (currentPercent.value * number).toInt().toString(), color = Color.White, fontSize = fontSize, style = MaterialTheme.typography.displaySmall)
    }
}

@Preview(showBackground = true)
@Composable
fun CircularProgressBarPreview() {
    PlayVerseTheme {
        CircularProgressBar(percentage = 0.9f, number = 100)
    }
}