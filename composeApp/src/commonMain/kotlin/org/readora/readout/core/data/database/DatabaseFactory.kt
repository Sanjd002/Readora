package org.readora.readout.core.data.database

import androidx.room.RoomDatabase

expect class DatabaseFactory {
    fun create(): RoomDatabase.Builder<ReadOutDatabase>
}