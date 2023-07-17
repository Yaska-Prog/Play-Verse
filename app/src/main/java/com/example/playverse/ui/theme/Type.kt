package com.example.playverse.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.playverse.R

// Set of Material typography styles to start with
private val potta = FontFamily(
    Font(R.font.potta, FontWeight.W600)
)
val pottaTypography = Typography(
    titleLarge = TextStyle(
        fontFamily = potta,
        fontWeight = FontWeight.W600,
        fontSize = 40.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = potta,
        fontWeight = FontWeight.W600,
        fontSize = 35.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = potta,
        fontWeight = FontWeight.W600,
        fontSize = 15.sp
    )
)
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)