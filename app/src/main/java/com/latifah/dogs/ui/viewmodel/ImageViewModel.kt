package com.latifah.dogs.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.latifah.dogs.network.DogsApi
import kotlinx.coroutines.launch
import java.lang.Exception

/*STEP 1: CREATE MUTABLE LIVE DATA VALUE FOR THE DOG IMAGE MODEL
* STEP 2: CREATE A LIVE DATA VALUE FOR THE DOG IMAGE MODEL
* STEP 3: MAKE AN INIT BLOCK TO CALL A RANDOM IMAGE IMMEDIATELY
* STEP 4: CREATE A FUNCTION TO LAUNCH A COROUTINE THAT WILL REACH OUT TO THE API AND GET A RANDOM IMAGE
*/


class ImageViewModel : ViewModel() {
    private val _message = MutableLiveData<String>() //mutable but can't be accessed out of this class
    val message : LiveData<String> = _message //immutable but can be accessed outside of this class


    private val _status = MutableLiveData<String>()
    val status : LiveData<String> = _status
    init {

        getDogImage()

    }

     fun getDogImage() {
        viewModelScope.launch {
            try {
                val response = DogsApi.retrofitService.getDogPics()
                Log.d("ImageView try", "res.message: ${response.message}")
                _message.value = response.message
                _status.value = response.status

                Log.d("ImageView Model", "getDogImage: $message")
            } catch (e: Exception) {
                _status.value = "Error: ${e.message}"
            }
        }

        }
    }
