package com.example.rickandmorty.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.presentation.Singletons
import com.example.rickandmorty.presentation.api.CharacterListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RickAndMortyListFragment : Fragment() {

    private lateinit var recyclerView:RecyclerView
    private lateinit var loader:ProgressBar
    private lateinit var textViewError: TextView


    private val adapter=RickAndMortyAdapter(listOf(), ::onClickedCharacter)
    private val viewModel: RickAndMortyListViewModel by viewModels()

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
        loader=view.findViewById(R.id.rickandmorty_loader)
        textViewError=view.findViewById(R.id.rickandmorty_error)

        recyclerView.apply {
            adapter=this@RickAndMortyListFragment.adapter
            layoutManager=LinearLayoutManager(context)
        }
        viewModel.rickandmortyList.observe(viewLifecycleOwner, Observer { rickandmortyModel ->
            loader.isVisible=rickandmortyModel is RickAndMortyLoader
            textViewError.isVisible=rickandmortyModel is RickAndMortyError

                if ( rickandmortyModel is RickAndMortySuccess){
                    adapter.updateList(rickandmortyModel.rickandmortyList)
                }

        })




    }

    private fun onClickedCharacter(id: Int) {

        findNavController().navigate(R.id.navigateToRickAndMortyDetailFragment, bundleOf(
             "characterId" to (id+1)
        ))

    }
}