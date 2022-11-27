package com.example.Pokedex.model

import com.gabo.pokedex.model.PokemonAbilities
import com.gabo.pokedex.model.PokemonStats
import com.gabo.pokedex.model.PokemonType
import com.google.gson.annotations.SerializedName

data class Pokemon(
    val id: Int,
    val url: String,
    val name: String,
    @SerializedName("types")
    val types: List<PokemonType>,
    @SerializedName("stats")
    val stats: List<PokemonStats>,
    @SerializedName("abilities")
    val abilities: List<PokemonAbilities>
)

annotation class SerializedName(val value: String)
