package com.repleyva.annotecomposeapp.model

import android.os.Bundle

sealed class NavigationEvents

data class StartActivityEvent(
    val activity: Class<*>,
    val bundle: Bundle? = null,
    val code: Int = 0,
    val flag: Int = 0
) : NavigationEvents()
