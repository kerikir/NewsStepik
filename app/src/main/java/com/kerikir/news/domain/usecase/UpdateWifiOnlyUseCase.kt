package com.kerikir.news.domain.usecase

import com.kerikir.news.domain.entity.Language
import com.kerikir.news.domain.repository.SettingsRepository
import javax.inject.Inject

class UpdateWifiOnlyUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {

    suspend operator fun invoke(wifiOnly: Boolean) {
        settingsRepository.updateWifiOnly(wifiOnly)
    }
}