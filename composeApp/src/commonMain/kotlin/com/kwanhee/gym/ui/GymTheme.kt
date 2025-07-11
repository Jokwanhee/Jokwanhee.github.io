package com.kwanhee.gymapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily

// 요구사항에 따른 컬러 팔레트
object GymColors {
    val GoGreen = Color(0xFF34D399)  // 갈래 - 밝은 초록
    val NoRed = Color(0xFFF87171)    // 말래 - 밝은 빨강
    val ThinkingGray = Color(0xFFD1D5DB) // 고민중 - 밝은 회색
    val Background = Color(0xFFFFFBF0)   // 부드러운 미색
    val Surface = Color(0xFFFFFBF0)
    val OnSurface = Color(0xFF1F2937)
    val OnBackground = Color(0xFF1F2937)
}

private val LightColorScheme = lightColorScheme(
    primary = GymColors.GoGreen,
    secondary = GymColors.NoRed,
    tertiary = GymColors.ThinkingGray,
    background = GymColors.Background,
    surface = GymColors.Surface,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = GymColors.OnBackground,
    onSurface = GymColors.OnSurface,
)

private val DarkColorScheme = darkColorScheme(
    primary = GymColors.GoGreen,
    secondary = GymColors.NoRed,
    tertiary = GymColors.ThinkingGray,
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
)


@Composable
fun GymTheme(
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
        LocalTypography provides GymTypography.with(
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

object GymTheme {
    val typography: GymTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}
