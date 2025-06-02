package org.readora.readout.core.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.readora.readout.core.utils.DATA_STORE_FILE_NAME

actual fun dataStorePreferences(): DataStore<Preferences> {
    return AppSettings.getDataStore {
        DATA_STORE_FILE_NAME
    }
}