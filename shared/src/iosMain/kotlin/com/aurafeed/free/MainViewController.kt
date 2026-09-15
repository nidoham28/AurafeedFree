package com.aurafeed.free

import androidx.compose.ui.window.ComposeUIViewController
import com.aurafeed.free.ui.theme.ThemeManager
import com.russhwolf.settings.NSUserDefaultsSettings

fun MainViewController() = ComposeUIViewController {
    ThemeManager.init(NSUserDefaultsSettings.Factory().create("aurafeed_settings"))
    App()
}