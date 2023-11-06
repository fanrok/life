package com.example.core_common.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_common.coroutines.DispatchersProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    protected abstract val dispatchers: DispatchersProvider

    private val handler = CoroutineExceptionHandler { _, exception ->
        handleError(exception)
    }
    abstract fun handleError(throwable: Throwable)

    protected fun launch(
        job: Job = SupervisorJob(),
        dispatcher: CoroutineDispatcher = dispatchers.io,
        exceptionHandler: CoroutineExceptionHandler = handler,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit,
    ): Job =
        viewModelScope.launch(dispatcher + job + exceptionHandler, start, block)

    protected fun <T> Flow<T>.subscribe(
        onError: (Throwable) -> Unit = { handleError(it) },
        onComplete: (Throwable?) -> Unit = {},
        onNext: (T) -> Unit,
    ) = onEach { onNext(it) }
        .onCompletion { onComplete(it) }
        .catch { onError(it) }
        .launch()

    private fun <T> Flow<T>.launch(): Job = launch {
        collect()
    }

    protected inline fun <V> Result<V>.onFinish(block: () -> Unit): Result<V> = apply {
        block() }

    protected inline fun <V> Result<V>.handle(
        onError: (Throwable) -> Unit = { handleError(it) },
        onSuccess: (V) -> Unit = {}
    ) = this.onSuccess(onSuccess).onFailure(onError)
}