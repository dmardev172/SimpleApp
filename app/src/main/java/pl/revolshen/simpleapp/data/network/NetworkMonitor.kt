package pl.revolshen.simpleapp.data.network

import kotlinx.coroutines.flow.Flow

interface NetworkMonitor {

    val isOnline: Flow<Boolean>
}