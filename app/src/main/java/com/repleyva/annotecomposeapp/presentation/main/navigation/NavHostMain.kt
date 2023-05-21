package com.repleyva.annotecomposeapp.presentation.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.repleyva.annotecomposeapp.presentation.calendar.CalendarScreen
import com.repleyva.annotecomposeapp.presentation.note.NoteScreen
import com.repleyva.annotecomposeapp.presentation.spinner.SpinnerScreen
import com.repleyva.annotecomposeapp.presentation.util.Screen

@Composable
fun NavHostMain(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.CalendarScreen.route + "?currentPage={currentPage}"
    ) {

        composable(
            route = Screen.CalendarScreen.route + "?currentPage={currentPage}",
            arguments = listOf(
                navArgument(name = "currentPage") {
                    type = NavType.IntType
                    defaultValue = 0
                })
        ) {
            CalendarScreen(
                onClick = { id, date ->
                    navController.navigate(if (id != null) Screen.NoteScreen.route + "?noteId=${id}&noteDate=${date}" else Screen.NoteScreen.route + "?noteDate=${date}") {
                        popUpTo(Screen.CalendarScreen.route) {
                            inclusive = true
                        }
                    }
                })
        }

        composable(route = Screen.SpinnerScreen.route) {
            SpinnerScreen(
                onClick = {
                    navController.navigate(Screen.CalendarScreen.route + "?currentPage=$it") {
                        popUpTo(Screen.CalendarScreen.route) {
                            inclusive = true
                        }
                    }
                })
        }

        composable(
            route = Screen.NoteScreen.route + "?noteId={noteId}&noteDate={noteDate}",
            arguments = listOf(
                navArgument(name = "noteId") {
                    type = NavType.IntType
                    defaultValue = -1
                },
                navArgument(name = "noteDate") {
                    type = NavType.StringType
                    defaultValue = ""
                })
        ) {
            val date = it.arguments?.getString("noteDate").orEmpty()
            NoteScreen(
                date = date,
                onClick = { currentPage ->
                    navController.navigate(Screen.CalendarScreen.route + "?currentPage=${currentPage}") {
                        popUpTo(navController.graph.findStartDestination().id) {
                            inclusive = true
                        }
                    }
                })
        }

    }
}