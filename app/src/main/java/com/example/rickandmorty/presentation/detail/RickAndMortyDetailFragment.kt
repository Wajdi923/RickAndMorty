package com.example.rickandmorty.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.rickandmorty.R
import com.example.rickandmorty.presentation.Singletons
import com.example.rickandmorty.presentation.api.CharacterDetailResponse
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class RickAndMortyDetailFragment : Fragment() {

    private lateinit var textViewName:TextView



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rickandmorty_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewName=view.findViewById(R.id.character_detail_name)
        callApi()
    }

    private fun callApi() {
        val id=arguments?.getInt("characterId")?:-1
        Singletons.RickandMortyAPI.getCharacterDetail(id).enqueue(object : retrofit2.Callback<CharacterDetailResponse> {
            override fun onResponse(
                    call: Call<CharacterDetailResponse>,
                    response: Response<CharacterDetailResponse>) {

                if(response.isSuccessful && response.body() !=null) {
                    textViewName.text = response.body()!!.name
                }
            }

            override fun onFailure(call: Call<CharacterDetailResponse>, t: Throwable) {
            }

        })
    }
}