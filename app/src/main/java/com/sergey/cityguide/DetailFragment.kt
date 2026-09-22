package com.sergey.cityguide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val title = arguments?.getString("title")
        val description = arguments?.getString("description")
        val imageResId = arguments?.getInt("imageResId")

        val imageView = view.findViewById<ImageView>(R.id.detailImage)
        val titleText = view.findViewById<TextView>(R.id.detailTitle)
        val descriptionText = view.findViewById<TextView>(R.id.detailDescription)

        titleText.text = title
        descriptionText.text = description

        imageResId?.let {
            imageView.setImageResource(it)
        }
    }
}