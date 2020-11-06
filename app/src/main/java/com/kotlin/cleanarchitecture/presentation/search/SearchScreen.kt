package com.kotlin.cleanarchitecture.presentation.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.kotlin.cleanarchitecture.R

@Composable
fun SearchScreen() {
    // Background
    Image(
        imageResource(id = R.drawable.bg1),
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFF363636))
    )
    // Contents
    HandleTextFieldChanges()
}

@Composable
fun HandleTextFieldChanges() {
    Column {
        val state = remember { mutableStateOf("ピカチュウ") }
        TextField(
            value = state.value,
            leadingIcon = {
//                Icon(
//                    asset = Icons.Filled.Search,
//                    tint = Color.White
//                )
            },
            trailingIcon = {
//                Icon(
//                    asset = Icons.Filled.DoneOutline,
//                    modifier = Modifier.clickable(
//                        onClick = {
//                            Timber.d("Search Done")
//                        }
//                    ),
//                    tint = Color.White
//                )
            },
            modifier = Modifier.fillMaxWidth()
                .height(50.dp)
                .padding(0.dp),
            onValueChange = { state.value = it },
            label = {
                Text(
                    text = "検索する言葉を入れてください。",
                    color = Color.Gray
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
