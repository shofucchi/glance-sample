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

rootProject.name = "glance-sample"
include(":app")
include(":core")
include(":core:ui")
include(":glance")
include(":core:network")
include(":core:data")
include(":core:data:database")
include(":core:data:repository")
