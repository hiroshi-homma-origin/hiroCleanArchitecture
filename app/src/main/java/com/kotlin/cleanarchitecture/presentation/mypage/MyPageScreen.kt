package com.kotlin.cleanarchitecture.presentation.mypage

import android.annotation.SuppressLint
import androidx.compose.animation.DpPropKey
import androidx.compose.animation.animate
import androidx.compose.animation.core.FloatPropKey
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.transitionDefinition
import androidx.compose.animation.core.tween
import androidx.compose.animation.transition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.stateFor
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.kotlin.cleanarchitecture.R

@Composable
fun MyPageScreen() {
    // Background
    Image(
        imageResource(id = R.drawable.bg1),
        modifier = Modifier.fillMaxWidth() + Modifier.fillMaxHeight() +
            Modifier.background(Color(0xFF363636))
    )
    Column {
        TestAnimation()
//        TestAnimation1()
    }
}

@Composable
fun TestAnimation() {
    var visible by stateFor<Boolean>(false) { false }
    val size1 = animate(if (visible) 300.dp else 90.dp)
    val modi = if (visible) {
        Modifier.background(Color.White)
            .fillMaxWidth()
            .fillMaxHeight()
    } else {
        Modifier.background(Color.White)
            .size(90.dp)
    }

    Card(
        modifier = Modifier.padding(12.dp) +
            Modifier.fillMaxWidth() +
            Modifier.preferredHeight(size1) +
            Modifier.clickable(
                onClick = {
                    // Todo()
                }
            ),
        shape = RoundedCornerShape(2.dp),
        backgroundColor = Color(0xBBFFFFFF)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom,
            horizontalGravity = Alignment.Start
        ) {
            Canvas(
                modifier = modi
            ) {
                drawCircle(Color.Red)
            }
        }
    }
    Button(
        onClick = {
            visible = !visible
        },
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Animate!")
    }
}

@SuppressLint("Range", "Recycle") // keyframe or animate use
@Composable
fun TestAnimation1() {
    val sizeState = FloatPropKey()
    val dpState = DpPropKey()

    val initState = stateFor<String>("A") { "A" }
    val toState = stateFor<String>("B") { "B" }

    val definition = transitionDefinition<String> {
        state("A") {
            this[sizeState] = 10f
            this[dpState] = 0.dp
        }
        state("B") {
            this[sizeState] = 200f
            this[dpState] = 100.dp
        }

        transition(fromState = "A", toState = "B") {
            // tween
            sizeState using tween(
                durationMillis = 600,
                easing = LinearEasing
            )
            dpState using keyframes {
                0.dp at 0 with LinearEasing
                100.dp at 100 with LinearOutSlowInEasing
                50.dp at 150
            }
        }
        transition(fromState = "B", toState = "A") {
            // tween
            sizeState using tween(
                durationMillis = 600,
                easing = LinearEasing
            )
            dpState using keyframes {
                50.dp at 0 with LinearEasing
                100.dp at 100 with LinearOutSlowInEasing
                0.dp at 150
            }
        }
    }

    val state = transition(
        definition = definition,
        initState = initState.value,
        toState = toState.value
    )

    Row {
        Button(
            onClick = {
                if (toState.value == "A") {
                    initState.value = "A"
                    toState.value = "B"
                } else {
                    initState.value = "B"
                    toState.value = "A"
                }
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Animate!")
        }

        Canvas(
            modifier = Modifier.padding(30.dp)
        ) {
            drawCircle(Color.Red, state[sizeState])
        }
    }
}

// repeatable
//            sizeState using repeatable(
//                iterations = Infinite,
//                animation = tween(
//                    easing = LinearEasing,
//                    durationMillis = 1000
//                )
//            )
// keyframes
//            sizeState using keyframes {
//                50f at 200
//                60f at 2200
//                175f at 2500
//                durationMillis = 2000
//                delayMillis = 200
//            }
