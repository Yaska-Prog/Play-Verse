package com.example.playverse

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.playverse.ui.component.BottomNavigationBar
import com.example.playverse.ui.component.TopAppBar
import com.example.playverse.ui.screen.DetailScreen.DetailScreen
import com.example.playverse.ui.screen.HomeScreen.HomeScreen
import com.example.playverse.ui.screen.Navigation
import com.example.playverse.ui.screen.SearchScreen.SearchScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayVerseApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { TopAppBar()}
    ) { innerPadding ->
        NavHost(navController = navController, startDestination = Navigation.Home.route, modifier = modifier.padding(innerPadding)){
            composable(Navigation.Home.route){
                HomeScreen(
                    navigateToDetail = {id ->
                        navController.navigate(Navigation.Detail.createRoute(id))
                    }
                )
            }
            composable(Navigation.Search.route){
                SearchScreen(
                    navigateToDetail = {id ->
                        navController.navigate(Navigation.Detail.createRoute(id))
                    }
                )
            }
            composable(route = Navigation.Detail.route, arguments = listOf(navArgument("id"){type = NavType.IntType})){
                val id = it.arguments?.getInt("id")?: 0
                DetailScreen()
            }
        }
        Box(modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.96f), contentAlignment = Alignment.BottomCenter){
            BottomNavigationBar(navController = navController)
        }
    }
}