package org.readora.readout.book.audiobook.domain.usecase

import org.readora.readout.book.audiobook.domain.entity.AudioBook
import org.readora.readout.book.audiobook.domain.repository.AudioBookRepository
import org.readora.readout.core.utils.DataError
import org.readora.readout.core.utils.Result

class SearchAudioBooksUseCase(
    private val audioBookRepository: AudioBookRepository
) {
    suspend operator fun invoke(query: String): Result<List<AudioBook>, DataError> {
        return audioBookRepository.searchAudioBooks(query)
    }
}