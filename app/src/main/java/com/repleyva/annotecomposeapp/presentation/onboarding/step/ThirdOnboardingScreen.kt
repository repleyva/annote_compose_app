package com.repleyva.annotecomposeapp.presentation.onboarding.step

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieAnimatable
import com.airbnb.lottie.compose.rememberLottieComposition
import com.repleyva.annotecomposeapp.R
import com.repleyva.annotecomposeapp.presentation.util.AppButton
import com.repleyva.annotecomposeapp.presentation.util.dpToSp
import com.repleyva.annotecomposeapp.ui.theme.PrimaryBlack
import com.repleyva.annotecomposeapp.ui.theme.White
import com.repleyva.annotecomposeapp.ui.theme.urbanistFont
import kotlinx.coroutines.delay


@ExperimentalMotionApi
@Composable
fun ThirdOnboardingScreen(
    screenHeight: Dp,
    currentPage: Int,
    onGettingStartedClick: () -> Unit
) {

    var currentState by remember { mutableStateOf(true) }
    val transition = updateTransition(currentState, "position")

    val buttonsOffset by transition.animateDp(
        transitionSpec = { tween(durationMillis = 700) },
        label = "buttons offset"
    ) { state ->
        when (state) {
            true -> 100.dp
            false -> 0.dp
        }
    }

    LaunchedEffect(currentState) {
        delay(700)
        currentState = false
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {

        val lottieAnimatable = rememberLottieAnimatable()
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.onboarding_animation3))

        LaunchedEffect(currentPage) {
            lottieAnimatable.animate(
                composition = composition,
                iterations = LottieConstants.IterateForever
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .fillMaxWidth(),
                text = stringResource(id = R.string.onboarding_screen3_text1),
                style = MaterialTheme.typography.caption,
                fontSize = dpToSp(dp = 40.dp),
                textAlign = TextAlign.Center
            )

            LottieAnimation(
                modifier = Modifier
                    .height(if (screenHeight > 600.dp) 370.dp else 250.dp),
                composition = lottieAnimatable.composition,
                progress = lottieAnimatable.progress
            )

            Text(
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.onboarding_screen3_text2),
                style = TextStyle(
                    fontFamily = urbanistFont,
                    fontWeight = FontWeight.SemiBold,
                    color = PrimaryBlack,
                    fontSize = dpToSp(18.dp)
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.onboarding_screen3_text3),
                style = TextStyle(
                    fontFamily = urbanistFont,
                    fontWeight = FontWeight.SemiBold,
                    color = PrimaryBlack,
                    fontSize = dpToSp(18.dp)
                )
            )

        }

        AppButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .offset(0.dp, buttonsOffset)
                .padding(start = 30.dp, end = 30.dp, bottom = 30.dp),
            text = stringResource(id = R.string.lets_go),
            fontColor = White,
            backgroundColor = PrimaryBlack,
            onClick = onGettingStartedClick
        )

    }
}