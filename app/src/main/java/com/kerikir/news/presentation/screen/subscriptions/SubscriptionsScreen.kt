package com.kerikir.news.presentation.screen.subscriptions

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun SubscriptionsScreen(
    modifier: Modifier = Modifier,
    onNavigateToSettings: () -> Unit,
    viewModel: SubscriptionsViewModel = hiltViewModel()
) {}



@Composable
private fun SubscriptionsTopBar(
    modifier: Modifier = Modifier,
    onRefreshDataClick: () -> Unit,
    onClearArticlesClick: () -> Unit,
    onSettingsClick: () -> Unit
) {

}