package org.readora.readout.app.home.presentation.recentrelease

import org.readora.readout.book.audiobook.domain.entity.AudioBook

data class RecentReleaseState(
    val savedBooks: List<AudioBook> = emptyList()
)