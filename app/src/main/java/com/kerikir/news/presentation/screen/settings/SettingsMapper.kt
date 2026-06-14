package com.kerikir.news.presentation.screen.settings

import androidx.compose.runtime.Composable
import com.kerikir.news.domain.entity.Language


@Composable
fun Language.toReadableFormat(): String {
    return when(this) {
        Language.ENGLISH -> "English"
        Language.RUSSIAN -> "Русский"
        Language.FRENCH -> "Français"
        Language.GERMAN -> "Deutsch"
    }
}