package com.latifah.dogs.ui.fragments.likes.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.latifah.dogs.data.models.Likes
import com.latifah.dogs.databinding.GridViewItemBinding

class LikesImageGridAdapter : ListAdapter<Likes,
        LikesImageGridAdapter.LikesViewHolder>(DiffCallback) {

    inner class LikesViewHolder(private var binding: GridViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(likes: Likes) {
            binding.photo = likes //this is binding the MarsPhoto to the variable that was created in the grid_view_item layout (remember it was also called photo?)
            binding.executePendingBindings() // forces data to execute immediately
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LikesImageGridAdapter.LikesViewHolder {
        return LikesViewHolder(
            GridViewItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: LikesViewHolder, position: Int) {
        val likesImage = getItem(position)
        holder.bind(likesImage)
    }



    companion object DiffCallback : DiffUtil.ItemCallback<Likes>() {
        override fun areItemsTheSame(oldItem: Likes, newItem: Likes): Boolean {
            Log.i("RV*****", "areItemsTheSame: $oldItem")
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Likes, newItem: Likes): Boolean {
            return oldItem.likeImage == newItem.likeImage
        }

    }



}