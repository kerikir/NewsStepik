package com.kerikir.news.data.repository

import com.kerikir.news.domain.entity.Article
import com.kerikir.news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(

) : NewsRepository {
    override fun getAllSubscriptions(): Flow<List<String>> {
        TODO("Not yet implemented")
    }

    override suspend fun addSubscription(topic: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateArticlesForTopic(topic: String) {
        TODO("Not yet implemented")
    }

    override suspend fun removeSubscription(topic: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateArticlesForAllSubscription() {
        TODO("Not yet implemented")
    }

    override fun getArticlesByTopics(topics: List<String>): Flow<List<Article>> {
        TODO("Not yet implemented")
    }

    override suspend fun clearAllArticles(topics: List<String>) {
        TODO("Not yet implemented")
    }
}