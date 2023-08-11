package com.example.playverse.ui.component

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.playverse.R
import com.example.playverse.ui.theme.PlayVerseTheme
import android.net.Uri
import androidx.compose.ui.platform.LocalContext

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Box(modifier = modifier
        .fillMaxWidth()
        .height(70.dp)
        .background(color = Color.Black)
        .clickable {
            val uri = Uri.parse("playverse://library")
            context.startActivity(Intent(Intent.ACTION_VIEW, uri))
        },
    contentAlignment = Alignment.Center){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(imageVector = ImageVector.vectorResource(id = R.drawable.logo), contentDescription = "Logo", modifier = modifier.size(50.dp), tint = Color.Unspecified)
            Text(
                text = "PlayVerse",
                style = MaterialTheme.typography.titleLarge,
                color = Color(android.graphics.Color.parseColor("#E7698E"))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    PlayVerseTheme {
        TopAppBar()
    }
}