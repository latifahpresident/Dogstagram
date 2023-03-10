package com.latifah.dogs.ui.bindingAdapters

import androidx.databinding.BindingAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.latifah.dogs.R
import com.latifah.dogs.data.models.Likes
import com.latifah.dogs.ui.fragments.likes.adapters.LikesImageGridAdapter


//@BindingAdapter("im")
//fun bindImage(imgView: ImageView, message: String?) {
//    message?.let {
//        val imgUri = message.toUri().buildUpon().scheme("https").build()
//        imgView.load(imgUri)
//    }
//}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
        }
    }
}

@BindingAdapter("likesImageUrl")
fun bindLikeImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
        }
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Likes>?) {
    val adapter = recyclerView.adapter as LikesImageGridAdapter //cast the adapter
    adapter.submitList(data) //send the list to the adapter
}
