package org.readora.readout.book.openbook.domain.usecase

import org.readora.readout.book.openbook.domain.repository.BookRepository

class DeleteBookFromSavedUseCase (
    private val bookRepository: BookRepository
) {
    suspend operator fun invoke(bookId: String) {
        bookRepository.deleteFromSaved(bookId)
    }
}