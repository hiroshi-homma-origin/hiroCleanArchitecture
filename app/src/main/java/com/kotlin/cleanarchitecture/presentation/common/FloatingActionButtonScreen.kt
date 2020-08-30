package com.kotlin.cleanarchitecture.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.kotlin.cleanarchitecture.R
import com.kotlin.cleanarchitecture.state.PokeState.number
import com.kotlin.cleanarchitecture.state.PokeState.rootViewModel

@Composable
fun FloatingActionButtonScreen(scaffoldState: ScaffoldState) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Left (Prev)
        FloatingActionButton(
            onClick = {
                if (number > 0) rootViewModel.prevData()
            }
        ) {
            Image(
                imageResource(id = R.drawable.monster_ball),
                modifier = Modifier.size(58.dp)
            )
        }

        // Right (Next)
        FloatingActionButton(
            onClick = {
                if (number < 44) rootViewModel.nextData()
            }
        ) {
            Image(
                imageResource(id = R.drawable.monster_ball),
                modifier = Modifier.size(58.dp)
            )
        }
    }
}
