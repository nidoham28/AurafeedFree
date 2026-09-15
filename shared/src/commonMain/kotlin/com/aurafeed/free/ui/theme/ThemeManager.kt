package com.aurafeed.free.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.russhwolf.settings.Settings

/** User-selectable theme preference. */
enum class ThemeMode { SYSTEM, LIGHT, DARK }

object ThemeManager {

    private const val KEY_THEME_MODE = "aurafeed_theme_mode"

    private var settings: Settings? = null

    /** Reactive — UI reading this recomposes automatically on change. */
    var themeMode by mutableStateOf(ThemeMode.SYSTEM)
        private set

    /** `null` = follow system; otherwise the user's explicit choice. */
    val darkThemeOverride: Boolean?
        get() = when (themeMode) {
            ThemeMode.SYSTEM -> null
            ThemeMode.LIGHT -> false
            ThemeMode.DARK -> true
        }

    val isSystemMode get() = themeMode == ThemeMode.SYSTEM
    val isLightMode get() = themeMode == ThemeMode.LIGHT
    val isDarkMode get() = themeMode == ThemeMode.DARK

    /** Effective dark state — SYSTEM resolved against the OS setting. Composable. */
    @Composable
    fun isDarkTheme(): Boolean = darkThemeOverride ?: isSystemInDarkTheme()

    /** Non-composable variant for code that already knows the OS setting. */
    fun isDarkTheme(systemIsDark: Boolean): Boolean =
        darkThemeOverride ?: systemIsDark

    /**
     * Load the persisted mode. Synchronous by design — must finish before
     * the first frame to avoid a theme flash. Call once at platform entry.
     */
    fun init(settings: Settings) {
        this.settings = settings
        themeMode = settings
            .getString(KEY_THEME_MODE, ThemeMode.SYSTEM.name)
            .toThemeModeOrNull()
            ?: ThemeMode.SYSTEM // survives corrupt/unrecognized values
    }

    fun setMode(mode: ThemeMode) {
        themeMode = mode
        // SharedPreferences.apply() / NSUserDefaults — async, main-thread safe
        settings?.putString(KEY_THEME_MODE, mode.name)
    }

    fun setDarkTheme(dark: Boolean) =
        setMode(if (dark) ThemeMode.DARK else ThemeMode.LIGHT)

    fun followSystem() = setMode(ThemeMode.SYSTEM)

    /**
     * Flip relative to the dark value actually on screen.
     */
    fun toggle(currentIsDark: Boolean) {
        setMode(if (currentIsDark) ThemeMode.LIGHT else ThemeMode.DARK)
    }

    private fun String.toThemeModeOrNull(): ThemeMode? =
        ThemeMode.entries.firstOrNull { it.name == this }
}