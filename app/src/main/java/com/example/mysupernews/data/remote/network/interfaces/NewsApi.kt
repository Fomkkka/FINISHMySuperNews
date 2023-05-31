package com.example.mysupernews.data.remote.network.interfaces

import com.example.mysupernews.data.models.Category
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("news")
    suspend fun getNews(@Query("category") category: String): Category
}