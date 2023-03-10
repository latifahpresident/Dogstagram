package com.latifah.dogs.logic

import android.app.Application
import com.latifah.dogs.data.database.LikesDatabase
import com.latifah.dogs.logic.repository.LikesRepository

class LikesApplication : Application() {
    val database by lazy { LikesDatabase.getInstance(this)}
    val repository by lazy { LikesRepository(database.likesDao) }
}