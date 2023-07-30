package com.example.playverse.ui.screen

import android.graphics.drawable.Icon
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationBarItem(
    val icon: ImageVector,
    val text: String,
    val route: String
)
