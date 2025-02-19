import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.danguback.shubal.buildlogic"

// Configure the build-logic plugins to target JDK 17
// This matches the JDK used to build the project, and is not related to what is running on device.
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.firebase.crashlytics.gradlePlugin)
    compileOnly(libs.firebase.performance.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
    implementation(libs.truth)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "shubal.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "shubal.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationJacoco") {
            id = "shubal.android.application.jacoco"
            implementationClass = "AndroidApplicationJacocoConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "shubal.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "shubal.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = "shubal.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("androidLibraryJacoco") {
            id = "shubal.android.library.jacoco"
            implementationClass = "AndroidLibraryJacocoConventionPlugin"
        }
        register("androidTest") {
            id = "shubal.android.test"
            implementationClass = "AndroidTestConventionPlugin"
        }
        register("hilt") {
            id = "shubal.hilt"
            implementationClass = "HiltConventionPlugin"
        }
        register("androidRoom") {
            id = "shubal.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
        register("androidFirebase") {
            id = "shubal.android.application.firebase"
            implementationClass = "AndroidApplicationFirebaseConventionPlugin"
        }
        register("androidFlavors") {
            id = "shubal.android.application.flavors"
            implementationClass = "AndroidApplicationFlavorsConventionPlugin"
        }
        register("androidLint") {
            id = "shubal.android.lint"
            implementationClass = "AndroidLintConventionPlugin"
        }
        register("jvmLibrary") {
            id = "shubal.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
    }
}