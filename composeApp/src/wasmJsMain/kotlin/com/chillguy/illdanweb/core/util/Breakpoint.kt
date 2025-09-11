package com.chillguy.illdanweb.core.util

import androidx.compose.runtime.Composable
import com.chillguy.illdanweb.domain.enums.Breakpoint

@Composable
fun rememberBreakpoint(maxWidthPx: Int): Breakpoint {
    return when {
        maxWidthPx < 640 -> Breakpoint.Compact
        maxWidthPx < 1024 -> Breakpoint.Medium
        else -> Breakpoint.Expanded
    }
}

@Composable
fun wf(bp: Breakpoint, compact: Float, medium: Float, expanded: Float): Float = when (bp) {
    Breakpoint.Compact  -> compact
    Breakpoint.Medium   -> medium
    Breakpoint.Expanded -> expanded
}