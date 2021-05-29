package com.example.rickandmorty.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.presentation.Singletons
import com.example.rickandmorty.presentation.api.CharacterListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RickAndMortyListViewModel :ViewModel(){

     val rickandmortyList: MutableLiveData<RickAndMortyModel> = MutableLiveData()

    init {
        callApi()
    }
    private fun callApi() {
        rickandmortyList.value=RickAndMortyLoader
        Singletons.RickandMortyAPI.getCharacterList()
            .enqueue(object : Callback<CharacterListResponse> {
                override fun onResponse(
                    call: Call<CharacterListResponse>,
                    response: Response<CharacterListResponse>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        val characterResponse: CharacterListResponse = response.body()!!
                        rickandmortyList.value=RickAndMortySuccess(characterResponse.results)
                    }else{
                        rickandmortyList.value=RickAndMortyError
                    }

                }

                override fun onFailure(call: Call<CharacterListResponse>, t: Throwable) {
                    rickandmortyList.value=RickAndMortyError


                }

            })
    }
}
