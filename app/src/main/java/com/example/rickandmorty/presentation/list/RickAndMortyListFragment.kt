package com.example.rickandmorty.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.presentation.Singletons
import com.example.rickandmorty.presentation.api.CharacterListResponse
import com.example.rickandmorty.presentation.api.RickandMortyAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RickAndMortyListFragment : Fragment() {

    private lateinit var recyclerView:RecyclerView
    private val adapter=RickAndMortyAdapter(listOf(), ::onClickedCharacter)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rickandmortylist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView=view.findViewById(R.id.rickandmorty_recyclerview)
        recyclerView.apply {
            adapter=this@RickAndMortyListFragment.adapter
            layoutManager=LinearLayoutManager(context)
        }


        Singletons.RickandMortyAPI.getCharacterList().enqueue(object :Callback<CharacterListResponse>{
            override fun onResponse(call: Call<CharacterListResponse>, response: Response<CharacterListResponse>) {
                if (response.isSuccessful && response.body()!=null){
                    val characterResponse:CharacterListResponse=response.body()!!
                    adapter.updateList(characterResponse.results)
                }

            }

            override fun onFailure(call: Call<CharacterListResponse>, t: Throwable) {

            }

        })





    }

    private fun onClickedCharacter(character: Character) {
        findNavController().navigate(R.id.navigateToRickAndMortyDetailFragment)

    }
}