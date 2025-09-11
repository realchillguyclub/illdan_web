package com.chillguy.illdanweb.core.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.chillguy.illdanweb.domain.enums.Breakpoint
import com.chillguy.illdanweb.domain.model.Scale

@Composable
fun rememberScale(bp: Breakpoint): Scale = when (bp) {
    Breakpoint.Compact -> Scale(
        gutter = 16.dp,
        contentMaxWidth = 640.dp,
        topSpace = 96.dp,
        spaceAfterDownload = 160.dp,
        spaceAfterIntro = 120.dp,
        bottomSpace = 200.dp,
        appIconSize = 160.dp,
        storeBtnHeight = 56.dp,
        storeBtnGap = 16.dp
    )
    Breakpoint.Medium -> Scale(
        gutter = 24.dp,
        contentMaxWidth = 900.dp,
        topSpace = 140.dp,
        spaceAfterDownload = 240.dp,
        spaceAfterIntro = 160.dp,
        bottomSpace = 280.dp,
        appIconSize = 200.dp,
        storeBtnHeight = 64.dp,
        storeBtnGap = 28.dp
    )
    Breakpoint.Expanded -> Scale(
        gutter = 100.dp,
        contentMaxWidth = 1200.dp,
        topSpace = 192.dp,
        spaceAfterDownload = 328.dp,
        spaceAfterIntro = 195.dp,
        bottomSpace = 380.dp,
        appIconSize = 260.dp,
        storeBtnHeight = 70.dp,
        storeBtnGap = 60.dp
    )
}