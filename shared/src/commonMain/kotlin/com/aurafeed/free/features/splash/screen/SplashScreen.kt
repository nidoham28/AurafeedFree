package com.aurafeed.free.features.splash.screen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import aurafeedfree.shared.generated.resources.Res
import aurafeedfree.shared.generated.resources.app_logo
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import kotlin.time.Duration.Companion.milliseconds

/** Long enough for the spring to land + the credit fade to complete. */
private val SplashDuration = 1100.milliseconds

@Composable
fun SplashScreen(
    onFinished: () -> Unit,
    modifier: Modifier = Modifier
) {
    // ── Theme-driven palette (no hardcoded colors) ──
    val backgroundColor = MaterialTheme.colorScheme.background
    val accentColor = MaterialTheme.colorScheme.primary      // Telegram blue in dark, M3 purple in light
    val glowColor = MaterialTheme.colorScheme.tertiary       // cyan-blue in dark, mauve in light
    val contentColor = MaterialTheme.colorScheme.onSurface

    // ── Scale-in ──
    val logoScale = remember { Animatable(0f) }
    val logoAlpha = remember { Animatable(0f) }
    val creditAlpha = remember { Animatable(0f) }

    // ── Glow pulse ──
    val glow = rememberInfiniteTransition(label = "glow")
    val glowAlpha by glow.animateFloat(
        initialValue = 0.4f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "glowPulse"
    )
    val glowScale by glow.animateFloat(
        initialValue = 0.9f,
        targetValue = 1.08f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "glowBreath"
    )

    // ── Animate in + minimum brand moment, then navigate ──
    LaunchedEffect(Unit) {
        launch {
            logoScale.animateTo(
                1f,
                spring(dampingRatio = 0.7f, stiffness = 200f)
            )
        }
        launch { logoAlpha.animateTo(1f, tween(300)) }
        launch {
            delay(350.milliseconds)
            creditAlpha.animateTo(1f, tween(500))
        }
        delay(SplashDuration)
        onFinished()
    }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = backgroundColor   // AMOLED #000000 in dark, #FEF7FF in light
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding(),
            contentAlignment = Alignment.Center
        ) {
            // ── Breathing radial glow (theme colors, animated layer alpha) ──
            Box(
                modifier = Modifier
                    .size(280.dp)
                    .graphicsLayer {
                        scaleX = glowScale
                        scaleY = glowScale
                        alpha = glowAlpha
                    }
                    .clip(CircleShape)
            )

            // ── Logo with spring scale-in + fade ──
            Icon(
                painter = painterResource(Res.drawable.app_logo),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(240.dp)
                    .graphicsLayer {
                        scaleX = logoScale.value
                        scaleY = logoScale.value
                        alpha = logoAlpha.value
                    }
            )

            // ── Developer credit (onSurface → visible in BOTH themes) ──
            Text(
                text = buildAnnotatedString {
                    append("Developed by ")
                    withStyle(
                        SpanStyle(
                            color = contentColor,
                            fontWeight = FontWeight.SemiBold
                        )
                    ) {
                        append("NI Doha Mondol")
                    }
                },
                color = contentColor.copy(alpha = 0.55f),
                style = MaterialTheme.typography.bodySmall,
                letterSpacing = 0.5.sp,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 28.dp)
                    .graphicsLayer { alpha = creditAlpha.value }
            )
        }
    }
}