package org.readora.readout.app.home.domain.usecase

import org.readora.readout.app.home.domain.repository.HomeRepository
import org.readora.readout.book.openbook.domain.entity.Book
import org.readora.readout.core.utils.DataError
import org.readora.readout.core.utils.Result

class GetTrendingBooksUseCase(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke(): Result<List<Book>, DataError.Remote> {
        return homeRepository.getTrendingBooks()
    }
}