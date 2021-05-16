package com.example.rickandmorty.presentation

import android.app.Application
import android.content.Context

class RickAndMortyApplication : Application(){
    companion object{
        var context: Context?=null
    }

    override fun onCreate() {
        super.onCreate()
        context=this
    }
}
