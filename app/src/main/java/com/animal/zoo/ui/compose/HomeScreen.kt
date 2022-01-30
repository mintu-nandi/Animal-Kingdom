package com.animal.zoo.ui.compose

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.animal.presentation.viewmodel.HomeViewModel
import com.animal.zoo.ui.util.*
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@OptIn(ExperimentalAnimationApi::class, kotlinx.coroutines.ExperimentalCoroutinesApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val result = viewModel.state.collectAsState()
    val status = viewModel.loadingState.collectAsState()

    val state by connectivityState()
    SwipeRefresh(
        state = rememberSwipeRefreshState(status.value),
        onRefresh = { viewModel.refresh() },
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            CircularProgressBar(
                isDisplayed = status.value,
                modifier = Modifier.testTag("progress_bar")
            )
            ErrorComponent()
            val listState = rememberLazyListState()
            LazyColumn(state = listState,
                modifier = Modifier.testTag("animal-list-testTag")) {
                items(
                    items = result.value,
                    itemContent = { item ->
                        HomeComponent(
                            data = item,
                            onItemClicked = {

                            }
                        )
                    }
                )
            }
            ConnectivityStatus(connection = state, onRefresh = { viewModel.refresh() })
        }
    }
}