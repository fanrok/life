package com.example.core_navigation.base

import androidx.navigation.NamedNavArgument

abstract class Routes {

    private val defaultRoute = this::class.simpleName!!
    open operator fun invoke() = route

    open val arguments: List<NamedNavArgument> = emptyList()

    val route: String = if (arguments.isEmpty()) defaultRoute else {
        val builder = StringBuilder(defaultRoute)
        arguments.forEach { builder.append("/{${it}}") }
        builder.toString()
    }
}

data object TaskListScreenRoute: Routes()

data object TaskCreateScreenRoute: Routes()

data object TaskDetailScreenRoute: Routes(){
    val TASK_ID = "task_id"
     operator fun invoke(taskId: String): String{
        return "${super.route}/$taskId"
    }
}

internal fun String.appendParams(vararg params: Pair<String, Any?>): String {
    val builder = StringBuilder(this)

    params.forEach {
        it.second?.toString()?.let { arg ->
            builder.append("/$arg")
        }
    }

    return builder.toString()
}