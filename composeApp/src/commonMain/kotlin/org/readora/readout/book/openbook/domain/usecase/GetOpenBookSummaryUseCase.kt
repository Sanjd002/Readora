package org.readora.readout.book.openbook.domain.usecase

import org.readora.readout.book.openbook.domain.repository.BookRepository
import org.readora.readout.core.utils.DataError
import org.readora.readout.core.utils.Result

class GetOpenBookSummaryUseCase (
    private val repository: BookRepository
) {
    suspend operator fun invoke(prompt: String, bookId: String): Result<String?, DataError> {
        return repository.getBookSummary(prompt, bookId)
    }
}