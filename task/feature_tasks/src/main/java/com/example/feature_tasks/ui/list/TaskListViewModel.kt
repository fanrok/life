package com.example.feature_tasks.ui.list

import android.util.Log
import com.example.core_common.viewModel.BaseViewModel
import kotlinx.coroutines.Dispatchers
import java.util.logging.Logger

class TaskListViewModel(override val dispatchers: Dispatchers) :BaseViewModel() {

    override fun handleError(throwable: Throwable) {
        Log.e("TaskListViewModel", throwable.toString())

    }
}