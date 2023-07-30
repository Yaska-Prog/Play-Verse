package com.example.playverse.ui.screen

sealed class Navigation(val route: String){

    object Landing: Navigation("landing")
    object OnBoarding: Navigation("onboarding")
    object Home: Navigation("home")
    object Search: Navigation("search")
    object Detail: Navigation("detail/{id}"){
        fun createRoute(id: Int) = "detail/$id"
    }
}
