pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Life"
include(":app")
include(":database")
include(":task:core_task")
include(":task:core_task:core_task_api")
include(":task:core_task:core_task_impl")
include(":task:feature_tasks")
include(":core_ui")
