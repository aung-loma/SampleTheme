package com.example.sampletheme.presentation

import androidx.lifecycle.ViewModel
import com.example.sampletheme.provider.ThemeProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel  @Inject constructor(
    private val themeProvider: ThemeProvider
) : ViewModel() {
    fun themeProvider() = themeProvider

    fun changeTheme(value : ThemeProvider.Theme) {
        themeProvider.theme = value
    }
}