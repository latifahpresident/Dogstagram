package com.latifah.dogs.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "history")
data class History(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @Json(name = "message")
    val message : String,
    )
