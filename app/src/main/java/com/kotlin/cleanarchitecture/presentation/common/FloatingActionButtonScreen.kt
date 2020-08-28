package com.kotlin.cleanarchitecture.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.kotlin.cleanarchitecture.R
import timber.log.Timber

@Composable
fun FloatingActionButtonScreen(scaffoldState: ScaffoldState) {
    FloatingActionButton(
        onClick = {
            Timber.d("check_root_click:${scaffoldState.drawerState.value}")
            scaffoldState.drawerState.open()
        }
    ) {
        Image(
            imageResource(id = R.drawable.monster_ball),
            modifier = Modifier.size(56.dp)
        )
    }
}
