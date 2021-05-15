package com.example.rickandmorty.presentation.api

import com.example.rickandmorty.presentation.list.Character

data class CharacterListResponse(
    val results:List<Character>
)