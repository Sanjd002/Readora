package org.readora.readout.book.audiobook.presentation.audiobook_saved

import org.readora.readout.book.audiobook.domain.entity.AudioBook

data class AudioBookSavedState(
    val savedBooks: List<AudioBook> = emptyList()
)