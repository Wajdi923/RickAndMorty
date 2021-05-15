package com.example.rickandmorty.presentation


import com.example.rickandmorty.presentation.api.RickandMortyAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Singletons {
    companion object{
        fun getRickAndMortyApi(){

        }

        val RickandMortyAPI: RickandMortyAPI = Retrofit.Builder()
                .baseUrl( "https://rickandmortyapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(com.example.rickandmorty.presentation.api.RickandMortyAPI::class.java)

    }
}