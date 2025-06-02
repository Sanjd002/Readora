package org.readora.readout.book.openbook.domain.usecase

import kotlinx.coroutines.flow.Flow
import org.readora.readout.book.openbook.domain.entity.Book
import org.readora.readout.book.openbook.domain.repository.BookRepository

class GetSaveBooksUseCase(
    private val bookRepository: BookRepository
) {
    operator fun invoke(): Flow<List<Book>> {
        return bookRepository.getSavedBooks()
    }
}