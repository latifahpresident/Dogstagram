package com.latifah.dogs.logic.repository

import androidx.lifecycle.LiveData
import com.latifah.dogs.data.models.Likes
import com.latifah.dogs.logic.dao.LikesDao
import kotlinx.coroutines.flow.Flow

class LikesRepository (private val likesDao : LikesDao) {
    val getLikes : Flow<List<Likes>> = likesDao.getLikes()

     suspend fun addLike(like: Likes) {
        likesDao.addLike(like)
    }

}