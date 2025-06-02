package org.readora.readout.app.home.data.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import org.readora.readout.book.audiobook.data.dto.SearchResponseDto
import org.readora.readout.book.openbook.data.dto.BrowseResponseDto
import org.readora.readout.core.data.network.safeCall
import org.readora.readout.core.utils.DataError
import org.readora.readout.core.utils.Result
import org.readora.readout.core.utils.LIBRI_VOX_BASE_URL
import org.readora.readout.core.utils.OPEN_LIBRARY_BASE_URL
import org.readora.readout.core.utils.USER_AGENT

class RemoteHomeDataSourceImpl(
    private val httpClient: HttpClient
) : RemoteHomeDataSource {
    override suspend fun fetchRecentReleasedAudioBooks(since: Long): Result<SearchResponseDto, DataError.Remote> {
        return safeCall {
            httpClient.get(
                urlString = "$LIBRI_VOX_BASE_URL/audiobooks"
            ) {
                parameter("coverart", 1)
                parameter("since", since)
                parameter("format", "json")
            }
        }
    }

    override suspend fun fetchTrendingBooks(resultLimit: Int?): Result<BrowseResponseDto, DataError.Remote> {
        return safeCall {
            httpClient.get(
                urlString = "$OPEN_LIBRARY_BASE_URL/subjects/english.json"
            ) {
                header("User-Agent", USER_AGENT)
                parameter("limit", resultLimit)
            }
        }
    }
}