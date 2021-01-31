package com.android.weatherapp.nextstack.nytimes.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("image")
fun loadImage(view: ImageView, url: String?) {
    url?.let {
        view.load(url)
    }
}