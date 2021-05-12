package com.example.rickandmorty.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R

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
        val weatherList: ArrayList<Character> = arrayListOf<Character>().apply {
            add(Character("Paris"))
            add(Character("London"))
            add(Character("Mumbai"))
        }

        adapter.updateList(weatherList)


    }
}