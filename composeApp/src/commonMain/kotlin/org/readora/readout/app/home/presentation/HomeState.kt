package org.readora.readout.app.home.presentation

import org.readora.readout.app.home.domain.entity.RecentlyViewedBooks
import org.readora.readout.book.audiobook.domain.entity.AudioBook
import org.readora.readout.book.openbook.domain.entity.Book
import org.readora.readout.core.utils.UiText

data class HomeState(
    val showAboutDialog: Boolean = false,
    val recentlyViewedBooks: List<RecentlyViewedBooks> = emptyList(),
    val recentlyReleasedAudioBooks: List<AudioBook> = emptyList(),
    val isAudioBooksLoading: Boolean = false,
    val audioBooksErrorMsg: UiText? = null,

    val trendingBooks: List<Book> = emptyList(),
    val isTrendingLoading: Boolean = false,
    val trendingErrorMsg: UiText? = null,
)