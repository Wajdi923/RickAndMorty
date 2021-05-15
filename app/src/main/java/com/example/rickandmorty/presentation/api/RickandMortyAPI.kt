package com.example.rickandmorty.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RickandMortyAPI {
    @GET("/api/character")
    fun getCharacterList(): Call<CharacterListResponse>

    @GET("/api/character/{id}")
    fun getCharacterDetail(@Path("id")id:String): Call<CharacterDetailResponse>
}