package com.kotlin.project.domain.api

import com.kotlin.project.data.models.response.PokemonDetailResponse
import com.kotlin.project.data.models.response.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path

internal interface PokemonApi {
    @GET("api/v2/pokemon")
    suspend fun getPokemonList(): PokemonListResponse

    @GET("api/v2/pokemon/{name}")
    suspend fun getPokemonDetail(@Path("name") name: String?): PokemonDetailResponse
}