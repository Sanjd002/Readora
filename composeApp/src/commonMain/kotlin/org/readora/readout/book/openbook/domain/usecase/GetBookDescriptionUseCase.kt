package org.readora.readout.book.openbook.domain.usecase

import org.readora.readout.book.openbook.domain.repository.BookRepository
import org.readora.readout.core.utils.DataError
import org.readora.readout.core.utils.Result

class GetBookDescriptionUseCase(
    private val bookRepository: BookRepository
) {
    suspend operator fun invoke(bookId: String): Result<String?, DataError> {
        return bookRepository.getBookDescriptionById(bookId)
    }
}