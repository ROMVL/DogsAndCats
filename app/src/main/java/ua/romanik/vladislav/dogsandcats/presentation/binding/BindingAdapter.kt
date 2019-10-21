package ua.romanik.vladislav.dogsandcats.presentation.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import ua.romanik.vladislav.dogsandcats.R

@BindingAdapter("app:loadImage")
fun ImageView.loadImage(url: String) {
    Picasso.get()
        .load(url)
        .placeholder(R.drawable.ic_loading_placeholder)
        .into(this)
}