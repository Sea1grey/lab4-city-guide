package com.sergey.cityguide

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlaceAdapter(
    private val places: List<Place>,
    private val onClick: (Place) -> Unit
) : RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder>() {

    class PlaceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.placeImage)
        val title: TextView = view.findViewById(R.id.placeTitle)
        val description: TextView = view.findViewById(R.id.placeDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_place, parent, false)

        return PlaceViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val place = places[position]

        holder.image.setImageResource(place.imageResId)
        holder.title.text = place.title
        holder.description.text = place.description
        holder.itemView.setOnClickListener {
            onClick(place)
        }
    }

    override fun getItemCount(): Int = places.size
}