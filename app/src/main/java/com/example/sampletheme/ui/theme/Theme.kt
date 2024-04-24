package com.example.sampletheme.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.example.sampletheme.provider.ThemeProvider
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(
    primary = Blue,
    primaryVariant = Blue,
    onPrimary = White,
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
    onPrimary = Black,
    secondary = Red,
    secondaryVariant = Red,
    onSecondary = Black,

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
        ThemeProvider.Theme.LIGHT -> if(isSystemInDarkTheme()) DarkTypography else LightTypography
        ThemeProvider.Theme.PINK ->  if(isSystemInDarkTheme()) DarkTypography else LightTypography
    }
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = colors.primary,
            darkIcons = theme != ThemeProvider.Theme.DARK,
        )
        systemUiController.setNavigationBarColor(
            color = colors.primary,
            darkIcons = theme != ThemeProvider.Theme.DARK,
        )
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        content = content
    )
}