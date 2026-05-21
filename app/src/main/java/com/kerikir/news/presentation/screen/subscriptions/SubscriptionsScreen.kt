@file:OptIn(ExperimentalMaterial3Api::class)

package com.kerikir.news.presentation.screen.subscriptions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.kerikir.news.R
import com.kerikir.news.domain.entity.Article

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
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = stringResource(R.string.subscriptions_title))
        },
        actions = {
            Icon(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable {
                        onRefreshDataClick()
                    }
                    .padding(8.dp),
                imageVector = Icons.Default.Refresh,
                contentDescription = stringResource(R.string.update_articles)
            )
            Icon(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable {
                        onClearArticlesClick()
                    }
                    .padding(8.dp),
                imageVector = Icons.Default.Clear,
                contentDescription = stringResource(R.string.clear_articles)
            )
            Icon(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable {
                        onSettingsClick()
                    }
                    .padding(8.dp),
                imageVector = Icons.Default.Settings,
                contentDescription = stringResource(R.string.settings_screen)
            )
        }
    )
}



@Composable
private fun SubscriptionChip(
   modifier: Modifier = Modifier,
   topic: String,
   isSelected: Boolean,
   onSubscriptionClick: (String) -> Unit,
   onDeleteSubscription: (String) -> Unit
) {
    FilterChip(
        modifier = modifier,
        selected = isSelected,
        onClick = {
            onSubscriptionClick(topic)
        },
        label = {
            Text(topic)
        },
        trailingIcon = {
            Icon(
                modifier = Modifier
                    .size(16.dp)
                    .clickable {
                        onDeleteSubscription(topic)
                    },
                imageVector = Icons.Default.Clear,
                contentDescription = stringResource(R.string.remove_subscription)
            )
        }
    )
}



@Composable
private fun Subscriptions(
   modifier: Modifier = Modifier,
   subscriptions: Map<String, Boolean>,
   query: String,
   isSubscribeButtonEnabled: Boolean,
   onQueryChanger: (String) -> Unit,
   onTopicClick: (String) -> Unit,
   onDeleteSubscription: (String) -> Unit,
   onSubscribeButtonClick: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = query,
            onValueChange = onQueryChanger,
            label = {
                Text(stringResource(R.string.what_interests_you))
            },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onSubscribeButtonClick,
            enabled = isSubscribeButtonEnabled
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = stringResource(R.string.add_subscription)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(stringResource(R.string.add_subscription_button))
        }

        if (subscriptions.isNotEmpty()) {
            Text(
                text = stringResource(R.string.subscriptions_label, subscriptions.size),
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                subscriptions.forEach { (topic, isSelected) ->
                    item(key = topic) {
                        SubscriptionChip(
                            topic = topic,
                            isSelected = isSelected,
                            onSubscriptionClick = onTopicClick,
                            onDeleteSubscription = onDeleteSubscription
                        )
                    }
                }
            }
        } else {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.no_subscriptions),
                textAlign = TextAlign.Center
            )
        }
    }
}



@Composable
private fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        article.imageUrl?.let { imageUrl ->
            AsyncImage(
                model = imageUrl,
                contentDescription = stringResource(R.string.image_for_article, article.title),
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 200.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}