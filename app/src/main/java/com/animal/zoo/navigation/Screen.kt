package com.animal.zoo.navigation

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
}