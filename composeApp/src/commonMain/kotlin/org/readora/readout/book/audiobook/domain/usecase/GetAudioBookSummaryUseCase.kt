package org.readora.readout.book.audiobook.domain.usecase

import org.readora.readout.book.audiobook.domain.repository.AudioBookRepository
import org.readora.readout.core.utils.DataError
import org.readora.readout.core.utils.Result

class GetAudioBookSummaryUseCase(
    private val audioBookRepository: AudioBookRepository
) {
    suspend operator fun invoke(prompt: String, bookId: String): Result<String?, DataError> {
        return audioBookRepository.getBookSummary(prompt, bookId)
    }
}