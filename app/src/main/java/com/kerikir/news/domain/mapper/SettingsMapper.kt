package com.kerikir.news.domain.mapper

import com.kerikir.news.domain.entity.RefreshConfig
import com.kerikir.news.domain.entity.Settings

fun Settings.toRefreshConfig(): RefreshConfig {
    return RefreshConfig(language, interval, wifiOnly)
}