package com.kerikir.news.presentation.screen.settings

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel


@Composable
fun SettingsScreen(
   modifier: Modifier = Modifier,
   onBackClick: () -> Unit,
   viewModel: SettingsViewModel = hiltViewModel()
) {}



@Composable
private fun SettingsCard(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    content: @Composable () -> Unit
) {}