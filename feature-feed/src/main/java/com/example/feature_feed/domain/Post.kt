package com.example.feature_feed.domain

data class Post(
    val header: String,
    val content: String,
    val images: List<String>
)