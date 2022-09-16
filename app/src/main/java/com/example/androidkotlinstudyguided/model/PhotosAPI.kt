package com.example.androidkotlinstudyguided.model

import retrofit2.Call
import retrofit2.http.GET

interface PhotosAPI {

    @GET("photos")
    fun getPhotos(): Call<List<Photos>>
}