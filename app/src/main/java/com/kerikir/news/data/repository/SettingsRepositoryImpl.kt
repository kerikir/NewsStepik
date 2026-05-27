package com.kerikir.news.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.kerikir.news.domain.entity.Language
import com.kerikir.news.domain.entity.Settings
import com.kerikir.news.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")


class SettingsRepositoryImpl @Inject constructor(

) : SettingsRepository {

    private val languageKey = stringPreferencesKey("language")
    private val intervalKey = intPreferencesKey("interval")
    private val notificationsEnabledKey = booleanPreferencesKey("notifications_enabled")
    private val wifiOnlyKey = booleanPreferencesKey("wifi_only")


    override fun getSettings(): Flow<Settings> {
        TODO("Not yet implemented")
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