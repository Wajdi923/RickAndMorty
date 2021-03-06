package com.example.rickandmorty.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmorty.R
import kotlin.reflect.KFunction1

class RickAndMortyAdapter(private var dataSet: List<Character>, var listener: ((Int) -> Unit) ?=null) :RecyclerView.Adapter<RickAndMortyAdapter.ViewHolder>() {


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView:ImageView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.character_name)
            imageView=view.findViewById(R.id.character_image)
        }
    }

    fun updateList(list:List<Character>){
        dataSet=list
        notifyDataSetChanged()
    }


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.rickandmorty_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val character:Character=dataSet[position]
        viewHolder.textView.text = character.name
        viewHolder.itemView.setOnClickListener {
            listener?.invoke(position)
        }
        Glide
            .with(viewHolder.itemView.context)
            .load("https://rickandmortyapi.com/api/character/avatar/${position + 1}.jpeg")
            .centerCrop()
            .into(viewHolder.imageView);

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
