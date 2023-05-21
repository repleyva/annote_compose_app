package com.repleyva.annotecomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.datastore.preferences.core.booleanPreferencesKey
import com.repleyva.annotecomposeapp.base.BaseActivity
import com.repleyva.annotecomposeapp.model.StartActivityEvent
import com.repleyva.annotecomposeapp.presentation.main.MainScreen
import com.repleyva.annotecomposeapp.presentation.onboarding.OnboardingScreen
import com.repleyva.annotecomposeapp.presentation.util.rememberPreference
import com.repleyva.annotecomposeapp.presentation.util.screenHeight
import com.repleyva.annotecomposeapp.ui.theme.AnnoteComposeAppTheme


class MainActivity : BaseActivity() {

    companion object {

        private const val KEY_IS_ONBOARDING_SHOWN = "KEY_IS_ONBOARDING_SHOWN"

        fun getStartActivityEvent(isOnboardingScreenShown: Boolean) = StartActivityEvent(
            MainActivity::class.java,
            Bundle().apply { putBoolean(KEY_IS_ONBOARDING_SHOWN, isOnboardingScreenShown) },
        )

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val isShown = intent.getBooleanExtra(KEY_IS_ONBOARDING_SHOWN, false)
        setContent {
            Navigation(isShown)
        }
    }
}


@Composable
private fun Navigation(isShown: Boolean) {

    AnnoteComposeAppTheme {

        var isOnboardingScreenShown by rememberPreference(
            booleanPreferencesKey("isOnboardingScreenShown"),
            false
        )

        val isVisible = remember { mutableStateOf(false) }

        if (isShown || isVisible.value) {
            MainScreen()
        } else {
            OnboardingScreen(
                screenHeight = screenHeight(),
                onGettingStartedClick = {
                    isOnboardingScreenShown = true
                    isVisible.value = true
                },
            )
        }

    }

}