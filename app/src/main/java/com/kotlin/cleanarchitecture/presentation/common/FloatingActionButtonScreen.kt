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
import com.kotlin.cleanarchitecture.state.PokeState.rootViewModel
import timber.log.Timber

@Composable
fun FloatingActionButtonScreen(scaffoldState: ScaffoldState) {
    FloatingActionButton(
        onClick = {
//            scaffoldState.drawerState.open()
            rootViewModel.retryData()
        }
    ) {
        Image(
            imageResource(id = R.drawable.monster_ball),
            modifier = Modifier.size(58.dp)
        )
    }
}
