/*
 * Zalith Launcher 2
 * Copyright (C) 2025 MovTery <movtery228@qq.com> and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/gpl-3.0.txt>.
 */

package app.sojico.native.ui.theme

import android.os.Build
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialExpressiveTheme
import androidx.compose.material3.MotionScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.materialkolor.PaletteStyle
import com.materialkolor.dynamicColorScheme
import com.movtery.zalithlauncher.setting.AllSettings
import com.movtery.zalithlauncher.setting.enums.isLauncherInDarkTheme
import com.movtery.zalithlauncher.ui.theme.components.activeMaskView
import com.movtery.zalithlauncher.utils.festival.Festival
import com.movtery.zalithlauncher.utils.festival.LocalFestivals
import com.movtery.zalithlauncher.viewmodel.BackgroundViewModel
import com.movtery.zalithlauncher.viewmodel.LocalBackgroundViewModel

private val iMessageLight = lightColorScheme(
    primary = Color(0xFF34C759),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFB9F8C9),
    onPrimaryContainer = Color(0xFF0A2D14),
    secondary = Color(0xFFE5E5EA),
    onSecondary = Color(0xFF1D1D1F),
    secondaryContainer = Color(0xFFF2F2F7),
    onSecondaryContainer = Color(0xFF1D1D1F),
    tertiary = Color(0xFF007AFF),
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFD9EBFF),
    onTertiaryContainer = Color(0xFF022B5F),
    error = Color(0xFFFF4D4F),
    onError = Color.White,
    errorContainer = Color(0xFFFFDCDD),
    onErrorContainer = Color(0xFF661A1C),
    background = Color(0xFFF5F5F5),
    onBackground = Color(0xFF1D1D1F),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF1D1D1F),
    surfaceVariant = Color(0xFFEAF0F7),
    onSurfaceVariant = Color(0xFF404041),
    outline = Color(0xFFDDE1E7),
    outlineVariant = Color(0xFFEDEFF2),
    scrim = Color(0xFF000000),
    inverseSurface = Color(0xFF2D2D2F),
    inverseOnSurface = Color.White,
    inversePrimary = Color(0xFF7BE4A0),
    surfaceDim = Color(0xFFE8E8E8),
    surfaceBright = Color.White,
    surfaceContainerLowest = Color(0xFFFFFFFF),
    surfaceContainerLow = Color(0xFFF5F5F5),
    surfaceContainer = Color(0xFFF0F0F0),
    surfaceContainerHigh = Color(0xFFE9E9EA),
    surfaceContainerHighest = Color(0xFFE3E3E6),
)

private val iMessageDark = darkColorScheme(
    primary = Color(0xFF34C759),
    onPrimary = Color.White,
    primaryContainer = Color(0xFF144F28),
    onPrimaryContainer = Color(0xFFC4F6D0),
    secondary = Color(0xFF2C2C2E),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFF3A3A3C),
    onSecondaryContainer = Color(0xFFF0F0F0),
    tertiary = Color(0xFF58A6FF),
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFF174A7D),
    onTertiaryContainer = Color(0xFFD8E9FF),
    error = Color(0xFFFF6B6B),
    onError = Color.White,
    errorContainer = Color(0xFF4D1A1D),
    onErrorContainer = Color(0xFFFFCDD2),
    background = Color(0xFF0F1012),
    onBackground = Color(0xFFF2F2F7),
    surface = Color(0xFF18191C),
    onSurface = Color(0xFFF2F2F7),
    surfaceVariant = Color(0xFF202124),
    onSurfaceVariant = Color(0xFFDBDFE6),
    outline = Color(0xFF2E3136),
    outlineVariant = Color(0xFF3A3C40),
    scrim = Color(0xFF000000),
    inverseSurface = Color(0xFFE9EAED),
    inverseOnSurface = Color(0xFF1F2124),
    inversePrimary = Color(0xFF2C8A47),
    surfaceDim = Color(0xFF111214),
    surfaceBright = Color(0xFF282A2D),
    surfaceContainerLowest = Color(0xFF0E0F12),
    surfaceContainerLow = Color(0xFF14171A),
    surfaceContainer = Color(0xFF1A1D20),
    surfaceContainerHigh = Color(0xFF23282D),
    surfaceContainerHighest = Color(0xFF2A2F34),
)

private val embermireLight = lightColorScheme(
    primary = primaryLight.embermire,
    onPrimary = onPrimaryLight.embermire,
    primaryContainer = primaryContainerLight.embermire,
    onPrimaryContainer = onPrimaryContainerLight.embermire,
    secondary = secondaryLight.embermire,
    onSecondary = onSecondaryLight.embermire,
    secondaryContainer = secondaryContainerLight.embermire,
    onSecondaryContainer = onSecondaryContainerLight.embermire,
    tertiary = tertiaryLight.embermire,
    onTertiary = onTertiaryLight.embermire,
    tertiaryContainer = tertiaryContainerLight.embermire,
    onTertiaryContainer = onTertiaryContainerLight.embermire,
    error = errorLight.embermire,
    onError = onErrorLight.embermire,
    errorContainer = errorContainerLight.embermire,
    onErrorContainer = onErrorContainerLight.embermire,
    background = backgroundLight.embermire,
    onBackground = onBackgroundLight.embermire,
    surface = surfaceLight.embermire,
    onSurface = onSurfaceLight.embermire,
    surfaceVariant = surfaceVariantLight.embermire,
    onSurfaceVariant = onSurfaceVariantLight.embermire,
    outline = outlineLight.embermire,
    outlineVariant = outlineVariantLight.embermire,
    scrim = scrimLight.embermire,
    inverseSurface = inverseSurfaceLight.embermire,
    inverseOnSurface = inverseOnSurfaceLight.embermire,
    inversePrimary = inversePrimaryLight.embermire,
    surfaceDim = surfaceDimLight.embermire,
    surfaceBright = surfaceBrightLight.embermire,
    surfaceContainerLowest = surfaceContainerLowestLight.embermire,
    surfaceContainerLow = surfaceContainerLowLight.embermire,
    surfaceContainer = surfaceContainerLight.embermire,
    surfaceContainerHigh = surfaceContainerHighLight.embermire,
    surfaceContainerHighest = surfaceContainerHighestLight.embermire,
)

private val embermireDark = darkColorScheme(
    primary = primaryDark.embermire,
    onPrimary = onPrimaryDark.embermire,
    primaryContainer = primaryContainerDark.embermire,
    onPrimaryContainer = onPrimaryContainerDark.embermire,
    secondary = secondaryDark.embermire,
    onSecondary = onSecondaryDark.embermire,
    secondaryContainer = secondaryContainerDark.embermire,
    onSecondaryContainer = onSecondaryContainerDark.embermire,
    tertiary = tertiaryDark.embermire,
    onTertiary = onTertiaryDark.embermire,
    tertiaryContainer = tertiaryContainerDark.embermire,
    onTertiaryContainer = onTertiaryContainerDark.embermire,
    error = errorDark.embermire,
    onError = onErrorDark.embermire,
    errorContainer = errorContainerDark.embermire,
    onErrorContainer = onErrorContainerDark.embermire,
    background = backgroundDark.embermire,
    onBackground = onBackgroundDark.embermire,
    surface = surfaceDark.embermire,
    onSurface = onSurfaceDark.embermire,
    surfaceVariant = surfaceVariantDark.embermire,
    onSurfaceVariant = onSurfaceVariantDark.embermire,
    outline = outlineDark.embermire,
    outlineVariant = outlineVariantDark.embermire,
    scrim = scrimDark.embermire,
    inverseSurface = inverseSurfaceDark.embermire,
    inverseOnSurface = inverseOnSurfaceDark.embermire,
    inversePrimary = inversePrimaryDark.embermire,
    surfaceDim = surfaceDimDark.embermire,
    surfaceBright = surfaceBrightDark.embermire,
    surfaceContainerLowest = surfaceContainerLowestDark.embermire,
    surfaceContainerLow = surfaceContainerLowDark.embermire,
    surfaceContainer = surfaceContainerDark.embermire,
    surfaceContainerHigh = surfaceContainerHighDark.embermire,
    surfaceContainerHighest = surfaceContainerHighestDark.embermire,
)

private val mistwaveLight = lightColorScheme(
    primary = primaryLight.mistwave,
    onPrimary = onPrimaryLight.mistwave,
    primaryContainer = primaryContainerLight.mistwave,
    onPrimaryContainer = onPrimaryContainerLight.mistwave,
    secondary = secondaryLight.mistwave,
    onSecondary = onSecondaryLight.mistwave,
    secondaryContainer = secondaryContainerLight.mistwave,
    onSecondaryContainer = onSecondaryContainerLight.mistwave,
    tertiary = tertiaryLight.mistwave,
    onTertiary = onTertiaryLight.mistwave,
    tertiaryContainer = tertiaryContainerLight.mistwave,
    onTertiaryContainer = onTertiaryContainerLight.mistwave,
    error = errorLight.mistwave,
    onError = onErrorLight.mistwave,
    errorContainer = errorContainerLight.mistwave,
    onErrorContainer = onErrorContainerLight.mistwave,
    background = backgroundLight.mistwave,
    onBackground = onBackgroundLight.mistwave,
    surface = surfaceLight.mistwave,
    onSurface = onSurfaceLight.mistwave,
    surfaceVariant = surfaceVariantLight.mistwave,
    onSurfaceVariant = onSurfaceVariantLight.mistwave,
    outline = outlineLight.mistwave,
    outlineVariant = outlineVariantLight.mistwave,
    scrim = scrimLight.mistwave,
    inverseSurface = inverseSurfaceLight.mistwave,
    inverseOnSurface = inverseOnSurfaceLight.mistwave,
    inversePrimary = inversePrimaryLight.mistwave,
    surfaceDim = surfaceDimLight.mistwave,
    surfaceBright = surfaceBrightLight.mistwave,
    surfaceContainerLowest = surfaceContainerLowestLight.mistwave,
    surfaceContainerLow = surfaceContainerLowLight.mistwave,
    surfaceContainer = surfaceContainerLight.mistwave,
    surfaceContainerHigh = surfaceContainerHighLight.mistwave,
    surfaceContainerHighest = surfaceContainerHighestLight.mistwave,
)

private val mistwaveDark = darkColorScheme(
    primary = primaryDark.mistwave,
    onPrimary = onPrimaryDark.mistwave,
    primaryContainer = primaryContainerDark.mistwave,
    onPrimaryContainer = onPrimaryContainerDark.mistwave,
    secondary = secondaryDark.mistwave,
    onSecondary = onSecondaryDark.mistwave,
    secondaryContainer = secondaryContainerDark.mistwave,
    onSecondaryContainer = onSecondaryContainerDark.mistwave,
    tertiary = tertiaryDark.mistwave,
    onTertiary = onTertiaryDark.mistwave,
    tertiaryContainer = tertiaryContainerDark.mistwave,
    onTertiaryContainer = onTertiaryContainerDark.mistwave,
    error = errorDark.mistwave,
    onError = onErrorDark.mistwave,
    errorContainer = errorContainerDark.mistwave,
    onErrorContainer = onErrorContainerDark.mistwave,
    background = backgroundDark.mistwave,
    onBackground = onBackgroundDark.mistwave,
    surface = surfaceDark.mistwave,
    onSurface = onSurfaceDark.mistwave,
    surfaceVariant = surfaceVariantDark.mistwave,
    onSurfaceVariant = onSurfaceVariantDark.mistwave,
    outline = outlineDark.mistwave,
    outlineVariant = outlineVariantDark.mistwave,
    scrim = scrimDark.mistwave,
    inverseSurface = inverseSurfaceDark.mistwave,
    inverseOnSurface = inverseOnSurfaceDark.mistwave,
    inversePrimary = inversePrimaryDark.mistwave,
    surfaceDim = surfaceDimDark.mistwave,
    surfaceBright = surfaceBrightDark.mistwave,
    surfaceContainerLowest = surfaceContainerLowestDark.mistwave,
    surfaceContainerLow = surfaceContainerLowDark.mistwave,
    surfaceContainer = surfaceContainerDark.mistwave,
    surfaceContainerHigh = surfaceContainerHighDark.mistwave,
    surfaceContainerHighest = surfaceContainerHighestDark.mistwave,
)

private fun customLight(
    color: Color,
    style: PaletteStyle,
): ColorScheme {
    return dynamicColorScheme(
        primary = color,
        isDark = false,
        style = style,
    )
}

private fun customDark(
    color: Color,
    style: PaletteStyle,
): ColorScheme {
    return dynamicColorScheme(
        primary = color,
        isDark = true,
        style = style,
    )
}

@Composable
fun ZalithLauncherTheme(
    darkTheme: Boolean = isLauncherInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    backgroundViewModel: BackgroundViewModel? = null,
    festivals: List<Festival> = emptyList(),
    content: @Composable () -> Unit
) {
    val colorTheme = AllSettings.launcherColorTheme.state
    val customColorInt = AllSettings.launcherCustomColor.state
    val customColor = Color(customColorInt)
    val customPaletteStyle = AllSettings.launcherCustomPaletteStyle.state

    val context = LocalContext.current

    val targetColorScheme = remember(darkTheme, dynamicColor, colorTheme, customColor, customPaletteStyle) {
        when {
            dynamicColor && colorTheme == ColorThemeType.DYNAMIC && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            }

            darkTheme -> when (colorTheme) {
                ColorThemeType.EMBERMIRE -> embermireDark
                ColorThemeType.VELVET_ROSE -> velvetRoseDark
                ColorThemeType.MISTWAVE -> iMessageDark
                ColorThemeType.GLACIER -> glacierDark
                ColorThemeType.VERDANTFIELD -> verdantFieldDark
                ColorThemeType.URBAN_ASH -> urbanAshDark
                ColorThemeType.VERDANT_DAWN -> verdantDawnDark
                ColorThemeType.CUSTOM -> customDark(
                    color = customColor,
                    style = customPaletteStyle
                )
                else -> iMessageDark
            }

            else -> when (colorTheme) {
                ColorThemeType.EMBERMIRE -> embermireLight
                ColorThemeType.VELVET_ROSE -> velvetRoseLight
                ColorThemeType.MISTWAVE -> iMessageLight
                ColorThemeType.GLACIER -> glacierLight
                ColorThemeType.VERDANTFIELD -> verdantFieldLight
                ColorThemeType.URBAN_ASH -> urbanAshLight
                ColorThemeType.VERDANT_DAWN -> verdantDawnLight
                ColorThemeType.CUSTOM -> customLight(
                    color = customColor,
                    style = customPaletteStyle
                )
                else -> iMessageLight
            }
        }
    }

    var currentDarkTheme by remember { mutableStateOf(darkTheme) }
    var currentDisplayScheme by remember { mutableStateOf(targetColorScheme) }

    LaunchedEffect(darkTheme, targetColorScheme) {
        if (darkTheme != currentDarkTheme) {
            context.activeMaskView(
                maskComplete = {
                    currentDarkTheme = darkTheme
                    currentDisplayScheme = targetColorScheme
                },
                maskAnimFinish = {

                }
            )
        } else {
            currentDarkTheme = darkTheme
            currentDisplayScheme = targetColorScheme
        }
    }

    CompositionLocalProvider(
        LocalBackgroundViewModel provides backgroundViewModel,
        LocalFestivals provides festivals
    ) {
        MaterialExpressiveTheme(
            colorScheme = currentDisplayScheme,
            motionScheme = MotionScheme.expressive(),
            typography = AppTypography,
            content = content
        )
    }
}

