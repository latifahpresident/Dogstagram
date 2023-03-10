package com.latifah.dogs.logic.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.latifah.dogs.data.models.History
import com.latifah.dogs.data.models.Likes
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addToHistory(image : History)

    @Query("SELECT * FROM likes ORDER BY id DESC")
    fun getHistory() : Flow<List<History>>
}