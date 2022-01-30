package com.animal.zoo.ui.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.animal.zoo.navigation.NavGraphs

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppContent(navHostController: NavHostController) {
    val materialBlue700 = Color(0xFF4321D2)
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(title = {
                Text(
                    "Random Animals",
                    color = Color.White,
                )
            }, backgroundColor = materialBlue700)
        },
        content = { NavGraphs(navHostController = navHostController) }
    )
}