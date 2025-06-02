package org.readora.readout.book.summarize.data.repository

import org.readora.readout.book.summarize.data.network.RemoteSummarizeDataSource
import org.readora.readout.book.summarize.domain.repository.SummarizeRepository
import org.readora.readout.core.utils.DataError
import org.readora.readout.core.utils.Result
import org.readora.readout.core.utils.map

class SummarizeRepositoryImpl(
    private val remoteSummarizeDataSource: RemoteSummarizeDataSource
) : SummarizeRepository {
    override suspend fun getBookSummary(prompt: String): Result<String?, DataError> {
        return remoteSummarizeDataSource.fetchBookSummary(prompt).map {
            it.candidates.first().content.parts.first().text
        }
    }
}