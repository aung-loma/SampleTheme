package com.example.sampletheme.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.example.sampletheme.provider.ThemeProvider
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(
    primary = Blue,
    primaryVariant = Blue,
    onPrimary = Color.Green,
    secondary = Red,
    secondaryVariant = RedDark,
    onSecondary = Black,

    background = BackgroundDark,
    onBackground = BackgroundDark,

    surface = CardDark,
    onSurface = CardDark
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = White,
    primaryVariant = Red,
    onPrimary = Color.Cyan,
    secondary = Red,
    secondaryVariant = Red,
    onSecondary = Color.Cyan,

    background = BackgroundLight,
    onBackground = BackgroundLight,

    surface = White,
    onSurface = White
)

@SuppressLint("ConflictingOnColor")
private val PinkColorPalette = Colors(
    primary = Pink,
    primaryVariant = Red,
    onPrimary = PinkLight,
    secondary = Pink.copy(alpha = 0.8f),
    secondaryVariant = Red,
    onSecondary = PinkLight,

    background = PinkLight,
    onBackground = PinkLight,

    surface = YellowLight,
    onSurface = YellowLight,
    isLight = true,
    error = Red,
    onError = Red700
)

val SampleThemeColors: Colors
    @Composable get() = MaterialTheme.colors

val SampleThemeTypography: Typography
    @Composable get() = MaterialTheme.typography

@Composable
fun SampleThemeTheme(
    theme : ThemeProvider.Theme,
    content: @Composable () -> Unit
) {
    val colors = when(theme) {
        ThemeProvider.Theme.SYSTEM -> if(isSystemInDarkTheme()) DarkColorPalette else LightColorPalette
        ThemeProvider.Theme.DARK -> DarkColorPalette
        ThemeProvider.Theme.LIGHT -> LightColorPalette
        ThemeProvider.Theme.PINK -> PinkColorPalette
    }
    val typography = when(theme) {
        ThemeProvider.Theme.SYSTEM -> if(isSystemInDarkTheme()) DarkTypography else LightTypography
        ThemeProvider.Theme.DARK -> DarkTypography
        ThemeProvider.Theme.LIGHT -> LightTypography
        ThemeProvider.Theme.PINK ->  LightTypography
    }
    val systemUiController = rememberSystemUiController()
    val isDarkIcons = when (theme) {
        ThemeProvider.Theme.SYSTEM -> !isSystemInDarkTheme()
        ThemeProvider.Theme.LIGHT -> true
        else -> false
    }
    SideEffect {
        systemUiController.setStatusBarColor(
            color = colors.primary,
            darkIcons = isDarkIcons,
        )
        systemUiController.setNavigationBarColor(
            color = colors.primary,
            darkIcons = isDarkIcons,
        )
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        content = content
    )
}