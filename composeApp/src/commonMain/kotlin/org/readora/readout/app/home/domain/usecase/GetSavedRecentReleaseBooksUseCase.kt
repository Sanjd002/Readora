package org.readora.readout.app.home.domain.usecase

import kotlinx.coroutines.flow.Flow
import org.readora.readout.app.home.domain.repository.HomeRepository
import org.readora.readout.book.audiobook.domain.entity.AudioBook

class GetSavedRecentReleaseBooksUseCase (
    private val repository: HomeRepository
) {
    operator fun invoke(): Flow<List<AudioBook>> {
        return repository.getSavedNewReleaseBooks()
    }
}