package com.kotlin.cleanarchitecture.presentation.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.stateFor
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import com.kotlin.cleanarchitecture.R

@Composable
fun SearchScreen() {
    val textField = stateFor<String>("") { "" }
    // Background
    Image(
        imageResource(id = R.drawable.bg1),
        modifier = Modifier.fillMaxWidth() + Modifier.fillMaxHeight() +
            Modifier.background(Color(0xFF363636))
    )
    // Contents
    TextField(
        value = textField.value,
        onValueChange = { textField.value = "" },
        label = {},
    )
}
