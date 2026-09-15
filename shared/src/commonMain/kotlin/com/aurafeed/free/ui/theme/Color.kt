package com.aurafeed.free.ui.theme

import androidx.compose.ui.graphics.Color

object AppColors {

    // ==================== LIGHT THEME ====================
    val md_theme_light_primary = Color(0xFF6750A4)
    val md_theme_light_onPrimary = Color(0xFFFFFFFF)
    val md_theme_light_primaryContainer = Color(0xFFEADDFF)
    val md_theme_light_onPrimaryContainer = Color(0xFF21005D)

    val md_theme_light_secondary = Color(0xFF625B71)
    val md_theme_light_onSecondary = Color(0xFFFFFFFF)
    val md_theme_light_secondaryContainer = Color(0xFFE8DEF8)
    val md_theme_light_onSecondaryContainer = Color(0xFF1D192B)

    val md_theme_light_tertiary = Color(0xFF7D5260)
    val md_theme_light_onTertiary = Color(0xFFFFFFFF)
    val md_theme_light_tertiaryContainer = Color(0xFFFFD8E4)
    val md_theme_light_onTertiaryContainer = Color(0xFF31111D)

    val md_theme_light_error = Color(0xFFB3261E)
    val md_theme_light_onError = Color(0xFFFFFFFF)
    val md_theme_light_errorContainer = Color(0xFFF9DEDC)
    val md_theme_light_onErrorContainer = Color(0xFF410E0B)

    val md_theme_light_background = Color(0xFFFEF7FF)
    val md_theme_light_onBackground = Color(0xFF1D1B20)
    val md_theme_light_surface = Color(0xFFFEF7FF)
    val md_theme_light_onSurface = Color(0xFF1D1B20)
    val md_theme_light_surfaceVariant = Color(0xFFE7E0EC)
    val md_theme_light_onSurfaceVariant = Color(0xFF49454F)
    val md_theme_light_outline = Color(0xFF79747E)

    // NEW — elevation tiers + slots that previously fell back to baseline purple
    val md_theme_light_surfaceContainerLowest = Color(0xFFFFFFFF)
    val md_theme_light_surfaceContainerLow = Color(0xFFF7F2FA)
    val md_theme_light_surfaceContainer = Color(0xFFF2ECF4)
    val md_theme_light_surfaceContainerHigh = Color(0xFFECE6EE)
    val md_theme_light_surfaceContainerHighest = Color(0xFFE6E0E9)
    val md_theme_light_outlineVariant = Color(0xFFCAC4D0)
    val md_theme_light_inverseSurface = Color(0xFF322F35)
    val md_theme_light_inverseOnSurface = Color(0xFFF4EFF4)
    val md_theme_light_inversePrimary = Color(0xFFD0BCFF)
    val md_theme_light_scrim = Color(0xFF000000)

    // ==================== DARK THEME (Telegram-style, AMOLED black + bright blue) ====================
    val md_theme_dark_primary = Color(0xFF2AABEE)             // Telegram signature blue
    val md_theme_dark_onPrimary = Color(0xFF00121F)
    val md_theme_dark_primaryContainer = Color(0xFF0A3A5C)
    val md_theme_dark_onPrimaryContainer = Color(0xFF9FD8FF)

    val md_theme_dark_secondary = Color(0xFF64B5F6)
    val md_theme_dark_onSecondary = Color(0xFF00131F)
    val md_theme_dark_secondaryContainer = Color(0xFF0F2C3F)
    val md_theme_dark_onSecondaryContainer = Color(0xFFC7E7FF)

    val md_theme_dark_tertiary = Color(0xFF40C4FF)
    val md_theme_dark_onTertiary = Color(0xFF00212E)
    val md_theme_dark_tertiaryContainer = Color(0xFF003547)
    val md_theme_dark_onTertiaryContainer = Color(0xFFB8EAFF)

    val md_theme_dark_error = Color(0xFFFF6B6B)
    val md_theme_dark_onError = Color(0xFF3A0000)
    val md_theme_dark_errorContainer = Color(0xFF5C0F0F)
    val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)

    // True AMOLED black backgrounds
    val md_theme_dark_background = Color(0xFF000000)
    val md_theme_dark_onBackground = Color(0xFFE3E8EC)
    val md_theme_dark_surface = Color(0xFF000000)
    val md_theme_dark_onSurface = Color(0xFFE3E8EC)
    val md_theme_dark_surfaceVariant = Color(0xFF121B22)
    val md_theme_dark_onSurfaceVariant = Color(0xFF9AA7B0)
    val md_theme_dark_outline = Color(0xFF3A444C)

    // NEW — slots that previously fell back to baseline defaults
    val md_theme_dark_outlineVariant = Color(0xFF2A343C)
    val md_theme_dark_inverseSurface = Color(0xFFE3E8EC)
    val md_theme_dark_inverseOnSurface = Color(0xFF10171C)
    val md_theme_dark_inversePrimary = Color(0xFF9FD8FF)
    val md_theme_dark_scrim = Color(0xFF000000)

    // Elevation tiers (bottom bar, dialogs, elevated cards)
    val md_theme_dark_surfaceContainerLowest = Color(0xFF000000)
    val md_theme_dark_surfaceContainerLow = Color(0xFF0A0F13)
    val md_theme_dark_surfaceContainer = Color(0xFF10171C)
    val md_theme_dark_surfaceContainerHigh = Color(0xFF172026)
    val md_theme_dark_surfaceContainerHighest = Color(0xFF1E2830)

    // ==================== SOCIAL MEDIA SEMANTIC COLORS ====================
    // Brand/status colors — constant across light & dark
    val like = Color(0xFFED4956)
    val likeFilled = Color(0xFFFF3040)
    val verifiedBadge = Color(0xFF2AABEE)
    val online = Color(0xFF2ECC71)
    val offline = Color(0xFF9E9E9E)
    val newBadge = Color(0xFF2AABEE)

    // Story ring gradient (Instagram-style)
    val storyGradient = listOf(
        Color(0xFFF9CE34),
        Color(0xFFEE2A7B),
        Color(0xFF6228D7),
    )
    val storySeenRing = Color(0xFFB0B0B0)

    // Chat bubbles
    val bubbleOutgoing = Color(0xFF2AABEE)
    val bubbleOutgoingText = Color(0xFFFFFFFF)
    val bubbleIncomingDark = Color(0xFF17212B)
    val bubbleIncomingTextDark = Color(0xFFE3E8EC)
    val bubbleIncomingLight = Color(0xFFE7E0EC)   // = light surfaceVariant
    val bubbleIncomingTextLight = Color(0xFF1D1B20) // onSurface — better contrast than grey

    // Shimmer / skeleton loading placeholders
    val shimmerBaseLight = Color(0xFFE0E0E0)
    val shimmerHighlightLight = Color(0xFFF5F5F5)
    val shimmerBaseDark = Color(0xFF0F1419)
    val shimmerHighlightDark = Color(0xFF1C242B)

    // Brand status colors
    val success = Color(0xFF2ECC71)
    val warning = Color(0xFFF1C40F)
}