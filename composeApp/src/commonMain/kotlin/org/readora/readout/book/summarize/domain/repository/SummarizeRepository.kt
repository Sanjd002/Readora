package org.readora.readout.book.summarize.domain.repository

import org.readora.readout.core.utils.DataError
import org.readora.readout.core.utils.Result

interface SummarizeRepository {
    suspend fun getBookSummary(prompt: String): Result<String?, DataError>
}