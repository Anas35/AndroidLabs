package com.example.artspace

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.artspace.ui.theme.ArtSpaceTheme

import org.junit.Test
import org.junit.Rule

class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun button_interactive() {
        composeTestRule.setContent {
            ArtSpaceTheme {
                Surface (modifier = Modifier.fillMaxSize()){
                    ArtSpace()
                }
            }
        }

        composeTestRule.onNode(hasTestTag("Index-0")).assertExists("No text found")
        composeTestRule.onNodeWithText("Next").performClick()
        composeTestRule.waitForIdle()
        composeTestRule.onNode(hasTestTag("Index-1")).assertExists("No text found")
        composeTestRule.onNodeWithText("Previous").performClick()
        composeTestRule.waitForIdle()
        composeTestRule.onNode(hasTestTag("Index-0")).assertExists("No text found")
    }
}