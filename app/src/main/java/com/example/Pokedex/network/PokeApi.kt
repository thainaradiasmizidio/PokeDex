package com.gabo.pokedex.network

import android.telecom.Call
import com.gabo.pokedex.model.PokeResponse
import com.example.Pokedex.model.Pokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.security.auth.callback.Callback

class PokeApi {

    private var retrofit: Retrofit? = null
    private var pokeService: PokeApiService? = null


    init{

        retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        pokeService = retrofit?.create(PokeApiService::class.java)
    }

    fun getPokemons(listener: (List<Pokemon>?) -> Unit) {
        val call = pokeService?.getPokemons()
        call?.enqueue(object : Callback<PokeResponse> {
            override fun onResponse(
                call: Call<PokeResponse>,
                response: Response<PokeResponse>) {
                listener(response.body()?.pokemons)
            }

            override fun onFailure(call: Call<PokeResponse>,
                                   t: Throwable) {
                listener(null)
            }
        })
    }

    fun getPokemonByName(name: String, listener: (Pokemon?) -> Unit) {
        val call = pokeService?.getPokemonByName(name)

        call?.enqueue(object : Callback<Pokemon> {
            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                listener(response.body())
            }

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                listener(null)
            }
        })

    }

    fun getPokemonById(id: String, listener: (Pokemon?) -> Unit) {
        val call = pokeService?.getPokemonById(id)

        call?.enqueue(object : Callback<Pokemon> {
            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                listener(response.body())
            }

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                listener(null)
            }
        })

    }
}