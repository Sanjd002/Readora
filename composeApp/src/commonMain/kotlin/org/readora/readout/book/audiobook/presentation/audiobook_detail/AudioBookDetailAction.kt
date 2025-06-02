package org.readora.readout.book.audiobook.presentation.audiobook_detail

import org.readora.readout.book.audiobook.domain.entity.AudioBook

sealed interface AudioBookDetailAction {
    data object OnBackClick : AudioBookDetailAction
    data object OnSaveClick : AudioBookDetailAction
    data object OnLoadAudioTracks : AudioBookDetailAction
    data object OnSummaryClick : AudioBookDetailAction
    data class OnPlayAllClick(val allUrls: List<String>): AudioBookDetailAction
    data class OnTabSelected(val index: Int) : AudioBookDetailAction
    data class OnSelectedBookChange(val audioBook: AudioBook) : AudioBookDetailAction
}