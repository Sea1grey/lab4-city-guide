package com.sergey.cityguide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RestaurantsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_restaurants, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        val places = listOf(
            Place(
                R.string.restaurant1_title,
                R.string.restaurant1_desc,
                R.drawable.ic_launcher_background
            ),
            Place(
                R.string.restaurant2_title,
                R.string.restaurant2_desc,
                R.drawable.ic_launcher_background
            )
        )

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.adapter = PlaceAdapter(places) { place ->

            val bundle = Bundle().apply {
                putString("title", getString(place.titleResId))
                putString("description", getString(place.descriptionResId))
                putInt("imageResId", place.imageResId)
            }

            findNavController().navigate(
                R.id.detailFragment,
                bundle
            )
        }
    }
}