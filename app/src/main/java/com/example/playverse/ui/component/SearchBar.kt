package com.example.playverse.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.playverse.R
import com.example.playverse.ui.theme.PlayVerseTheme

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit,
    onEnterClick: () -> Unit
) {
    val potta = FontFamily(
        Font(R.font.potta, FontWeight.W600)
    )
    Box(modifier = modifier
        .width(300.dp)
        .height(35.dp)
        .clip(shape = RoundedCornerShape(10.dp))
        .background(color = Color.White.copy(0.3f))){
        Row(modifier = modifier
            .fillMaxSize()
            .padding(start = 5.dp), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search Icon", tint = Color.White.copy(0.4f), modifier = modifier
                .size(22.dp)
                .padding(end = 5.dp))
            BasicTextField(value = text,
                onValueChange = onValueChange,
                modifier = modifier.fillMaxHeight(0.6f).fillMaxWidth(0.9f),
                singleLine = true,
                textStyle = TextStyle.Default.copy(color = Color.White.copy(0.5f), fontSize = 15.sp, fontFamily = potta),
                decorationBox = {innerTextField ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Transparent)
                    ) {
                        innerTextField()
                        if (text.isEmpty()) {
                            Text(
                                text = "Search Here...",
                                color = Color.White.copy(0.5f),
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.align(Alignment.CenterStart)
                            )
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {onEnterClick()})
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchBarPrev() {
    PlayVerseTheme {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black), contentAlignment = Alignment.TopCenter){
//            SearchBar()
        }
    }
}