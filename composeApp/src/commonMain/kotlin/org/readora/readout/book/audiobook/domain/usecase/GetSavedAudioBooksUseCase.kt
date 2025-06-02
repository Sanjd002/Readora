package org.readora.readout.book.audiobook.domain.usecase

import kotlinx.coroutines.flow.Flow
import org.readora.readout.book.audiobook.domain.entity.AudioBook
import org.readora.readout.book.audiobook.domain.repository.AudioBookRepository

class GetSavedAudioBooksUseCase (
    private val audioBookRepository: AudioBookRepository
) {
    operator fun invoke(): Flow<List<AudioBook>> {
        return audioBookRepository.getSavedBooks()
    }
}