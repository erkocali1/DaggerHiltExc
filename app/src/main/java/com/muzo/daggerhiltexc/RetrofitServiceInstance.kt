package com.muzo.daggerhiltexc

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServiceInstance {

    @GET("users")
    fun getPosts(): Call<List<Post>>
}