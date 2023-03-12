package com.repleyva.annotecomposeapp.presentation.onboarding

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

enum class OnboardingTab(val index: Int) {
    FIRST(0), SECOND(1), THIRD(3)
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingScreen(
    screenHeight: Dp,
    onGettingStartedClick: () -> Unit
) {

    val pagerState = rememberPagerState(OnboardingTab.FIRST.index)

    Box() {
        Column {
            HorizontalPager(
                count = 3,
                state = pagerState,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) { page ->
                when (page) {
                    OnboardingTab.FIRST.index -> FirstOnboardingScreen(screenHeight = screenHeight)
                   /* OnboardingTab.SECOND.index -> SecondOnboardingScreen(
                        currentPage = pagerState.currentPage
                    )
                    OnboardingTab.THIRD.index -> ThirdOnboardingScreen(
                        screenHeight = screenHeight,
                        currentPage = pagerState.currentPage,
                        onGettingStartedClick = onGettingStartedClick
                    )*/
                    else -> { }
                }
            }
        }
    }

}