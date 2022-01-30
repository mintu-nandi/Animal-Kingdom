package com.animal.zoo.navigation

const val DETAIL_ARGS_KEY = "id"

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object Detail: Screen(route = "detail_screen/{$DETAIL_ARGS_KEY}") {
        fun passId(id: String): String {
            return "detail_screen/$id"
        }
    }
}