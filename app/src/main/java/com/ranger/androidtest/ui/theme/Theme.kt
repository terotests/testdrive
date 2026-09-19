package com.ranger.androidtest.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = OnScreen,
    onPrimary = ScreenBackground,
    background = ScreenBackground,
    onBackground = OnScreen,
    surface = ScreenBackground,
    onSurface = OnScreen,
)

@Composable
fun RangerAndroidTheme(
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = RangerTypography,
        content = content,
    )
}
