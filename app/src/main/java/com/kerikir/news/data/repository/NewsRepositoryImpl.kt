package com.kerikir.news.data.repository

import com.kerikir.news.data.local.ArticleDbModel
import com.kerikir.news.data.local.NewsDao
import com.kerikir.news.data.local.SubscriptionDbModel
import com.kerikir.news.data.mapper.toDbModels
import com.kerikir.news.data.remote.NewsApiService
import com.kerikir.news.domain.entity.Article
import com.kerikir.news.domain.repository.NewsRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsDao: NewsDao,
    private val newsApiService: NewsApiService
) : NewsRepository {

    override fun getAllSubscriptions(): Flow<List<String>> {
        return newsDao.getAllSubscriptions().map {  subscriptions ->
            subscriptions.map { it.topic }
        }
    }

    override suspend fun addSubscription(topic: String) {
        newsDao.addSubscription(SubscriptionDbModel(topic))
    }

    override suspend fun updateArticlesForTopic(topic: String) {
        val articles = loadArticles(topic)
        newsDao.addArticles(articles)
    }

    private suspend fun loadArticles(topic: String): List<ArticleDbModel> {
        return try {
            newsApiService.loadArticles(topic).toDbModels(topic)
        } catch (e: Exception) {
            if (e is CancellationException) {
                throw e
            }
            listOf()
        }
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