package com.kerikir.news.data.background

import android.app.NotificationManager
import android.content.Context
import androidx.core.content.getSystemService
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NotificationsHelper @Inject constructor(
    @ApplicationContext context: Context
) {

    private val notificationManager = context.getSystemService<NotificationManager>()
}