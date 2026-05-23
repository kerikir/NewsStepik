package com.kerikir.news.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.net.toUri
import com.kerikir.news.domain.repository.NewsRepository
import com.kerikir.news.presentation.screen.subscriptions.SubscriptionsScreen
import com.kerikir.news.presentation.ui.theme.NewsTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var newsRepository: NewsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsTheme {
                SubscriptionsScreen(
                    onNavigateToSettings = {}
                )
            }
        }
    }
}