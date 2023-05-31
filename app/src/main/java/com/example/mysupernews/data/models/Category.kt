package com.example.mysupernews.data.models

data class Category(

    val category: String,
    val data: List<SuperNews>,
    val success: Boolean
)