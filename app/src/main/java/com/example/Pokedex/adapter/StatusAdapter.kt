package com.example.Pokedex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Pokedex.R
import com.example.Pokedex.model.Pokemon

class StatusAdapter(private val pokemon: Pokemon) : RecyclerView.Adapter<StatusAdapter.PokeStatsViewHolder>() {

    inner class PokeStatsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeStatsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layout = layoutInflater.inflate(R.layout.poke_text_view, parent, false)
        return PokeStatsViewHolder(layout)
    }

    override fun onBindViewHolder(holder: PokeStatsViewHolder, position: Int) {
        val data : TextView = holder.itemView.findViewById(R.id.data)
        data.text = String.format("${pokemon.stats[position].stat.name}: ${pokemon.stats[position].baseStat}")
    }

    override fun getItemCount(): Int {
        return pokemon.stats.size
    }
}