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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.core.data.local.SharedPreferenceManager
import com.example.playverse.ui.component.BottomNavigationBar
import com.example.playverse.ui.component.TopAppBar
import com.example.playverse.ui.screen.DetailScreen.DetailScreen
import com.example.playverse.ui.screen.HomeScreen.HomeScreen
import com.example.playverse.ui.screen.LandingScreen.LandingScreen
import com.example.playverse.ui.screen.Navigation
import com.example.playverse.ui.screen.OnboardingScreen.OnboardingScreen
import com.example.playverse.ui.screen.SearchScreen.SearchScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayVerseApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val sharedPreferences = SharedPreferenceManager(LocalContext.current)
    val status = sharedPreferences.getState()
    Scaffold(
        topBar = { if(status != null) TopAppBar()}
    ) { innerPadding ->
        NavHost(navController = navController, startDestination = Navigation.Landing.route, modifier = modifier.padding(innerPadding)){
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
                DetailScreen(id = id)
            }
            composable(route = Navigation.Landing.route){
                LandingScreen(onComplete = {
                    if(status != null){
                        navController.navigate(Navigation.Home.route)
                    }
                    else{
                        navController.navigate(Navigation.OnBoarding.route)
                    }
                })
            }
            composable(route = Navigation.OnBoarding.route){
                OnboardingScreen(navigateToHome = {
                    navController.navigate(Navigation.Home.route)
                })
            }
        }
        Box(modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.96f), contentAlignment = Alignment.BottomCenter) {
            if (currentRoute.toString() == Navigation.Home.route || currentRoute.toString() == Navigation.Search.route) {
                BottomNavigationBar(navController = navController)
            }
        }
    }
}