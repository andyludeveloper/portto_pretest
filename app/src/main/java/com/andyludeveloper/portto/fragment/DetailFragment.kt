package com.andyludeveloper.portto.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.andyludeveloper.portto.R
import com.andyludeveloper.portto.viewmodel.CollectionViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private val collectionViewModel: CollectionViewModel by activityViewModels()

    private lateinit var requestManager: RequestManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestManager = Glide.with(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view.findViewById<TextView>(R.id.text)
        val imageView = view.findViewById<ImageView>(R.id.image)
        val descriptionView = view.findViewById<TextView>(R.id.description)
        val permalinkBtn = view.findViewById<Button>(R.id.permalink)

        collectionViewModel.currentAsset.observe(viewLifecycleOwner) { asset ->
            textView.text = asset.name
            requestManager.load(asset.image_url).into(imageView)
            descriptionView.text = asset.collection.description
            permalinkBtn.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    asset.collection.description,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}