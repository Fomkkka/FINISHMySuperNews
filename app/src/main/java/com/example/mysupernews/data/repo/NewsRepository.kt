package com.example.mysupernews.data.repo

import com.example.mysupernews.domain.NewsUseCase
import com.example.mysupernews.data.models.Category
import com.example.mysupernews.data.remote.network.NewsService

object NewsRepository {
    val api = NewsService.newsApi
    suspend fun getNews(category: String): Category {
        return api.getNews(category)
    }
}