package org.readora.readout.book.audiobook.domain.usecase

import org.readora.readout.book.audiobook.domain.entity.AudioBook
import org.readora.readout.book.audiobook.domain.repository.AudioBookRepository

class SaveAudioBookUseCase(
    private val audioBookRepository: AudioBookRepository
) {
    suspend operator fun invoke(audioBook: AudioBook) {
        audioBookRepository.saveBook(audioBook)
    }
}