package com.example.Pokedex;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Pokedex.R
import com.gabo.pokedex.R
import com.example.Pokedex.model.Pokemon

class TypeAdapter(private val pokemon: Pokemon, private val pokeType : TextView) : RecyclerView.Adapter<TypeAdapter.PokeTypeViewHolder>() {

    inner class PokeTypeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeTypeViewHolder {
        pokeType.text = "Tipo"
        val layoutInflater = LayoutInflater.from(parent.context)
        val layout = layoutInflater.inflate(R.layout.poke_text_view, parent, false)
        return PokeTypeViewHolder(layout)
    }

    override fun onBindViewHolder(holder: PokeTypeViewHolder, position: Int) {
        val data : TextView = holder.itemView.findViewById(R.id.data)
        data.text = pokemon.types[position].type.name
    }

    override fun getItemCount(): Int {
        return pokemon.types.size
    }
}