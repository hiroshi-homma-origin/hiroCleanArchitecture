package com.kotlin.cleanarchitecture.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.kotlin.cleanarchitecture.R
import com.kotlin.cleanarchitecture.state.PokeDelegate.rootViewModel

@Composable
fun FloatingActionButtonScreen() {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(32.dp, 0.dp, 0.dp, 0.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Left (Prev)
        FloatingActionButton(
            onClick = {
                rootViewModel.prevData()
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
                rootViewModel.nextData()
            }
        ) {
            Image(
                imageResource(id = R.drawable.monster_ball),
                modifier = Modifier.size(58.dp)
            )
        }
    }
}
