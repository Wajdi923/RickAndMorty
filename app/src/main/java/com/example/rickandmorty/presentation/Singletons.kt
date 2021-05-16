package com.example.rickandmorty.presentation


import com.example.rickandmorty.presentation.RickAndMortyApplication.Companion.context
import com.example.rickandmorty.presentation.api.RickandMortyAPI
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File


class Singletons {
    companion object{
        var cache= Cache(File(context?.cacheDir,"responses"),10*1024*1024)
        val okHttpClient:OkHttpClient=OkHttpClient().newBuilder()
                .cache(cache)
                .build()


        val RickandMortyAPI: RickandMortyAPI = Retrofit.Builder()
                .baseUrl( "https://rickandmortyapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(com.example.rickandmorty.presentation.api.RickandMortyAPI::class.java)


    }
}