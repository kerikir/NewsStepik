package com.kerikir.news.presentation.screen.settings

import androidx.lifecycle.ViewModel
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