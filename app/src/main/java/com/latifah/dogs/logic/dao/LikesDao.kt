package com.latifah.dogs.logic.dao

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.latifah.dogs.data.models.Likes
import kotlinx.coroutines.flow.Flow

@Dao
interface LikesDao {
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLike(like : Likes)

    @Query("SELECT * FROM likes ORDER BY id DESC")
    fun getLikes() : Flow<List<Likes>>
}