package com.example.Pokedex.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Pokedex.R
import com.example.Pokedex.model.Pokemon

class SkillsAdapter(private val pokemon: Pokemon, private val pokeAbility : TextView) : RecyclerView.Adapter<SkillsAdapter.PokeAbilitiesViewHolder>() {

    inner class PokeAbilitiesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    @SuppressLint("SetTextI18n")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeAbilitiesViewHolder {
        pokeAbility.text = "Habilitates"
        val layoutInflater = LayoutInflater.from(parent.context)
        val layout = layoutInflater.inflate(R.layout.poke_text_view, parent, false)
        return PokeAbilitiesViewHolder(layout)
    }

    override fun onBindViewHolder(holder: PokeAbilitiesViewHolder, position: Int) {
        val data : TextView = holder.itemView.findViewById(R.id.data)
        data.text = pokemon.abilities[position].ability.name
    }

    override fun getItemCount(): Int {
        return pokemon.abilities.size
    }
}