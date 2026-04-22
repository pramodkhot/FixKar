package com.fixkar.app.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColors = lightColorScheme(
    primary      = FixKarOrange,
    onPrimary    = Color.White,
    primaryContainer = FixKarOrangeLight,
    onPrimaryContainer = Color.Black,
    secondary    = FixKarGreen,
    onSecondary  = Color.White,
    error        = FixKarRed,
    onError      = Color.White,
    background   = FixKarBackground,
    onBackground = FixKarOnSurface,
    surface      = FixKarSurface,
    onSurface    = FixKarOnSurface,
)

private val DarkColors = darkColorScheme(
    primary      = FixKarOrangeLight,
    onPrimary    = Color.Black,
    secondary    = FixKarGreen,
    error        = FixKarRed,
)

/**
 * App theme.
 *
 * dynamicColor — on Android 12+, wallpaper-based Material You colors. We keep it
 * OFF by default to preserve the brand orange. Flip to true if you want dynamic.
 */
@Composable
fun FixKarTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val ctx = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(ctx) else dynamicLightColorScheme(ctx)
        }
        darkTheme -> DarkColors
        else      -> LightColors
    }

    MaterialTheme(
        colorScheme = colors,
        typography  = FixKarTypography,
        content     = content
    )
}
