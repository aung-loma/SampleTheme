package com.example.sampletheme.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sampletheme.provider.ThemeProvider
import com.example.sampletheme.provider.shouldUseDarkMode
import com.example.sampletheme.ui.theme.SampleThemeColors
import com.example.sampletheme.ui.theme.SampleThemeTheme
import com.example.sampletheme.ui.theme.SampleThemeTypography
import com.example.sampletheme.ui.theme.cardBackgroundColor

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    val isDarkMode = viewModel.themeProvider().shouldUseDarkMode()
    val theme = viewModel.themeProvider().theme
    SampleThemeTheme(theme = theme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = SampleThemeColors.background
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = " Theme - ${theme.name}",
                        style = SampleThemeTypography.h1,
                        modifier = Modifier.padding(24.dp)
                    )
                    Button(
                        onClick = {
                            viewModel.changeTheme(ThemeProvider.Theme.LIGHT)
                        }, colors = ButtonDefaults.buttonColors(
                            containerColor = SampleThemeColors.cardBackgroundColor
                        )
                    ) {
                        Text(text = "Light", style = SampleThemeTypography.body2)
                    }
                    Button(
                        onClick = {
                            viewModel.changeTheme(ThemeProvider.Theme.DARK)
                        }, colors = ButtonDefaults.buttonColors(
                            containerColor = SampleThemeColors.cardBackgroundColor
                        )
                    ) {
                        Text(text = "Dark", style = SampleThemeTypography.h4)
                    }
                    Button(
                        onClick = {
                            viewModel.changeTheme(ThemeProvider.Theme.SYSTEM)
                        }, colors = ButtonDefaults.buttonColors(
                            containerColor = SampleThemeColors.cardBackgroundColor
                        )
                    ) {
                        Text(text = "System", style = SampleThemeTypography.subtitle1)
                    }
                    Button(
                        onClick = {
                            viewModel.changeTheme(ThemeProvider.Theme.PINK)
                        }, colors = ButtonDefaults.buttonColors(
                            containerColor = SampleThemeColors.cardBackgroundColor
                        )
                    ) {
                        Text(text = "Other Pink", style = SampleThemeTypography.subtitle1)
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SampleThemeTheme(theme = ThemeProvider.Theme.DARK) {
        MainScreen()
    }
}