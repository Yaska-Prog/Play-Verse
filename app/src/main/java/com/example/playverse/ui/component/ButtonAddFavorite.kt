package com.example.playverse.ui.component

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.playverse.R
import com.example.playverse.ui.theme.PlayVerseTheme

@Composable
fun ButtonAddFavorite(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    favorited: Int
) {
    var text by remember {
        mutableStateOf("")
    }
    if(favorited == 0){
        text = "Add To Favorite"
    }
    else{
        text = "Remove Favorited"
    }
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .width(104.dp)
            .height(37.dp)
            .background(color = Color.Transparent),
        border = BorderStroke(2.dp, color = Color(android.graphics.Color.parseColor("#DB00FF"))),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
        contentPadding = PaddingValues(0.dp),
        shape = RoundedCornerShape(10.dp)
        ) {
        Row(
            modifier = modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(imageVector = ImageVector.vectorResource(id = R.drawable.favorite_vector), contentDescription = "Favorite Vector", modifier = modifier.size(17.dp), tint = Color.Unspecified)
            Spacer(modifier = modifier.width(3.dp))
            Text(text = text, style = MaterialTheme.typography.labelSmall, color = Color.White)
        }
    }
}

@Preview
@Composable
fun ButtonAddFavoritePreview() {
    PlayVerseTheme {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)){
//            ButtonAddFavorite()
        }
    }
}