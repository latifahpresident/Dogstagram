package com.latifah.dogs.network

import com.latifah.dogs.data.models.DogImage
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

/*
* STEP 1: CREATE BASE URL
* STEP 2: MOSHI KOTLIN OBJECT BUILDER
* STEP 3: RETROFIT
* STEP 4: BUILD INTERFACE TO MAKE API CALL
* STEP 5: CREATE SINGLETON OBJECT TO EXPOSE DATA FROM API TO REST OF APP
* STEP 6: GO TO VIEW MODEL
*/

private const val BASE_URL = "https://dog.ceo/api/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val networkLoggingInterceptor =
    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .client(OkHttpClient.Builder().addInterceptor(networkLoggingInterceptor).build())
    .baseUrl(BASE_URL).build()

interface DogsApiService {
    @GET("breeds/image/random")
    suspend fun getDogPics() : DogImage
}

object DogsApi {
    val retrofitService : DogsApiService by lazy {
        retrofit.create(DogsApiService::class.java)
    }
}
