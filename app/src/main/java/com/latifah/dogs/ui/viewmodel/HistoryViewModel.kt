package com.latifah.dogs.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HistoryViewModel : ViewModel() {
   private val _image = MutableLiveData<String>()
    val image : LiveData<String> = _image


}