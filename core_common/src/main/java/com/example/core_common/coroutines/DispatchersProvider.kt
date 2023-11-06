package com.example.core_common.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface DispatchersProvider {

    val io: CoroutineDispatcher

    val main: CoroutineDispatcher

    val unconfined: CoroutineDispatcher

    val default: CoroutineDispatcher
}
