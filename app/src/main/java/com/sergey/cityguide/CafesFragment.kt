package com.sergey.cityguide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CafesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_cafes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        val places = listOf(
            Place(
                R.string.cafe1_title,
                R.string.cafe1_desc,
                R.drawable.surf
            ),
            Place(
                R.string.cafe2_title,
                R.string.cafe2_desc,
                R.drawable.skuratov
            ),
            Place(
                R.string.cafe3_title,
                R.string.cafe3_desc,
                R.drawable.testo
            ),
            Place(
                R.string.cafe4_title,
                R.string.cafe4_desc,
                R.drawable.mishka
            ),
            Place(
                R.string.cafe5_title,
                R.string.cafe5_desc,
                R.drawable.shtolle
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