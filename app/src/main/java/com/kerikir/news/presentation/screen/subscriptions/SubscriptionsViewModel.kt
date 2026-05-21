package com.kerikir.news.presentation.screen.subscriptions

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class SubscriptionsViewModel: ViewModel() {


}


sealed interface SubscriptionsCommand {

    data class InputTopic(val query: String) : SubscriptionsCommand

    data object ClickSubscribe : SubscriptionsCommand

    data object RefreshData : SubscriptionsCommand

    data class ToggleTopicSelection(val topic: String) : SubscriptionsCommand

    data object ClearArticles : SubscriptionsCommand

    data class RemoveSubscription(val topic: String) : SubscriptionsCommand
}