package com.chillguy.illdanweb.core.extensions.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import com.chillguy.illdanweb.core.design_system.LocalAppTypography
import com.chillguy.illdanweb.domain.enums.AppTextStyle

@Composable
fun AppTextStyle.toTextStyle(): TextStyle {
    val typo = LocalAppTypography.current

    return when (this) {
        AppTextStyle.TitleLargeL -> typo.titleLargeL
        AppTextStyle.TitleLargeM -> typo.titleLargeM
        AppTextStyle.TitleLargeR -> typo.titleLargeR
        AppTextStyle.TitleMediumSB -> typo.titleMediumSB
        AppTextStyle.TitleMediumM -> typo.titleMediumM
        AppTextStyle.TitleMediumL -> typo.titleMediumL
        AppTextStyle.TitleMediumR -> typo.titleMediumR
        AppTextStyle.TitleSmallM -> typo.titleSmallM
        AppTextStyle.TitleSmallR -> typo.titleSmallR
        AppTextStyle.TitleSmallSB -> typo.titleSmallSB
        AppTextStyle.BodyLargeSB -> typo.bodyLargeSB
        AppTextStyle.BodyLargeR1 -> typo.bodyLargeR1
        AppTextStyle.BodyLargeR2 -> typo.bodyLargeR2
        AppTextStyle.BodyMediumM -> typo.bodyMediumM
        AppTextStyle.BodyMediumR -> typo.bodyMediumR
        AppTextStyle.BodyMediumSB -> typo.bodyMediumSB
        AppTextStyle.BodySmallR1 -> typo.bodySmallR1
        AppTextStyle.BodySmallR2 -> typo.bodySmallR2
        AppTextStyle.BodySmallR3 -> typo.bodySmallR3
        AppTextStyle.TempTitle -> typo.tempTitle
        AppTextStyle.TempBody -> typo.tempBody
        AppTextStyle.TempContent -> typo.tempContent
    }
}