package org.readora.readout.book.summarize.domain.usecase

import org.readora.readout.book.summarize.domain.repository.SummarizeRepository
import org.readora.readout.core.utils.DataError
import org.readora.readout.core.utils.Result

class GetBookSummaryUseCase(
    private val summarizeRepository: SummarizeRepository
) {
    suspend operator fun invoke(prompt: String): Result<String?, DataError> {
        return summarizeRepository.getBookSummary(prompt)
    }
}