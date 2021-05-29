package com.example.rickandmorty.presentation.list

sealed class RickAndMortyModel

data class RickAndMortySuccess(val rickandmortyList: List<Character>):RickAndMortyModel()
object RickAndMortyLoader: RickAndMortyModel()
object RickAndMortyError:RickAndMortyModel()
