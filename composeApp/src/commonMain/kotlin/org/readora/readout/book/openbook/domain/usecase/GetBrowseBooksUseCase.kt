package org.readora.readout.book.openbook.domain.usecase

import org.readora.readout.book.openbook.domain.entity.Book
import org.readora.readout.book.openbook.domain.repository.BookRepository
import org.readora.readout.core.utils.DataError
import org.readora.readout.core.utils.Result

class GetBrowseBooksUseCase(
    private val bookRepository: BookRepository
) {
    suspend operator fun invoke(
        subject: String?,
        offset: Int,
        limit: Int
    ): Result<List<Book>, DataError.Remote> {
        return bookRepository.getBrowseBooks(subject = subject, offset = offset, limit = limit)
    }
}