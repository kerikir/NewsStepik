package com.kerikir.news.data.background

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.content.getSystemService
import com.kerikir.news.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NotificationsHelper @Inject constructor(
    @param:ApplicationContext private val context: Context
) {

    private val notificationManager = context.getSystemService<NotificationManager>()


    init {
        createNotificationChannel()
    }


    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                context.getString(R.string.new_articles),
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager?.createNotificationChannel(channel)
        }
    }


    companion object {

        private const val CHANNEL_ID = "new_articles"
    }
}