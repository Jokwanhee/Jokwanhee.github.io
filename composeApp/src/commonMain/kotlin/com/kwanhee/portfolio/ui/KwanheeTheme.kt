package com.kwanhee.portfolio.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import org.jetbrains.compose.ui.tooling.preview.Preview

// 요구사항에 따른 컬러 팔레트
object KwanheeColors {
    val background = Color(0xFF1A1A1A)
    val secondary = Color(0xFF000000)
    val onSecondary = Color(0xFF363636)
    val onBackground = Color(0xFFFFFFFF)
    val primary = Color(0xFF8EE51B)
    val black = Color(0xFF121212)
    val white = Color(0xFFFFFFFF)
    val foreground = Color(0xFFFFFFFF)
}

private val LightColorScheme = lightColorScheme(
    primary = KwanheeColors.primary,
    secondary = KwanheeColors.secondary,
    tertiary = KwanheeColors.white,
    background = KwanheeColors.background,
    surface = KwanheeColors.white,
    onPrimary = KwanheeColors.white,
    onSecondary = KwanheeColors.onSecondary,
    onTertiary = KwanheeColors.white,
    onBackground = KwanheeColors.onBackground,
    onSurface = KwanheeColors.white,
)

private val DarkColorScheme = darkColorScheme(
    primary = KwanheeColors.primary,
    secondary = KwanheeColors.secondary,
    tertiary = KwanheeColors.black,
    background = KwanheeColors.background,
    surface = KwanheeColors.black,
    onPrimary = KwanheeColors.black,
    onSecondary = KwanheeColors.onSecondary,
    onTertiary = KwanheeColors.black,
    onBackground = KwanheeColors.onBackground,
    onSurface = KwanheeColors.black,
)


@Composable
fun KwanheeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    fontFamily: FontFamily = FontFamily.Default,
    emojiFontFamily: FontFamily = FontFamily.Default,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    CompositionLocalProvider(
        LocalTypography provides KwanheeTypography.with(
            fontFamily = fontFamily,
            emojiFontFamily = emojiFontFamily
        )
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content,
        )
    }
}

object KwanheeTheme {
    val typography: KwanheeTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}