package com.repleyva.annotecomposeapp.presentation.main

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimatable
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieAnimatable
import com.airbnb.lottie.compose.rememberLottieComposition
import com.repleyva.annotecomposeapp.R
import com.repleyva.annotecomposeapp.presentation.main.navigation.NavHostMain
import com.repleyva.annotecomposeapp.presentation.util.Constants.backwardSpeed
import com.repleyva.annotecomposeapp.presentation.util.Constants.forwardSpeed
import com.repleyva.annotecomposeapp.presentation.util.Screen
import com.repleyva.annotecomposeapp.presentation.util.noRippleClickable
import com.repleyva.annotecomposeapp.ui.theme.White


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    Surface {

        val navController = rememberNavController()
        val speed = remember { mutableStateOf(0f) }
        val lottieAnimatable = rememberLottieAnimatable()
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.menu_icon))

        LaunchedEffect(speed.value) {
            lottieAnimatable.animate(
                composition = composition,
                speed = speed.value,
            )
        }

        LaunchedEffect(composition) {
            lottieAnimatable.animate(
                composition = composition,
                speed = speed.value,
            )
        }

        Scaffold(
            backgroundColor = White,
            topBar = { MainTopBar(navController, lottieAnimatable)}
        ) {

            NavHostMain(navController)

            navController.addOnDestinationChangedListener { controller, destination, arguments ->
                when (destination.route) {
                    Screen.CalendarScreen.route + "?currentPage={currentPage}" -> {
                        speed.value = backwardSpeed
                    }

                    else -> speed.value = forwardSpeed
                }
            }
        }
    }
}

@Composable
private fun MainTopBar(navController: NavHostController, lottieAnimatable: LottieAnimatable) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .background(Color.Transparent),
    ) {
        LottieAnimation(
            modifier = Modifier
                .height(72.dp)
                .width(85.dp)
                .clip(RoundedCornerShape(8.dp))
                .padding(top = 2.dp)
                .noRippleClickable {
                    navigate(navController)
                },
            composition = lottieAnimatable.composition,
            progress = lottieAnimatable.progress
        )
    }
}


fun navigate(navController: NavController) {
    when (navController.currentDestination?.route) {
        Screen.CalendarScreen.route + "?currentPage={currentPage}" -> {
            navController.navigate(Screen.SpinnerScreen.route)
        }

        Screen.NoteScreen.route + "?noteId={noteId}&noteDate={noteDate}" -> {
            navController.navigate(Screen.CalendarScreen.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = true
                }
            }
        }

        Screen.SpinnerScreen.route -> {
            navController.navigate(Screen.CalendarScreen.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = true
                }
            }
        }
    }
}