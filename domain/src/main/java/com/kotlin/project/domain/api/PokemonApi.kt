package com.kotlin.project.domain.api

import com.kotlin.project.data.model.response.PokeList
import retrofit2.http.GET
import retrofit2.http.Path

internal interface PokemonApi {
    @GET("pokelist/{jsonName}")
    suspend fun getPokemonList(@Path("jsonName") jsonName: String?): List<PokeList>
}
