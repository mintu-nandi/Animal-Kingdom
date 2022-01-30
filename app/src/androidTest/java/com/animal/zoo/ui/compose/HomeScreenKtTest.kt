package com.animal.zoo.ui.compose

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.animal.zoo.MainActivity
import com.animal.zoo.ui.theme.AnimalZooTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeScreenKtTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testLazyColumn() {
        composeTestRule.setContent {
            AnimalZooTheme() {
                HomeScreen(rememberNavController())
            }
        }
        val list = composeTestRule.onNode(hasTestTag("animal-list-testTag"), useUnmergedTree = true)
        list.assertIsNotDisplayed()
    }
}