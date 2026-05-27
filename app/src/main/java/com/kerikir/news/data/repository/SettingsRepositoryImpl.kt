package com.kerikir.news.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.kerikir.news.data.mapper.toInterval
import com.kerikir.news.domain.entity.Language
import com.kerikir.news.domain.entity.Settings
import com.kerikir.news.domain.repository.SettingsRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")


class SettingsRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : SettingsRepository {

    private val languageKey = stringPreferencesKey("language")
    private val intervalKey = intPreferencesKey("interval")
    private val notificationsEnabledKey = booleanPreferencesKey("notifications_enabled")
    private val wifiOnlyKey = booleanPreferencesKey("wifi_only")


    override fun getSettings(): Flow<Settings> {
        return context.dataStore.data.map { preferences ->
            val languageAsString = preferences[languageKey] ?: Language.ENGLISH.name
            val language = Language.valueOf(languageAsString)
            val intervalMinutes = preferences[intervalKey] ?: 15
            val interval = intervalMinutes.toInterval()
            val notificationsEnabled = preferences[notificationsEnabledKey] ?: false
            val wifiOnly = preferences[wifiOnlyKey] ?: false

            Settings(
                language = language,
                interval = interval,
                notificationsEnabled = notificationsEnabled,
                wifiOnly = wifiOnly
            )
        }
    }

    override suspend fun updateLanguage(language: Language) {
        TODO("Not yet implemented")
    }

    override suspend fun updateInterval(minutes: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun updateNotificationsEnabled(enabled: Boolean) {
        TODO("Not yet implemented")
    }

    override suspend fun updateWifiOnly(wifiOnly: Boolean) {
        TODO("Not yet implemented")
    }
}