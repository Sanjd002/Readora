package org.readora.readout.app.home.domain.repository

import kotlinx.coroutines.flow.Flow
import org.readora.readout.book.audiobook.domain.entity.AudioBook
import org.readora.readout.book.openbook.domain.entity.Book
import org.readora.readout.core.utils.DataError
import org.readora.readout.core.utils.Result

interface HomeRepository {
    suspend fun getRecentReleasedAudioBooks(since: Long): Result<List<AudioBook>, DataError.Remote>
    suspend fun getTrendingBooks(): Result<List<Book>, DataError.Remote>
    fun getSavedNewReleaseBooks(): Flow<List<AudioBook>>
}