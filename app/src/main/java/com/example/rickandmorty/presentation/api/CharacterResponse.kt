package com.example.rickandmorty.presentation.api

import com.example.rickandmorty.presentation.list.Character

data class CharacterResponse(
    val results:List<Character>
)