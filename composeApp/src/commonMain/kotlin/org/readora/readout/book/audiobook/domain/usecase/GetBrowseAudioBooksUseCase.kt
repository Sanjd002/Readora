package org.readora.readout.book.audiobook.domain.usecase

import org.readora.readout.book.audiobook.domain.entity.AudioBook
import org.readora.readout.book.audiobook.domain.repository.AudioBookRepository
import org.readora.readout.core.utils.DataError
import org.readora.readout.core.utils.Result

class GetBrowseAudioBooksUseCase(
    private val audioBookRepository: AudioBookRepository
) {
    suspend operator fun invoke(
        genre: String?,
        offset: Int,
        limit: Int
    ): Result<List<AudioBook>, DataError> {
        return audioBookRepository.getBrowseAudioBooks(
            genre = genre,
            offset = offset,
            limit = limit
        )
    }
}