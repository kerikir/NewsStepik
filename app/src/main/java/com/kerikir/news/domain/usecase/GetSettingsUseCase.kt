package com.kerikir.news.domain.usecase

import com.kerikir.news.domain.entity.Settings
import com.kerikir.news.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSettingsUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {

    operator fun invoke(): Flow<Settings> = settingsRepository.getSettings()
}