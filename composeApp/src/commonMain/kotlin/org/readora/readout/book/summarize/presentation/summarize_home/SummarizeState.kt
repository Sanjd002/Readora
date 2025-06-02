package org.readora.readout.book.summarize.presentation.summarize_home

import org.readora.readout.book.summarize.domain.entity.Summarize
import org.readora.readout.core.utils.UiText

data class SummarizeState(
    val isSummaryRequest: Boolean = false,
    val isSummaryLoading: Boolean = false,
    val summaryErrorMsg: UiText? = null,
    val summarize: Summarize? = null,
)