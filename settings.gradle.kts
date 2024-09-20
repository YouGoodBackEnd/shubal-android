pluginManagement {
    includeBuild("build-logic")
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

rootProject.name = "shubal"

include(":app")
include(":core:data")
include(":core:domain")
include(":core:analytics")
include(":core:designsystem")
include(":core:testing")
include(":core:common")
include(":feature:home")
