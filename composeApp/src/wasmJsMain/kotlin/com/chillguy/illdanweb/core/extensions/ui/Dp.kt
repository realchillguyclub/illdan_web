package com.chillguy.illdanweb.core.extensions.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp

@Composable
fun Dp.toPx(): Float = with(LocalDensity.current) { this@toPx.toPx() }

@Composable
fun Dp.toIntPx(): Int = with(LocalDensity.current) { this@toIntPx.roundToPx() }

fun Dp.toPx(density: Density): Float = with(density) { this@toPx.toPx() }

fun Dp.toIntPx(density: Density): Int = with(density) { this@toIntPx.roundToPx() }