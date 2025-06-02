package org.readora.readout.book.openbook.domain.usecase

import org.readora.readout.book.openbook.domain.entity.Book
import org.readora.readout.book.openbook.domain.repository.BookRepository

class SaveBookUseCase(
    private val bookRepository: BookRepository
) {
    suspend operator fun invoke(book: Book) {
        bookRepository.saveBook(book)
    }
}