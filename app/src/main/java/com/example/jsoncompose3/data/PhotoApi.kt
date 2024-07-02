package com.example.jsoncompose3.data

import retrofit2.Call
import retrofit2.http.GET

interface PhotoApi {
    @GET("photos")
    fun getPhotos(): Call<List<Photo>>
}