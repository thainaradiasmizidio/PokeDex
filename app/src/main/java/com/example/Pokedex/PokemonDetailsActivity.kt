package com.example.Pokedex;

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Pokedex.adapter.SkillsAdapter
import com.example.Pokedex.adapter.StatusAdapter
import com.gabo.pokedex.network.PokeApi

import com.squareup.picasso.Picasso

@Suppress("DEPRECATION")
class PokemonDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        supportActionBar?.hide()

        val pokeName : TextView = findViewById(R.id.pokemonName)
        val recyclerViewStats : RecyclerView = findViewById(R.id.poke_recycler_stats)
        val recyclerViewType : RecyclerView = findViewById(R.id.poke_recycler_types)
        val recyclerViewAbilities : RecyclerView = findViewById(R.id.poke_recycler_abilities)

        val pokemonUrl = intent.getStringExtra("pokemonUrl")
        val pokemonId = this.getPokemonId(pokemonUrl!!)

        PokeApi().getPokemonById(pokemonId) { pokemon ->
            this.putImageOfPokemon(pokemonId)
            pokeName.text = pokemon?.name

            recyclerViewStats.adapter = StatusAdapter(pokemon!!)
            recyclerViewStats.layoutManager = GridLayoutManager(this, 2)

            recyclerViewType.adapter = TypeAdapter(pokemon, findViewById(R.id.pokeType))
            recyclerViewType.layoutManager = LinearLayoutManager(this)

            recyclerViewAbilities.adapter = SkillsAdapter(pokemon, findViewById(R.id.pokeAbilities))
            recyclerViewAbilities.layoutManager = GridLayoutManager(this, 2)

        }
    }

    private fun putImageOfPokemon(id: String) {
        val imageView : ImageView = findViewById(R.id.pokemon_png)
        val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
        Picasso.get().load(url).into(imageView)
    }

    private fun getPokemonId(url: String): String {
        return url.replace("https://pokeapi.co/api/v2/pokemon/", "").replace("/","")
    }
}