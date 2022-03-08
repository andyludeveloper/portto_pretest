package com.andyludeveloper.portto.fragment

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andyludeveloper.portto.databinding.FragmentCollectionBinding
import com.andyludeveloper.portto.model.Asset
import com.bumptech.glide.RequestManager

private const val TAG = "ViewAdapter"

class CollectionRecyclerViewAdapter
constructor(
    private val requestManager: RequestManager,
    private var data: List<Asset>,
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
        holder.name.text = item.name
        downloadImage(item.image_url, holder.image)
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(binding: FragmentCollectionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val name: TextView = binding.text
        val image: ImageView = binding.image
    }

    private fun downloadImage(url: String, imageView: ImageView) {
        Log.d(TAG, "downloadImage: $url")
        requestManager.load(url).into(imageView)
    }
}