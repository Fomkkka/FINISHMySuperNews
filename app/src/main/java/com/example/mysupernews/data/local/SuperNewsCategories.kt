package com.example.mysupernews.data.local

object SuperNewsCategories {
    private val categories = listOf(
        "technology",
        "science",
        "world",
        "politics",
        "sports",
        "automobile",
        "business",
        "startup",)

    fun getSuperNewsCategories(): List<String>{
        return categories
    }
}