package com.kotlin.cleanarchitecture.presentation.mypage

import androidx.compose.animation.animate
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.globalPosition
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.kotlin.cleanarchitecture.R
import com.kotlin.cleanarchitecture.state.PokeDelegate
import timber.log.Timber

@Composable
fun MyPageScreen() {
    // Background
    Image(
        imageResource(id = R.drawable.bg1),
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFF363636))
    )
    Column {
        TestAnimation()
    }
}

@Composable
fun TestAnimation() {
    var count = 0
    ScrollableColumn(
        modifier = Modifier.padding(bottom = 60.dp)
    ) {

    }
}
