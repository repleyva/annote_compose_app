package com.repleyva.annotecomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.repleyva.annotecomposeapp.model.StartActivityEvent
import com.repleyva.annotecomposeapp.ui.theme.AnnoteComposeAppTheme

private const val KEY_IS_ONBOARDING_SHOWN = "KEY_IS_ONBOARDING_SHOWN"

class MainActivity : ComponentActivity() {

    companion object {

        fun getStartActivityEvent(isOnboardingScreenShown: Boolean) = StartActivityEvent(
            MainActivity::class.java,
            Bundle().apply { putBoolean(KEY_IS_ONBOARDING_SHOWN, isOnboardingScreenShown) },
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val isShown = intent.getBooleanExtra(KEY_IS_ONBOARDING_SHOWN, false)
        setContent {
            AnnoteComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AnnoteComposeAppTheme {
        Greeting("Android")
    }
}