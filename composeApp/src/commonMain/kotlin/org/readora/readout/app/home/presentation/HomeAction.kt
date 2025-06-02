package org.readora.readout.app.home.presentation

import org.readora.readout.book.audiobook.domain.entity.AudioBook
import org.readora.readout.book.openbook.domain.entity.Book

sealed interface HomeAction {
    data object OnShowAboutDialog : HomeAction
    data object OnHideAboutDialog : HomeAction
    data object OnSummarizeClick : HomeAction
    data object OnSettingClick : HomeAction
    data object OnLoadAudioBooks : HomeAction
    data object OnLoadTrendingBooks : HomeAction
    data object OnViewAllNewReleasesClick : HomeAction
    data class OnAudioBookClick(val audioBook: AudioBook) : HomeAction
    data class OnBookClick(val book: Book) : HomeAction
}