package com.peerbits.newsinshort.data.entity

data class NewsResponse (
    val status: String,
    val totalResults : Int,
    val articles: List<Article>
    )


data class Article(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)

data class Source(
    val id: String?,
    val name: String?
)
