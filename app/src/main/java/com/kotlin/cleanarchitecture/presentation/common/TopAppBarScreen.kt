package com.kotlin.cleanarchitecture.presentation.common

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import timber.log.Timber

@Composable
fun TopAppBarScreen(
    showBack: Boolean,
    scaffoldState: ScaffoldState
) {
    val navigationIcon = if (showBack) Icons.Default.ArrowBack else Icons.Default.Menu
    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = {
                    Timber.d("check_top_app_bar_click")
                    scaffoldState.drawerState.open()
                }
            ) {
                Icon(navigationIcon)
            }
        },
        title = { Text("PokeDex") }
    )
}
