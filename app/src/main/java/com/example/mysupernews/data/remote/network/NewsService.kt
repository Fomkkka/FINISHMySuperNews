package com.example.mysupernews.data.remote.network

import com.example.mysupernews.data.remote.network.interfaces.NewsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsService {


    private const val BASE_URL = "https://inshorts.deta.dev/"


    val newsApi: NewsApi = makeRetrofit().create(NewsApi::class.java)


    private fun makeRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)


        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}