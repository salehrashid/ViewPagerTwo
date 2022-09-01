package com.app.viewpagertwo.network

import com.app.viewpagertwo.data.UserItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {
    @GET("users")
    fun getListUser(): Call<ArrayList<UserItem>>
}