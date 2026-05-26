package com.kerikir.news.domain.usecase

import com.kerikir.news.domain.entity.Interval
import com.kerikir.news.domain.entity.Settings
import com.kerikir.news.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpdateIntervalUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {

    suspend operator fun invoke(interval: Interval) {
        settingsRepository.updateInterval(interval.minutes)
    }
}