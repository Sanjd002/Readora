package org.readora.readout.book.openbook.presentation.openbook_saved

import org.readora.readout.book.openbook.domain.entity.Book

sealed interface BookSavedAction {
    data class OnBookClick(val book: Book) : BookSavedAction
    data object OnBackClick : BookSavedAction
}