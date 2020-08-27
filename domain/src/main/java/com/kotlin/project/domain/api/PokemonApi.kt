package com.kotlin.project.domain.api

import com.kotlin.project.data.models.original.response.PokeListResponse
import retrofit2.http.GET

internal interface PokemonApi {
    @GET("pokelist/pokedex0.json")
    suspend fun getPokemonList1(): List<PokeListResponse>
}