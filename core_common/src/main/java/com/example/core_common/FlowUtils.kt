package com.example.core_common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

inline fun <T, R> Flow<List<T>>.mapIterable(
    crossinline transform: suspend (value: T) -> R
): Flow<List<R>> =
    transform { list ->
        return@transform emit(list.map { value -> transform(value) })
    }