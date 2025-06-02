package org.readora.readout.book.openbook.presentation.openbook_saved

import org.readora.readout.book.openbook.domain.entity.Book

data class BookSavedState(
    val savedBooks: List<Book> = emptyList()
)