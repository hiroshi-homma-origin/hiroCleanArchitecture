package com.kotlin.project.data.models.response

import com.kotlin.project.data.models.Ability
import com.kotlin.project.data.models.Move
import com.kotlin.project.data.models.Sprite

data class PokemonDetailResponse (
    var id: Int? = null,
    var name: String? = null,
    var sprites: Sprite? = null,
    var moves: ArrayList<Move>? = null,
    var weight: Int? = null,
    var height: Int? = null,
    var abilities: ArrayList<Ability>? = null
)