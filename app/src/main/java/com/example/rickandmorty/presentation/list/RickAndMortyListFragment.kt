package com.example.rickandmorty.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.presentation.api.CharacterResponse
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
    private val adapter=RickAndMortyAdapter(listOf())
    private val layoutManager=LinearLayoutManager(context)

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
            layoutManager=this@RickAndMortyListFragment.layoutManager
        }
        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val rickAndMortyApi: RickandMortyAPI = retrofit.create(RickandMortyAPI::class.java)

        rickAndMortyApi.getCharacterList().enqueue(object :Callback<CharacterResponse>{
            override fun onResponse(call: Call<CharacterResponse>, response: Response<CharacterResponse>) {
                if (response.isSuccessful){
                    val characterResponse:CharacterResponse=response.body()!!
                    adapter.updateList(characterResponse.results)
                }

            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {

            }

        })

        val weatherList: ArrayList<Character> = arrayListOf<Character>().apply {
            add(Character("Paris"))
            add(Character("London"))
            add(Character("Mumbai"))
        }

        adapter.updateList(weatherList)


    }
}