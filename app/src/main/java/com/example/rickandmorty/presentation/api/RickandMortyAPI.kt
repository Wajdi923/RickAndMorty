package com.example.rickandmorty.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickandMortyAPI {
    @GET("/api/character")
    fun getCharacterList(): Call<CharacterResponse>
}