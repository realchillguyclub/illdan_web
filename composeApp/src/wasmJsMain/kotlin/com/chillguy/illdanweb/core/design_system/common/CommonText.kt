package com.chillguy.illdanweb.core.design_system.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Density
import com.chillguy.illdanweb.core.extensions.ui.toTextStyle
import com.chillguy.illdanweb.domain.enums.AppTextStyle

@Composable
fun CommonText(
    text: String,
    style: AppTextStyle,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    val textStyle = style.toTextStyle()

    CompositionLocalProvider(LocalDensity provides Density(LocalDensity.current.density, fontScale = 1f)) {
        Text(
            text = text,
            style = textStyle,
            color = color,
            modifier = modifier,
            textAlign = textAlign,
            maxLines = maxLines,
            overflow = overflow
        )
    }
}