package org.readora.readout.book.audiobook.presentation.audiobook_saved

import org.readora.readout.book.audiobook.domain.entity.AudioBook

sealed interface AudioBookSavedAction {
    data class OnBookClick(val book: AudioBook) : AudioBookSavedAction
    data object OnBackClick : AudioBookSavedAction
}