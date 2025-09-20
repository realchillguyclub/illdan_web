package com.chillguy.illdanweb.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.chillguy.illdanweb.core.design_system.AppColor.BACKGROUND1
import com.chillguy.illdanweb.core.design_system.AppColor.BACKGROUND2
import com.chillguy.illdanweb.core.design_system.AppColor.BACKGROUND3
import com.chillguy.illdanweb.core.design_system.AppColor.BACKGROUND4
import com.chillguy.illdanweb.core.design_system.AppColor.BLACK
import com.chillguy.illdanweb.core.design_system.AppTheme
import com.chillguy.illdanweb.core.design_system.common.CommonText
import com.chillguy.illdanweb.core.extensions.ui.toIntPx
import com.chillguy.illdanweb.core.util.rememberBreakpoint
import com.chillguy.illdanweb.core.util.rememberScale
import com.chillguy.illdanweb.core.util.wf
import com.chillguy.illdanweb.domain.enums.AppTextStyle
import com.chillguy.illdanweb.domain.enums.Breakpoint
import com.chillguy.illdanweb.domain.model.Scale
import org.jetbrains.compose.resources.painterResource

import illdanweb.composeapp.generated.resources.Res
import illdanweb.composeapp.generated.resources.compose_multiplatform
import illdanweb.composeapp.generated.resources.content1
import illdanweb.composeapp.generated.resources.content2
import illdanweb.composeapp.generated.resources.content3
import illdanweb.composeapp.generated.resources.content4
import illdanweb.composeapp.generated.resources.content5
import illdanweb.composeapp.generated.resources.ic_app
import illdanweb.composeapp.generated.resources.ic_app_store
import illdanweb.composeapp.generated.resources.ic_play_store
import org.jetbrains.compose.resources.DrawableResource

@Composable
fun App() {
    val scroll = rememberScrollState()

    AppTheme {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .safeContentPadding()
        ) {
            val bp = rememberBreakpoint(maxWidth.toIntPx())
            val scale = rememberScale(bp)
            val density = LocalDensity.current
            val gradientBrush = remember(maxHeight, density) {
                val endY = with(density) { maxHeight.toPx() * 4f + 4000f }
                Brush.verticalGradient(
                    colors = listOf(BACKGROUND4, BACKGROUND3, BACKGROUND2, BACKGROUND1),
                    startY = 0f,
                    endY = endY
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(gradientBrush)
                    .verticalScroll(scroll),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .widthIn(max = scale.contentMaxWidth)
                        .padding(horizontal = scale.gutter)
                ) {
                    Spacer(Modifier.height(scale.topSpace))

                    AppDownloadSection(scale, bp)

                    Spacer(Modifier.height(scale.spaceAfterDownload))

                    AppIntroSection()

                    Spacer(modifier = Modifier.height(195.dp))

                    ResponsiveImage(
                        res = Res.drawable.content1,
                        aspectRatio = 866f / 466f,
                        align = Alignment.Start,
                        fillFraction = wf(bp, compact = 1.0f, medium = 0.85f, expanded = 0.70f),
                        maxWidthDp = 866.dp
                    )

                    Spacer(Modifier.height(64.dp))

                    ResponsiveImage(
                        res = Res.drawable.content2,
                        aspectRatio = 717f / 298f,
                        align = Alignment.Start,
                        fillFraction = wf(bp, compact = 1.0f, medium = 0.80f, expanded = 0.62f),
                        maxWidthDp = 717.dp
                    )

                    Spacer(Modifier.height(scale.spaceAfterIntro))

                    ResponsiveImage(
                        res = Res.drawable.content3,
                        aspectRatio = 505f / 215f,
                        align = Alignment.Start,
                        fillFraction = wf(bp, compact = 1.0f, medium = 0.72f, expanded = 0.50f),
                        maxWidthDp = 505.dp
                    )

                    Spacer(Modifier.height(96.dp))

                    ResponsiveImage(
                        res = Res.drawable.content4,
                        aspectRatio = 772f / 681f,
                        align = Alignment.End,
                        fillFraction = wf(bp, compact = 1.0f, medium = 0.78f, expanded = 0.68f),
                        maxWidthDp = 772.dp
                    )

                    Spacer(Modifier.height(216.dp))

                    ResponsiveImage(
                        res = Res.drawable.content5,
                        aspectRatio = 837f / 996f,
                        align = Alignment.End,
                        fillFraction = wf(bp, compact = 1.0f, medium = 0.76f, expanded = 0.70f),
                        maxWidthDp = 837.dp
                    )

                    Spacer(Modifier.height(scale.bottomSpace))
                }
            }
        }
    }
}

@Composable
private fun AppDownloadSection(
    scale: Scale,
    bp: Breakpoint
) {
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(Res.drawable.ic_app),
            contentDescription = null,
            modifier = Modifier
                .size(scale.appIconSize)
                .clip(RoundedCornerShape(32.dp))
        )

        Spacer(Modifier.height(24.dp))

        CommonText(
            text = "계획은 적게, 행동은 빠르게",
            style = AppTextStyle.TempBody,
            color = BLACK
        )

        Spacer(Modifier.height(12.dp))

        CommonText(
            text = "일단",
            style = AppTextStyle.TempTitle,
            color = BLACK
        )

        Spacer(Modifier.height(48.dp))

        BoxWithConstraints(Modifier.fillMaxWidth()) {
            val playRatio = 235f / 70f
            val appRatio  = 235f / 70f
            val playW = scale.storeBtnHeight * playRatio
            val appW  = scale.storeBtnHeight * appRatio
            val needWidth = playW + appW + scale.storeBtnGap
            val stack = bp == Breakpoint.Compact || maxWidth < needWidth

            if (stack) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    StoreButton(Res.drawable.ic_play_store, scale.storeBtnHeight) {
                        uriHandler.openUri("https://illdan-redirect.vercel.app/")
                    }
                    Spacer(Modifier.height(scale.storeBtnGap))
                    StoreButton(Res.drawable.ic_app_store, scale.storeBtnHeight) {
                        uriHandler.openUri("https://illdan-redirect.vercel.app/")
                    }
                }
            } else {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    StoreButton(Res.drawable.ic_play_store, scale.storeBtnHeight) {
                        uriHandler.openUri("https://illdan-redirect.vercel.app/")
                    }
                    Spacer(Modifier.width(scale.storeBtnGap))
                    StoreButton(Res.drawable.ic_app_store, scale.storeBtnHeight) {
                        uriHandler.openUri("https://illdan-redirect.vercel.app/")
                    }
                }
            }
        }
    }
}

@Composable
private fun AppIntroSection() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CommonText(
            text = "우리는 일단 할 필요가 있어요",
            style = AppTextStyle.TempBody,
            color = BLACK
        )

        Spacer(Modifier.height(32.dp))

        CommonText(
            text = "일단은 계획하는 시간을 최소화하고 할 일을 완료하는 것에 집중할 수 있도록 돕는 서비스예요.\n" +
                    "캘린더앱이 불편했거나 다이어리를 쓰기 귀찮은 사람에게 최고의 해결책이 될 것이에요!",
            style = AppTextStyle.TempContent,
            textAlign = TextAlign.Center,
            color = BLACK
        )
    }
}

@Composable
private fun StoreButton(
    res: DrawableResource,
    height: Dp,
    onClick: () -> Unit
) {
    val width = height * (235f / 70f)

    Image(
        painter = painterResource(res),
        contentDescription = null,
        modifier = Modifier
            .requiredSize(width = width, height = height)
            .clip(RoundedCornerShape(12.dp))
            .clickable(onClick = onClick)
    )
}

@Composable
private fun ResponsiveImage(
    res: DrawableResource,
    aspectRatio: Float,
    align: Alignment.Horizontal,
    fillFraction: Float = 1f,
    maxWidthDp: Dp? = null
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = when (align) {
            Alignment.Start -> Alignment.Start
            Alignment.CenterHorizontally -> Alignment.CenterHorizontally
            Alignment.End -> Alignment.End
            else -> Alignment.Start
        }
    ) {
        Image(
            painter = painterResource(res),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(fillFraction)
                .then(if (maxWidthDp != null) Modifier.widthIn(max = maxWidthDp) else Modifier)
                .aspectRatio(aspectRatio)
        )
    }
}