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
import androidx.compose.runtime.stateFor
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.globalPosition
import androidx.compose.ui.onGloballyPositioned
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
    var visible by stateFor<Boolean>(false) { false }
    var selectNum by stateFor<Int>(0) { 0 }
    ScrollableColumn(
        modifier = Modifier.padding(bottom = 60.dp)
            .onGloballyPositioned {
                if (it.globalPosition.y < 220.0f) {
                    PokeDelegate.isFloatingActionButton.postValue(false)
                } else {
                    PokeDelegate.isFloatingActionButton.postValue(true)
                }
            }
    ) {
        (0..9).forEach { num ->
            val size = animate(if (visible && selectNum == num) 300.dp else 90.dp)
            val padding = animate(if (visible && selectNum == num) 35.dp else 0.dp)
            Card(
                modifier = Modifier.padding(12.dp)
                    .fillMaxWidth()
                    .preferredHeight(size)
                    .clickable(
                        onClick = {
                            visible = num != selectNum
                            selectNum = num
                            Timber.d("check_data1:$selectNum")
                            Timber.d("check_data2:$visible")
                            if (!visible && selectNum == num) {
                                visible = true
                                count++
                            }
                            Timber.d("check_data3:$count")
                            if (count == 2) {
                                visible = false
                                count = 0
                            }
                            Timber.d("check_data4:$count")
                        }
                    ),
                shape = RoundedCornerShape(2.dp),
                backgroundColor = Color(0xBBFFFFFF)
            ) {
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Canvas(
                        modifier = Modifier.padding(padding)
                            .size(size)
                    ) {
                        drawCircle(Color.Gray)
                    }
                }
            }
        }
    }
}
