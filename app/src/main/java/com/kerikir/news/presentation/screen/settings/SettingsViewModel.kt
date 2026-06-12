package com.kerikir.news.presentation.screen.settings

import androidx.lifecycle.ViewModel
import com.kerikir.news.domain.entity.Interval
import com.kerikir.news.domain.entity.Language
import com.kerikir.news.domain.usecase.GetSettingsUseCase
import com.kerikir.news.domain.usecase.UpdateIntervalUseCase
import com.kerikir.news.domain.usecase.UpdateLanguageUseCase
import com.kerikir.news.domain.usecase.UpdateNotificationsEnabledUseCase
import com.kerikir.news.domain.usecase.UpdateWifiOnlyUseCase
import javax.inject.Inject


class SettingsViewModel @Inject constructor(
    private val getSettingsUseCase: GetSettingsUseCase,
    private val updateIntervalUseCase: UpdateIntervalUseCase,
    private val updateLanguageUseCase: UpdateLanguageUseCase,
    private val updateNotificationsEnabledUseCase: UpdateNotificationsEnabledUseCase,
    private val updateWifiOnlyUseCase: UpdateWifiOnlyUseCase
) : ViewModel() {
}



sealed interface SettingsState {

    data object Initial : SettingsState

    data class Configuration(
        val language: Language,
        val interval: Interval,
        val wifiOnly: Boolean,
        val notificationsEnable: Boolean,
        val languages: List<Language> = Language.entries,
        val intervals: List<Interval> = Interval.entries
    ) : SettingsState
}