package com.andyludeveloper.portto.utils

import android.widget.ImageView
import com.bumptech.glide.RequestManager

fun RequestManager.downloadImage(url: String, imageView: ImageView) {
    load(url).into(imageView)
}