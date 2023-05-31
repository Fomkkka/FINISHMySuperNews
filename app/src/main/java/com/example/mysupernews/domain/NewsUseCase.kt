package com.example.mysupernews.domain

import com.example.mysupernews.data.models.Category
import com.example.mysupernews.data.repo.NewsRepository

object NewsUseCase {
    suspend fun getNews(category: String): Category {
        return NewsRepository.getNews(category)
    }
}