package com.example.core_common.viewModel

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel


// Стырено отсюда - https://github.com/appspell/jetpack_compose_navigation_and_dagger_2
// а с хилтом жить проще в компоузе
@Composable
inline fun <reified VM : ViewModel> injectViewModel(
    crossinline viewModelInstanceCreator: () -> VM
): VM = viewModel(
    modelClass = VM::class.java,
    factory = object : ViewModelProvider.Factory {
        override fun <VM : ViewModel> create(modelClass: Class<VM>): VM {
            return viewModelInstanceCreator() as VM
        }
    }
)