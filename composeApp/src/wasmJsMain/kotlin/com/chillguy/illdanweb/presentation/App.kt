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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chillguy.illdanweb.core.design_system.AppColor.BACKGROUND1
import com.chillguy.illdanweb.core.design_system.AppColor.BACKGROUND2
import com.chillguy.illdanweb.core.design_system.AppColor.BACKGROUND3
import com.chillguy.illdanweb.core.design_system.AppColor.BACKGROUND4
import com.chillguy.illdanweb.core.design_system.AppColor.BLACK
import com.chillguy.illdanweb.core.design_system.AppTheme
import com.chillguy.illdanweb.core.design_system.common.CommonText
import com.chillguy.illdanweb.domain.enums.AppTextStyle
import org.jetbrains.compose.resources.painterResource

import illdanweb.composeapp.generated.resources.Res
import illdanweb.composeapp.generated.resources.compose_multiplatform
import illdanweb.composeapp.generated.resources.content1
import illdanweb.composeapp.generated.resources.content2
import illdanweb.composeapp.generated.resources.content3
import illdanweb.composeapp.generated.resources.content4
import illdanweb.composeapp.generated.resources.ic_app
import illdanweb.composeapp.generated.resources.ic_app_store
import illdanweb.composeapp.generated.resources.ic_play_store

@Composable
fun App() {
    val scroll = rememberScrollState()
    val brush = remember {
        Brush.verticalGradient(
            colors = listOf(
                BACKGROUND1,
                BACKGROUND2,
                BACKGROUND3,
                BACKGROUND4
            )
        )
    }

    AppTheme {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val gradientBrush = Brush.verticalGradient(
                colors = listOf(
                    BACKGROUND4,
                    BACKGROUND3,
                    BACKGROUND2,
                    BACKGROUND1
                ),
                startY = 0f,
                endY = constraints.maxHeight.toFloat() * 2f
            )

            Column(
                modifier = Modifier
                    .verticalScroll(scroll)
                    .background(gradientBrush)
                    .fillMaxWidth()
            ) {
                WebContent()
            }
        }
    }
}

@Composable
fun WebContent(
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(192.dp))

        AppDownloadSection()

        Spacer(modifier = Modifier.height(328.dp))

        AppIntroSection()

        Spacer(modifier = Modifier.height(195.dp))

        Image(
            painter = painterResource(Res.drawable.content1),
            contentDescription = null,
            modifier = Modifier
                .width(866.dp)
                .height(466.dp)
                .padding(horizontal = 100.dp)
                .align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(64.dp))

        Image(
            painter = painterResource(Res.drawable.content2),
            contentDescription = null,
            modifier = Modifier
                .width(717.dp)
                .height(298.dp)
                .padding(horizontal = 100.dp)
                .align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(196.dp))

        Image(
            painter = painterResource(Res.drawable.content3),
            contentDescription = null,
            modifier = Modifier
                .width(505.dp)
                .height(215.dp)
                .padding(horizontal = 100.dp)
                .align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(96.dp))

        Image(
            painter = painterResource(Res.drawable.content4),
            contentDescription = null,
            modifier = Modifier
                .width(772.dp)
                .height(681.dp)
                .padding(horizontal = 100.dp)
                .align(Alignment.End)
        )

        Spacer(modifier = Modifier.height(216.dp))

        Image(
            painter = painterResource(Res.drawable.content4),
            contentDescription = null,
            modifier = Modifier
                .width(837.dp)
                .height(996.dp)
                .padding(horizontal = 80.dp)
                .align(Alignment.End)
        )

        Spacer(modifier = Modifier.height(380.dp))
    }
}

@Composable
fun AppDownloadSection(

) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(Res.drawable.ic_app),
            contentDescription = null,
            modifier = Modifier
                .size(260.dp)
                .clip(RoundedCornerShape(32.dp))
        )

        Spacer(modifier = Modifier.height(28.dp))

        CommonText(
            text = "계획은 적게, 행동은 빠르게",
            style = AppTextStyle.TempBody,
            color = BLACK
        )

        Spacer(modifier = Modifier.height(12.dp))

        CommonText(
            text = "일단",
            style = AppTextStyle.TempTitle,
            color = BLACK
        )

        Spacer(modifier = Modifier.height(80.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(Res.drawable.ic_play_store),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 235.dp, height =70.dp)
                    .clickable {

                    }
            )

            Spacer(modifier = Modifier.width(60.dp))

            Image(
                painter = painterResource(Res.drawable.ic_app_store),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 235.dp, height =70.dp)
                    .clickable {

                    }
            )
        }
    }
}

@Composable
fun AppIntroSection(

) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CommonText(
            text = "우리는 일단 할 필요가 있어요",
            style = AppTextStyle.TempBody,
            color = BLACK
        )

        Spacer(modifier = Modifier.height(32.dp))

        CommonText(
            text = "일단은 계획하는 시간을 최소화하고 할 일을 완료하는 것에 집중할 수 있도록 돕는 서비스예요.\n캘린더앱이 불편했거나 다이어리를 쓰기 귀찮은 사람에게 최고의 해결책이 될 것이에요!",
            style = AppTextStyle.TempContent,
            textAlign = TextAlign.Center,
            color = BLACK
        )
    }
}