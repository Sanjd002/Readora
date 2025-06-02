package org.readora.readout.book.openbook.domain.usecase

import org.readora.readout.book.openbook.domain.entity.Book
import org.readora.readout.book.openbook.domain.repository.BookRepository
import org.readora.readout.core.utils.DataError
import org.readora.readout.core.utils.Result

class SearchBooksUseCase(
    private val bookRepository: BookRepository
) {
    suspend operator fun invoke(query: String): Result<List<Book>, DataError> {
        return bookRepository.searchBooksByQuery(query)
    }
}