package com.kwanhee.gymapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.window.ComposeViewport
import androidx.navigation.ExperimentalBrowserHistoryApi
import androidx.navigation.bindToNavigation
import com.kwanhee.gymapp.ui.theme.GymTheme
import gymapp.composeapp.generated.resources.NotoColorEmoji_Regular
import gymapp.composeapp.generated.resources.NotoSansKR_VariableFont_wght
import gymapp.composeapp.generated.resources.Res
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.preloadFont

@OptIn(
    ExperimentalComposeUiApi::class, ExperimentalResourceApi::class,
    ExperimentalBrowserHistoryApi::class
)

fun main() {
    ComposeViewport(document.body!!) {
        val font by preloadFont(Res.font.NotoSansKR_VariableFont_wght)
        val fontEmoji by preloadFont(Res.font.NotoColorEmoji_Regular)

        font?.let { f ->
            fontEmoji?.let { fe ->
                val fontFamily = FontFamily(f)
                val emojiFontFamily = FontFamily(fe)

                GymTheme(
                    fontFamily = fontFamily,
                    emojiFontFamily = emojiFontFamily
                ) {
                    AppNavigation()
                }
//                App(
//                    fontFamily = FontFamily(f),
//                    emojiFontFamily = FontFamily(fe),
//                )
            }
        }
    }
}

