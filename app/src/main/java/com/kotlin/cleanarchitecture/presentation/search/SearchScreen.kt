package com.kotlin.cleanarchitecture.presentation.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DoneOutline
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.kotlin.cleanarchitecture.R
import timber.log.Timber

@Composable
fun SearchScreen() {
    // Background
    Image(
        painter = painterResource(id = R.drawable.bg1),
        contentDescription = null,
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
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "search",
                    tint = Color.White
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.DoneOutline,
                    contentDescription = "search",
                    modifier = Modifier.clickable(
                        onClick = {
                            Timber.d("Search Done")
                        }
                    ),
                    tint = Color.White
                )
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
