package org.readora.readout.book.audiobook.data.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.readora.readout.book.audiobook.data.dto.AudioBookTrackResponseDto
import org.readora.readout.book.audiobook.data.dto.SearchResponseDto
import org.readora.readout.core.data.network.safeCall
import org.readora.readout.core.gemini.dto.ContentItem
import org.readora.readout.core.gemini.dto.GeminiResponseDto
import org.readora.readout.core.gemini.dto.RequestBody
import org.readora.readout.core.gemini.dto.RequestPart
import org.readora.readout.core.utils.DataError
import org.readora.readout.core.utils.GEMINI_API_KEY
import org.readora.readout.core.utils.GEMINI_BASE_URL
import org.readora.readout.core.utils.GEMINI_FLASH
import org.readora.readout.core.utils.Result
import org.readora.readout.core.utils.LIBRI_VOX_BASE_URL

class RemoteAudioBookDataSourceImpl(
    private val httpClient: HttpClient
) : RemoteAudioBookDataSource {

    override suspend fun searchAudioBooks(
        query: String,
        resultLimit: Int?
    ): Result<SearchResponseDto, DataError.Remote> {
        return safeCall {
            httpClient.get(
                urlString = "${LIBRI_VOX_BASE_URL}/audiobooks"
            ) {
                parameter("title", "^${query}")
                parameter("coverart", 1)
                parameter("limit", resultLimit)
                parameter("format", "json")
            }
        }
    }

    override suspend fun fetchBookSummary(prompt: String): Result<GeminiResponseDto, DataError.Remote> {
        return safeCall<GeminiResponseDto> {
            val requestBody = RequestBody(
                contents = listOf(
                    ContentItem(
                        parts = listOf(RequestPart(text = prompt))
                    )
                )
            )
            httpClient.post(
                urlString = "$GEMINI_BASE_URL/v1beta/models/$GEMINI_FLASH:generateContent"
            ) {
                parameter("key", GEMINI_API_KEY)
                setBody(
                    Json.encodeToString(requestBody)
                )
            }
        }
    }

    override suspend fun fetchBrowseAudioBooks(
        genre: String?,
        offset: Int?,
        limit: Int
    ): Result<SearchResponseDto, DataError.Remote> {
        return safeCall {
            httpClient.get(
                urlString = "${LIBRI_VOX_BASE_URL}/audiobooks"
            ) {
                parameter("coverart", 1)
                parameter("offset", offset)
                parameter("limit", limit)
                parameter("genre", genre)
                parameter("format", "json")
            }
        }
    }

    override suspend fun fetchAudioBookTracks(
        audioBookId: String
    ): Result<AudioBookTrackResponseDto, DataError.Remote> {
        return safeCall {
            httpClient.get(
                urlString = "${LIBRI_VOX_BASE_URL}/audiotracks"
            ) {
                parameter("project_id", audioBookId)
                parameter("format", "json")
            }
        }
    }
}