package com.aurafeed.free

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.aurafeed.free.ui.theme.ThemeManager
import com.russhwolf.settings.PreferencesSettings
import java.util.prefs.Preferences

class Main {
    companion object {
        fun main() {
            // Standard JVM preferences API, persisted automatically
            val prefs = Preferences.userRoot().node("com.aurafeed.free.settings")
            ThemeManager.init(PreferencesSettings(prefs))

            application {
                Window(
                    onCloseRequest = ::exitApplication,
                    title = "Aurafeed Free",
                ) {
                    App()
                }
            }
        }
    }
}
