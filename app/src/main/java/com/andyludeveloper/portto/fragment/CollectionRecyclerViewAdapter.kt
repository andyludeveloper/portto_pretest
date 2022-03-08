package com.andyludeveloper.portto.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.andyludeveloper.portto.R
import com.andyludeveloper.portto.databinding.FragmentCollectionBinding
import com.andyludeveloper.portto.model.Asset
import com.andyludeveloper.portto.utils.downloadImage
import com.andyludeveloper.portto.viewmodel.CollectionViewModel
import com.bumptech.glide.RequestManager


private const val TAG = "ViewAdapter"

class CollectionRecyclerViewAdapter
constructor(
    private val requestManager: RequestManager,
    private var data: List<Asset>,
    private val navController: NavController,
    private val viewModel: CollectionViewModel
) : RecyclerView.Adapter<CollectionRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentCollectionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.itemView.setOnClickListener {
            viewModel.setCurrentAsset(item)
            navController.navigate(R.id.action_collectionFragment_to_detailFragment)
        }
        holder.name.text = item.name
        requestManager.downloadImage(item.image_url, holder.image)
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(binding: FragmentCollectionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val name: TextView = binding.text
        val image: ImageView = binding.image
    }
}