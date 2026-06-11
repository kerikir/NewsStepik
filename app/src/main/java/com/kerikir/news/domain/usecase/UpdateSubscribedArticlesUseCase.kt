package com.kerikir.news.domain.usecase

import com.kerikir.news.domain.repository.NewsRepository
import javax.inject.Inject

class UpdateSubscribedArticlesUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(): List<String> {
        return newsRepository.updateArticlesForAllSubscription()
    }
}