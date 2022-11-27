package com.gabo.pokedex.model

import com.example.Pokedex.model.Pokemon
import com.google.gson.annotations.SerializedName

data class PokeResponse(
    @SerializedName("results")
    val pokemons: List<Pokemon>
)
