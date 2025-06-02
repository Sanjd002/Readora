package org.readora.readout.core.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.readora.readout.core.data.database.DatabaseFactory
import org.readora.readout.core.data.datastore.dataStorePreferences
import org.readora.readout.core.player.PlayerController

actual val platformModule = module {
    single { DatabaseFactory() }
    singleOf(::dataStorePreferences)
    singleOf(::PlayerController)
}