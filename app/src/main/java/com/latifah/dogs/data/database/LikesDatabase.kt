package com.latifah.dogs.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.latifah.dogs.data.models.Likes
import com.latifah.dogs.logic.dao.HistoryDao
import com.latifah.dogs.logic.dao.LikesDao

@Database(entities = [Likes::class], version = 1, exportSchema = false)
abstract class LikesDatabase : RoomDatabase() {
    abstract val likesDao : LikesDao
//    abstract val historyDao: HistoryDao
    companion object {
        @Volatile
        private var INSTANCE : LikesDatabase? = null

        fun getInstance(context: Context) : LikesDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LikesDatabase::class.java,
                        "likes_db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}