package com.andyludeveloper.portto.fragment

import android.graphics.drawable.PictureDrawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andyludeveloper.portto.R
import com.andyludeveloper.portto.utils.Constants
import com.andyludeveloper.portto.viewmodel.CollectionViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CollectionFragment : Fragment(R.layout.fragment_collection_list) {
    private val driverViewModel: CollectionViewModel by viewModels()
    private lateinit var requestManager: RequestManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestManager = Glide.with(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        driverViewModel.collections.observe(viewLifecycleOwner) {
            if (view is RecyclerView) {
                with(view) {
                    layoutManager = GridLayoutManager(context, Constants.COLUMN_COUNT)
                    adapter = CollectionRecyclerViewAdapter(requestManager, it)
                }
            }
        }
    }
}