package com.kwanhee.gymapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import com.kwanhee.gymapp.screens.GymScreen
import com.kwanhee.gymapp.ui.theme.GymTheme
import gymapp.composeapp.generated.resources.NotoColorEmoji_Regular
import gymapp.composeapp.generated.resources.NotoSansKR_VariableFont_wght
import gymapp.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App(
    friendId: String? = null,
    fontFamily: FontFamily = FontFamily(Font(resource = Res.font.NotoSansKR_VariableFont_wght)),
    emojiFontFamily: FontFamily = FontFamily(Font(resource = Res.font.NotoColorEmoji_Regular)),
) {
    GymTheme(
        fontFamily = fontFamily,
        emojiFontFamily = emojiFontFamily
    ) {
        GymScreen(friendId = friendId)
    }
}

