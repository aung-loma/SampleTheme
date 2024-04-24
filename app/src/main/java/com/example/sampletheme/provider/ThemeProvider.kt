package com.example.sampletheme.provider

import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.take

interface ThemeProvider {
    var theme: Theme
    fun observeTheme(): Flow<Theme>

    enum class Theme {
        LIGHT,
        DARK,
        SYSTEM,
        PINK
    }

    fun isNightMode(): Boolean

    fun setThemeMode(value:Theme)
}

@Composable
fun ThemeProvider.shouldUseDarkMode(): Boolean {
    val themePreference = remember { mutableStateOf<ThemeProvider.Theme?>(ThemeProvider.Theme.SYSTEM) }
    LaunchedEffect(Unit) {
        observeTheme().collect { theme ->
            themePreference.value = theme
            setThemeMode(theme)
        }
    }
    val mode = when (themePreference.value) {
        ThemeProvider.Theme.LIGHT -> false
        ThemeProvider.Theme.DARK -> true
        else -> isSystemInDarkTheme()
    }
    return mode
}