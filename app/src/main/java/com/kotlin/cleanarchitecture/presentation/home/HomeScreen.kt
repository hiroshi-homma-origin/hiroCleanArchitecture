package com.kotlin.cleanarchitecture.presentation.home

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kotlin.cleanarchitecture.presentation.root.RootViewModel
import timber.log.Timber

@Composable
fun HomeScreen(rootViewModel: RootViewModel) {
    ScrollableColumn(
        modifier = Modifier.padding(bottom = 60.dp)
    ) {
        rootViewModel.liveData.value?.mapIndexed { index, pokemon ->
            Card(
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.padding(4.dp) +
                        Modifier.fillMaxWidth() +
                        Modifier.preferredHeight(100.dp) +
                        Modifier.clickable(
                            onClick = {
                                Timber.d("check_click:$index")
                            }
                        )
            ) {
                Column(
                    modifier = Modifier.padding(4.dp)
                ) {
                    Text(pokemon.name.japanese)
                    Row(
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(end = 8.dp)
                        ) {
                            Text("HP:${pokemon.base.hp}")
                            Text("Attack:${pokemon.base.attack}")
                        }
                        Column(
                            modifier = Modifier.padding(end = 8.dp)
                        ) {
                            Text("Defense:${pokemon.base.defense}")
                            Text("Speed:${pokemon.base.speed}")
                        }
                        Column(
                            modifier = Modifier.padding(end = 8.dp)
                        ) {
                            Text("Sp. Attack:${pokemon.base.spAttack}")
                            Text("Sp. Defense:${pokemon.base.spDefense}")
                        }
                    }
                }
            }
        }
    }
}
