package com.latifah.dogs.ui.viewmodel

import androidx.lifecycle.*
import com.latifah.dogs.data.models.Likes
import com.latifah.dogs.logic.repository.LikesRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class LikesViewModel(private val repository: LikesRepository) : ViewModel() {
    val allLikes : LiveData<List<Likes>> = repository.getLikes.asLiveData() //convert the flow to live data

    fun addLike(like: Likes) = CoroutineScope(Dispatchers.IO).launch {
        repository.addLike(like)
    }
}

class LikesViewModelFactory(private val repository: LikesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LikesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LikesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


