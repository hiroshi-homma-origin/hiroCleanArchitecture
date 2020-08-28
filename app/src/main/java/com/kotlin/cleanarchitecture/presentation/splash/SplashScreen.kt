package com.kotlin.cleanarchitecture.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.kotlin.cleanarchitecture.R

@Composable
fun SplashScreen() {
    Column {
        Image(
            imageResource(id = R.drawable.pokedex_logo),
            modifier = Modifier.padding(top = 60.dp, start = 8.dp)
        )
    }
}
