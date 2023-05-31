package com.example.mysupernews.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SuperNews(
    val author: String,
    val content: String,
    val date: String,
    val imageUrl: String?,
    val readMoreUrl: String?,
    val time: String,
    val title: String,
    val url: String
): Parcelable