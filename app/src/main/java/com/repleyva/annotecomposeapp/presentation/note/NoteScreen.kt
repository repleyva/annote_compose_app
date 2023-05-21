package com.repleyva.annotecomposeapp.presentation.note

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LifecycleOwner

@Composable
fun NoteScreen(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    onClick: (Int) -> Unit,
    date: String,
) {
    
}