package com.ipe.demoapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

@BindingAdapter("loadImage")
fun bindingImage(imageView : ImageView,imageUrl : String){
    Glide.with(imageView.context).load(imageUrl).into(imageView)
}