package org.readora.readout.core.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.readora.readout.book.audiobook.data.database.AudioBookDao
import org.readora.readout.book.audiobook.data.database.AudioBookEntity
import org.readora.readout.book.openbook.data.database.OpenBookDao
import org.readora.readout.book.openbook.data.database.OpenBookEntity
import org.readora.readout.book.summarize.data.database.SummarizeDao
import org.readora.readout.book.summarize.data.database.SummarizeEntity

@Database(
    entities = [
        OpenBookEntity::class,
        AudioBookEntity::class,
        SummarizeEntity::class
    ],
    version = 1
)

@TypeConverters(ReadOutTypeConverters::class)

@ConstructedBy(BookDatabaseConstructor::class)
abstract class ReadOutDatabase : RoomDatabase() {

    abstract val openBookDao: OpenBookDao
    abstract val audioBookDao: AudioBookDao
    abstract val summarizeDao: SummarizeDao

    companion object {
        const val READ_OUT_DB_NAME = "ReadOut.db"
    }

    suspend fun clearAllEntities() {
        openBookDao.clearAll()
        audioBookDao.clearAll()
        summarizeDao.clearAll()
    }
}