package com.example.playverse.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import coil.compose.AsyncImage
import com.example.playverse.R
import com.example.playverse.ui.screen.Navigation
import com.example.playverse.ui.screen.NavigationBarItem
import com.example.playverse.ui.theme.PlayVerseTheme
import com.skydoves.cloudy.Cloudy

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination
    var selectedHome = false
    var selectedSearch = false
    val navBar = listOf<NavigationBarItem>(
        NavigationBarItem(ImageVector.vectorResource(id = R.drawable.home_vector), "Home", Navigation.Home.route),
        NavigationBarItem(Icons.Outlined.Search, "Search", Navigation.Search.route)
    )
    Cloudy(radius = 20) {
        Box(modifier = modifier
            .width(260.dp)
            .height(50.dp)
            .background(Color.White.copy(alpha = 0.28f))){
        }
    }
    Box(modifier = modifier
        .width(260.dp)
        .height(50.dp)
        .background(color = Color.Transparent)){
        Row(modifier = modifier
            .fillMaxSize()
            .padding(top = 2.dp, bottom = 2.dp), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
            navBar.forEach{item ->
                if(item.route == Navigation.Home.route){
//                    selectedHome = currentDestination?.hierarchy?.any{it.route == item.route} == true
                    AddItem(
                        screen = item,
                        navController = navController,
                        modifier = modifier,
                        selected = selectedHome
                    )
                }
                if(item.route == Navigation.Search.route){
//                    selectedSearch = currentDestination?.hierarchy?.any{it.route == item.route} == true
                    AddItem(
                        screen = item,
                        navController = navController,
                        modifier = modifier,
                        selected = selectedSearch
                    )
                }
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: NavigationBarItem,
    navController: NavHostController,
    modifier: Modifier,
    selected: Boolean
) {
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.clickable {
        navController.navigate(screen.route){
            popUpTo(navController.graph.findStartDestination().id){
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }) {
        Icon(imageVector = screen.icon, contentDescription = "Home Vector", tint = if(selected) Color.Black else Color.White, modifier = modifier.size(20.dp))
        Text(text = screen.text, style = MaterialTheme.typography.displayMedium, color = if(selected) Color.Black else Color.White)
        AnimatedVisibility(visible = selected) {
            if(selected) Divider(color = Color(android.graphics.Color.parseColor("#DB00FF")))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    PlayVerseTheme {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black), contentAlignment = Alignment.BottomCenter){
//            BottomNavigationBar()
        }
    }
}