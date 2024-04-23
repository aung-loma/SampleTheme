package com.example.sampletheme.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
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

val JetRortyColors: Colors
    @Composable get() = MaterialTheme.colors

val JetRortyShapes: Shapes
    @Composable get() = MaterialTheme.shapes

val JetRortyTypography: Typography
    @Composable get() = MaterialTheme.typography

@Composable
fun SampleThemeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val typography = if (darkTheme) {
        DarkTypography
    } else {
        LightTypography
    }

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = colors.primary,
            darkIcons = darkTheme.not(),
        )
        systemUiController.setNavigationBarColor(
            color = colors.primary,
            darkIcons = darkTheme.not(),
        )
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        content = content
    )
}