package com.repleyva.annotecomposeapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.booleanPreferencesKey
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionResult
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.repleyva.annotecomposeapp.base.BaseActivity
import com.repleyva.annotecomposeapp.presentation.util.rememberPreference
import com.repleyva.annotecomposeapp.ui.theme.AnnoteComposeAppTheme
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {

    private lateinit var isOnboardingScreenShown: MutableState<Boolean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnnoteComposeAppTheme { SplashScreen() }
        }
    }

    @Composable
    private fun SplashScreen() {
        isOnboardingScreenShown =
            rememberPreference(booleanPreferencesKey("isOnboardingScreenShown"), false)

        val compositionResult: LottieCompositionResult =
            rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.splash))
        val progress by animateLottieCompositionAsState(compositionResult.value, speed = 4f)


        LaunchedEffect(true) {
            compositionResult.await()
            delay(600)
            startActivity(MainActivity.getStartActivityEvent(isOnboardingScreenShown.value))
            finish()
        }

        Surface(color = MaterialTheme.colors.onPrimary) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                LottieAnimation(
                    modifier = Modifier.padding(horizontal = 100.dp),
                    composition = compositionResult.value,
                    progress = progress
                )
            }
        }
    }
}