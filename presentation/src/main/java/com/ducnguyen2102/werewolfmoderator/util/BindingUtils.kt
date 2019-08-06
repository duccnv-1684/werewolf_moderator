package com.ducnguyen2102.werewolfmoderator.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("textById")
fun TextView.setTextFromId(stringId: Int) {
    this.setText(stringId)
}

@BindingAdapter("drawableSrc")
fun ImageView.setDrawableSrc(drawableId: Int) {
    val requestOptions = RequestOptions.circleCropTransform()
    Glide.with(this).load(drawableId).thumbnail().apply(requestOptions).into(this)
}

