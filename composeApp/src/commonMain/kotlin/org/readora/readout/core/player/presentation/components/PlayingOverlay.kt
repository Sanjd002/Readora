package org.readora.readout.core.player.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.compose.viewmodel.koinViewModel
import org.readora.readout.core.player.presentation.PlayerAction
import org.readora.readout.core.player.presentation.PlayerViewModel
import org.readora.readout.core.utils.WindowSizes

@Composable
fun PlayingOverlay(
    windowSize: WindowSizes,
) {
    val playerViewModel = koinViewModel<PlayerViewModel>()
    val playerState by playerViewModel.state.collectAsState()

    if (playerState.isPlaying) {
        if (playerState.isCollapsed) {
            CollapsedView(
                onAction = { playerAction ->
                    when (playerAction) {
                        is PlayerAction.OnCollapseClick -> playerViewModel.onAction(playerAction)
                        else -> Unit
                    }
                }
            )
        } else {
            FullWidthView(
                state = playerState,
                windowSize = windowSize,
                onAction = { playerAction ->
                    playerViewModel.onAction(playerAction)
                }
            )
        }
    }
}