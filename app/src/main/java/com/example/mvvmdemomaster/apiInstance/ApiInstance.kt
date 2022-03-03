package com.example.mvvmdemomaster.apiInstance

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Tirth Patel.
 */
object ApiInstance {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    fun getApiData() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}