package org.readora.readout.app.home.data.mappers

import org.readora.readout.app.home.domain.entity.RecentlyViewedBooks
import org.readora.readout.book.audiobook.data.database.AudioBookEntity
import org.readora.readout.book.openbook.data.database.OpenBookEntity
import org.readora.readout.core.utils.BookType

fun OpenBookEntity.toRecentlyViewedBook(): RecentlyViewedBooks {
    return RecentlyViewedBooks(
        id = id,
        title = title,
        imgUrl = imgUrl,
        authors = authors,
        description = description,
        languages = languages.toString(),
        timeStamp = timeStamp,
        type = BookType.OPEN_BOOK
    )
}

fun AudioBookEntity.toRecentlyViewedBook(): RecentlyViewedBooks {
    return RecentlyViewedBooks(
        id = id,
        title = title,
        imgUrl = imgUrl,
        authors = authors,
        description = description,
        languages = language,
        timeStamp = timeStamp,
        type = BookType.AUDIO_BOOK
    )
}