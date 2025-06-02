package org.readora.readout.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import org.readora.readout.app.navigation.NavigationScreenRoot
import org.readora.readout.app.setting.SettingViewModel
import org.readora.readout.core.theme.ReadOutTheme

@Composable
@Preview
fun App() {
    KoinContext {
        val settingViewModel = koinViewModel<SettingViewModel>()
        val settingState by settingViewModel.state.collectAsState()
        val currentTheme = settingState.currentTheme
        ReadOutTheme(currentTheme) {
            NavigationScreenRoot(settingViewModel)
        }
    }
}