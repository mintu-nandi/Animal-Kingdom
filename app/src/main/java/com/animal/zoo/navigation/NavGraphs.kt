package com.animal.zoo.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.animal.zoo.ui.compose.HomeScreen

@ExperimentalFoundationApi
@Composable
fun NavGraphs(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route
    ) {

        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navHostController)
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument(DETAIL_ARGS_KEY) {
                type = NavType.StringType
            })
        ) {
            val id =  it.arguments?.getString(DETAIL_ARGS_KEY).toString()
//            DetailScreen(navController = navHostController, id = id)
        }
    }
}