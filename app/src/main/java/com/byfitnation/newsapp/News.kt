package com.byfitnation.newsapp

import com.byfitnation.newsapp.Article

data class News(
    val articles: List<Article>,
    val totalResults: Int
)