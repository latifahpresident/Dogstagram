package com.latifah.dogs.logic.repository

import com.latifah.dogs.data.models.History
import com.latifah.dogs.logic.dao.HistoryDao
import kotlinx.coroutines.flow.Flow

class HistoryRepository (private val historyDao: HistoryDao) {
    val getHistory : Flow<List<History>> = historyDao.getHistory()

    suspend fun addToHistory(image: History) {
        historyDao.addToHistory(image)
    }
}