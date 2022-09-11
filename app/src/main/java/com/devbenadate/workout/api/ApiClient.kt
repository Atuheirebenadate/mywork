package com.devbenadate.workout.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    var retrofit =Retrofit.Builder()
        .baseUrl("http://192.81.125.35")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun <T>buildApiCleint(apiInterface:Class<T>):T{
        return retrofit.create(apiInterface)
    }
}