package com.example.mvvmdemomaster.apiService

import com.example.mvvmdemomaster.retroFit.UserItem
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Tirth Patel.
 */
interface UserService {
    @GET("users")
suspend fun getData():Response<List<UserItem>>
}