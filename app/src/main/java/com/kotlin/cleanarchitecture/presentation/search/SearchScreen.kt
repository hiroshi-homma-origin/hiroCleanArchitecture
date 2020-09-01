package com.kotlin.cleanarchitecture.presentation.search

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DoneOutline
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.runtime.stateFor
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.kotlin.cleanarchitecture.R
import timber.log.Timber

@Composable
fun SearchScreen() {
    // Background
    Image(
        imageResource(id = R.drawable.bg1),
        modifier = Modifier.fillMaxWidth() + Modifier.fillMaxHeight() +
            Modifier.background(Color(0xFF363636))
    )
    // Contents
    HandleTextFieldChanges()
}

@Composable
fun HandleTextFieldChanges() {
    Column {
        val state = stateFor<String>("") { "ピカチュウ" }

        TextField(
            value = state.value,
            leadingIcon = {
                Icon(
                    asset = Icons.Filled.Search,
                    tint = Color.White
                )
            },
            trailingIcon = {
                Icon(
                    asset = Icons.Filled.DoneOutline,
                    modifier = Modifier.clickable(
                        onClick = {
                            Timber.d("Search Done")
                        }
                    ),
                    tint = Color.White
                )
            },
            modifier = Modifier.fillMaxWidth() +
                Modifier.height(50.dp) +
                Modifier.padding(0.dp),
            onValueChange = { state.value = it },
            label = {
                Text(
                    text = "Search Word",
                    color = Color.White
                )
            },
            textStyle = TextStyle(
                color = Color.White,
            )
        )
        Text(
            text = "The textfield has this text: " + state.value,
            color = Color.White
        )
    }
}
