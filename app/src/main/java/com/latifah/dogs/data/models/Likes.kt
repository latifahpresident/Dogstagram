package com.latifah.dogs.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "likes")
data class Likes(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val likeImage : String
) : Parcelable
