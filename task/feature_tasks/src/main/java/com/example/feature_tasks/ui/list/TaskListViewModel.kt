package com.example.feature_tasks.ui.list

import android.util.Log
import com.example.core_common.viewModel.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TaskListViewModel(override val dispatchers: Dispatchers) :BaseViewModel() {
    /** State экрана со списком заданий */
    val screenState: StateFlow<TaskListState> get() = _screenState.asStateFlow()
    private val _screenState = MutableStateFlow(TaskListState())
    override fun handleError(throwable: Throwable) {
        Log.e("TaskListViewModel", throwable.toString())
        _screenState.update {
            it.copy(
                errorMessage = throwable.message?:"Error"
            )
        }
    }
}