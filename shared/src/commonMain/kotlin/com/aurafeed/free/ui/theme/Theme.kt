package com.aurafeed.free.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// ==================== COLOR SCHEMES ====================

private val LightColors: ColorScheme = lightColorScheme(
    primary = AppColors.md_theme_light_primary,
    onPrimary = AppColors.md_theme_light_onPrimary,
    primaryContainer = AppColors.md_theme_light_primaryContainer,
    onPrimaryContainer = AppColors.md_theme_light_onPrimaryContainer,
    inversePrimary = AppColors.md_theme_light_inversePrimary,
    secondary = AppColors.md_theme_light_secondary,
    onSecondary = AppColors.md_theme_light_onSecondary,
    secondaryContainer = AppColors.md_theme_light_secondaryContainer,
    onSecondaryContainer = AppColors.md_theme_light_onSecondaryContainer,
    tertiary = AppColors.md_theme_light_tertiary,
    onTertiary = AppColors.md_theme_light_onTertiary,
    tertiaryContainer = AppColors.md_theme_light_tertiaryContainer,
    onTertiaryContainer = AppColors.md_theme_light_onTertiaryContainer,
    error = AppColors.md_theme_light_error,
    onError = AppColors.md_theme_light_onError,
    errorContainer = AppColors.md_theme_light_errorContainer,
    onErrorContainer = AppColors.md_theme_light_onErrorContainer,
    background = AppColors.md_theme_light_background,
    onBackground = AppColors.md_theme_light_onBackground,
    surface = AppColors.md_theme_light_surface,
    onSurface = AppColors.md_theme_light_onSurface,
    surfaceVariant = AppColors.md_theme_light_surfaceVariant,
    onSurfaceVariant = AppColors.md_theme_light_onSurfaceVariant,
    surfaceContainerLowest = AppColors.md_theme_light_surfaceContainerLowest,
    surfaceContainerLow = AppColors.md_theme_light_surfaceContainerLow,
    surfaceContainer = AppColors.md_theme_light_surfaceContainer,
    surfaceContainerHigh = AppColors.md_theme_light_surfaceContainerHigh,
    surfaceContainerHighest = AppColors.md_theme_light_surfaceContainerHighest,
    outline = AppColors.md_theme_light_outline,
    outlineVariant = AppColors.md_theme_light_outlineVariant,
    scrim = AppColors.md_theme_light_scrim,
    inverseSurface = AppColors.md_theme_light_inverseSurface,
    inverseOnSurface = AppColors.md_theme_light_inverseOnSurface,
)

private val DarkColors: ColorScheme = darkColorScheme(
    primary = AppColors.md_theme_dark_primary,
    onPrimary = AppColors.md_theme_dark_onPrimary,
    primaryContainer = AppColors.md_theme_dark_primaryContainer,
    onPrimaryContainer = AppColors.md_theme_dark_onPrimaryContainer,
    inversePrimary = AppColors.md_theme_dark_inversePrimary,
    secondary = AppColors.md_theme_dark_secondary,
    onSecondary = AppColors.md_theme_dark_onSecondary,
    secondaryContainer = AppColors.md_theme_dark_secondaryContainer,
    onSecondaryContainer = AppColors.md_theme_dark_onSecondaryContainer,
    tertiary = AppColors.md_theme_dark_tertiary,
    onTertiary = AppColors.md_theme_dark_tertiary,
    tertiaryContainer = AppColors.md_theme_dark_tertiaryContainer,
    onTertiaryContainer = AppColors.md_theme_dark_onTertiaryContainer,
    error = AppColors.md_theme_dark_error,
    onError = AppColors.md_theme_dark_onError,
    errorContainer = AppColors.md_theme_dark_errorContainer,
    onErrorContainer = AppColors.md_theme_dark_onErrorContainer,
    background = AppColors.md_theme_dark_background,
    onBackground = AppColors.md_theme_dark_onBackground,
    surface = AppColors.md_theme_dark_surface,
    onSurface = AppColors.md_theme_dark_onSurface,
    surfaceVariant = AppColors.md_theme_dark_surfaceVariant,
    onSurfaceVariant = AppColors.md_theme_dark_onSurfaceVariant,
    surfaceContainerLowest = AppColors.md_theme_dark_surfaceContainerLowest,
    surfaceContainerLow = AppColors.md_theme_dark_surfaceContainerLow,
    surfaceContainer = AppColors.md_theme_dark_surfaceContainer,
    surfaceContainerHigh = AppColors.md_theme_dark_surfaceContainerHigh,
    surfaceContainerHighest = AppColors.md_theme_dark_surfaceContainerHighest,
    outline = AppColors.md_theme_dark_outline,
    outlineVariant = AppColors.md_theme_dark_outlineVariant,
    scrim = AppColors.md_theme_dark_scrim,
    inverseSurface = AppColors.md_theme_dark_inverseSurface,
    inverseOnSurface = AppColors.md_theme_dark_inverseOnSurface,
    // Neutral AMOLED elevation — kills the default blue tonal-blend tint
    surfaceTint = Color.Transparent,
)

// ==================== EXTENDED COLORS ====================

/** `List<Color>` alone makes this unstable — @Immutable restores skippability. */
@Immutable
data class ExtendedColors(
    val like: Color,
    val likeFilled: Color,
    val verifiedBadge: Color,
    val online: Color,
    val offline: Color,
    val newBadge: Color,
    val storyGradient: List<Color>,
    val storySeenRing: Color,
    val bubbleOutgoing: Color,
    val bubbleOutgoingText: Color,
    val bubbleIncoming: Color,
    val bubbleIncomingText: Color,
    val shimmerBase: Color,
    val shimmerHighlight: Color,
)

/** Single source of truth for assembling extended colors — no duplication. */
private fun extendedColors(darkTheme: Boolean): ExtendedColors = ExtendedColors(
    like = AppColors.like,
    likeFilled = AppColors.likeFilled,
    verifiedBadge = AppColors.verifiedBadge,
    online = AppColors.online,
    offline = AppColors.offline,
    newBadge = AppColors.newBadge,
    storyGradient = AppColors.storyGradient,
    storySeenRing = AppColors.storySeenRing,
    bubbleOutgoing = AppColors.bubbleOutgoing,
    bubbleOutgoingText = AppColors.bubbleOutgoingText,
    bubbleIncoming = if (darkTheme) AppColors.bubbleIncomingDark else AppColors.bubbleIncomingLight,
    bubbleIncomingText = if (darkTheme) AppColors.bubbleIncomingTextDark else AppColors.bubbleIncomingTextLight,
    shimmerBase = if (darkTheme) AppColors.shimmerBaseDark else AppColors.shimmerBaseLight,
    shimmerHighlight = if (darkTheme) AppColors.shimmerHighlightDark else AppColors.shimmerHighlightLight,
)

private val LocalExtendedColors = staticCompositionLocalOf {
    extendedColors(darkTheme = false)
}

/** Access anywhere: `MaterialTheme.extendedColors.like`, `.bubbleOutgoing`, etc. */
val MaterialTheme.extendedColors: ExtendedColors
    @Composable get() = LocalExtendedColors.current

// ==================== THEME ====================

/**
 * Root theme. Pass an explicit [darkTheme] from your app state for a
 * user-controlled toggle, or rely on the default to follow the [ThemeManager] preference.
 */
@Composable
fun AurafeedTheme(
    darkTheme: Boolean = ThemeManager.isDarkTheme(),
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalExtendedColors provides extendedColors(darkTheme),
    ) {
        MaterialTheme(
            colorScheme = if (darkTheme) DarkColors else LightColors,
            typography = AppTypography,
            shapes = AppShapes,
            content = content,
        )
    }
}