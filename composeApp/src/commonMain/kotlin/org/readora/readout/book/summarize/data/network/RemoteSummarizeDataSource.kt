package org.readora.readout.book.summarize.data.network

import org.readora.readout.core.utils.DataError
import org.readora.readout.core.utils.Result
import org.readora.readout.core.gemini.dto.GeminiResponseDto

interface RemoteSummarizeDataSource {
    suspend fun fetchBookSummary(prompt: String): Result<GeminiResponseDto, DataError.Remote>
}