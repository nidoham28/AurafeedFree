package com.aurafeed.free

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aurafeed.free.core.navigation.Splash
import com.aurafeed.free.features.splash.screen.SplashScreen
import com.aurafeed.free.ui.theme.AurafeedTheme

@Composable
fun App() {
    AurafeedTheme {
        // Surface paints the scheme's background — MaterialTheme alone doesn't
        Surface(modifier = Modifier.fillMaxSize()) {
            // TODO: nav host / scaffold / feed content
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = Splash
            ) {
                composable<Splash> {
                    SplashScreen(
                        onFinished = {
                        }
                    )
                }
            }
        }
    }
}