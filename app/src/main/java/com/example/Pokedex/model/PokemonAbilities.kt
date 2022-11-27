package com.gabo.pokedex.model

import com.google.gson.annotations.SerializedName

data class PokemonAbilities(
    @SerializedName("ability")
    val ability: AbilityName
)
