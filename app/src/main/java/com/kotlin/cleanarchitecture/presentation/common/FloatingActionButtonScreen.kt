package com.kotlin.cleanarchitecture.presentation.common

import androidx.compose.foundation.Text
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import timber.log.Timber

@Composable
fun FloatingActionButtonScreen(scaffoldState: ScaffoldState) {
    FloatingActionButton(
        onClick = {
            Timber.d("check_root_click:${scaffoldState.drawerState.value}")
            scaffoldState.drawerState.open()
        }
    ) {
        Text("X")
    }
}
