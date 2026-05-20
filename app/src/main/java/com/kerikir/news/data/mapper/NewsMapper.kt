package com.kerikir.news.data.mapper

import com.kerikir.news.data.local.ArticleDbModel
import com.kerikir.news.data.remote.NewsResponseDto
import java.text.SimpleDateFormat
import java.util.Locale

fun NewsResponseDto.toDbModels(topic: String): List<ArticleDbModel> {
    return this.articles.map {
        ArticleDbModel(
            title = it.title,
            description = it.description,
            url = it.url,
            imageUrl = it.urlToImage,
            sourceName = it.source.name,
            topic = topic,
            publishedAt = it.publishedAt
        )
    }
}


fun String.toTimestamp(): Long {
    val dateFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
}