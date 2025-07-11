package com.kwanhee.gym

import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.window.ComposeViewport
import com.kwanhee.gymapp.ui.theme.GymTheme
import gym.composeapp.generated.resources.NotoColorEmoji_Regular
import gym.composeapp.generated.resources.NotoSansKR_VariableFont_wght
import gym.composeapp.generated.resources.Res
import kotlinx.browser.document
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.preloadFont

@OptIn(ExperimentalComposeUiApi::class, ExperimentalResourceApi::class)
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
                    App()
                }
//                App(
//                    fontFamily = FontFamily(f),
//                    emojiFontFamily = FontFamily(fe),
//                )
            }
        }
    }
}