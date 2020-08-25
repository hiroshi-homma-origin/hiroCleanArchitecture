package com.kotlin.project.data.models.response

import com.kotlin.project.data.models.Pokemon

data class PokemonListResponse(
    var count: Int? = null,
    var results: List<Pokemon>? = null
)