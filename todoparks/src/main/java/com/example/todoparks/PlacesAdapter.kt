package com.example.todoparks

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PlacesAdapter (private val PlacesList: ArrayList<PlaceItem>): RecyclerView.Adapter<PlacesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_new_place_parque_del_cafe, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = PlacesList[position]
        holder.bind(place)
    }

    override fun getItemCount(): Int = PlacesList.size

    class ViewHolder (Itemview: View): RecyclerView.ViewHolder(Itemview){
        private var Name: TextView = itemView.findViewById(R.id.NameView)
        private var Score: TextView = itemView.findViewById(R.id.ScoreView)
        private var image: ImageView = itemView.findViewById(R.id.imageView)
        private var Intro: TextView= itemView.findViewById(R.id.IntroView)

        fun bind (Place:PlaceItem){
            Name.text = Place.name
            Score.text = Place.score
            Intro.text = Place.intro
            Picasso.get().load(Place.photo).into(image)
            Log.d("prueb", Place.photo)
        }
    }
}