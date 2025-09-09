package com.chillguy.illdanweb.core.design_system

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

val LocalAppTypography = staticCompositionLocalOf<AppTypography> {
    error("No AppTypography provided")
}

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    val typography = appTypo()

    CompositionLocalProvider(
        LocalAppTypography provides typography,
    ) {
        content()
    }
}