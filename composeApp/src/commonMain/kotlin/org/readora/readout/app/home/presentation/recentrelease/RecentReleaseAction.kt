package org.readora.readout.app.home.presentation.recentrelease

import org.readora.readout.book.audiobook.domain.entity.AudioBook

sealed interface RecentReleaseAction {
    data class OnBookClick(val book: AudioBook) : RecentReleaseAction
    data object OnBackClick : RecentReleaseAction
}