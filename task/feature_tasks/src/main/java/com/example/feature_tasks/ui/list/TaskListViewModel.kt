package com.example.feature_tasks.ui.list

import android.util.Log
import com.example.core_common.coroutines.DispatchersProvider
import com.example.core_common.scope.FeatureScope
import com.example.core_common.viewModel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@FeatureScope
class TaskListViewModel @Inject constructor(
    useCases: TaskListFacade,
    override val dispatchers: DispatchersProvider
) :BaseViewModel() {
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

    init {
        useCases.getTaskList.subscribe {tasks->
            _screenState.update {
                it.copy(
                    tasksList = tasks
                )
            }
        }
    }

    fun reserError() {
        _screenState.update {
            it.copy(
                errorMessage = null
            )
        }
    }
}