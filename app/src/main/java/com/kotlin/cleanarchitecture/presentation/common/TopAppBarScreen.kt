package com.kotlin.cleanarchitecture.presentation.common

import androidx.compose.foundation.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import com.kotlin.cleanarchitecture.R
import dev.chrisbanes.accompanist.coil.CoilImage

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
                    scaffoldState.drawerState.open()
                }
            ) {
                Icon(navigationIcon)
            }
        },
        title = {
            CoilImage(R.drawable.pokedex_logo)
        }
    )
}
