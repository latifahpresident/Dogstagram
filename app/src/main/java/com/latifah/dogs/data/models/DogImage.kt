package com.latifah.dogs.data.models

import com.squareup.moshi.Json

/*
* STEP 1: LIST ALL THE KEYS THAT ARE EXPECTED FROM THE JSON DATA IN A DATA CLASS
* STEP 2: GO TO DOGSAPISERVICE.KT*/
data class DogImage(
    @Json(name = "message")
    val message : String,
    @Json(name = "status")
    val status : String)
