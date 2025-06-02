package org.readora.readout.app.home.data.network

import org.readora.readout.book.audiobook.data.dto.SearchResponseDto
import org.readora.readout.book.openbook.data.dto.BrowseResponseDto
import org.readora.readout.core.utils.DataError
import org.readora.readout.core.utils.Result

interface RemoteHomeDataSource {
    suspend fun fetchRecentReleasedAudioBooks(since: Long): Result<SearchResponseDto, DataError.Remote>
    suspend fun fetchTrendingBooks(resultLimit: Int? = null): Result<BrowseResponseDto, DataError.Remote>
}