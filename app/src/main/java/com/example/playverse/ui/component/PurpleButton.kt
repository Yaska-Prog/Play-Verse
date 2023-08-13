package com.example.playverse.ui.component

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.playverse.ui.theme.PlayVerseTheme

@Composable
fun PurpleButton(
    modifier: Modifier = Modifier,
    text: String,
    icon: ImageVector? = null,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(android.graphics.Color.parseColor("#DB00FF")),
                        Color(android.graphics.Color.parseColor("#E7698E"))
                    )
                )
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
        ){
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier.padding(10.dp)) {
            if(icon == null){
                Text(text = text, style = MaterialTheme.typography.bodyMedium, color = Color.White)
            }
            else{
                Text(text = text, style = MaterialTheme.typography.bodyMedium, color = Color.White, modifier = modifier.padding(start = 7.dp, end = 7.dp, top = 2.dp, bottom = 2.dp))
                Icon(icon, contentDescription = "Back Arrow", tint = Color.White, modifier = modifier.padding(start = 7.dp, end = 7.dp, top = 2.dp, bottom = 2.dp))
            }
        }

    }
}

@Preview
@Composable
fun PurpleButtonPreview() {
    PlayVerseTheme {
//        PurpleButton(text = "Get Started!")
    }
}