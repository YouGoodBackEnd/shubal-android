plugins {
    alias(libs.plugins.shubal.android.library)
    alias(libs.plugins.shubal.hilt)
}

android {
    namespace = "com.danguback.core.testing"
}

dependencies {
    api(libs.kotlinx.coroutines.test)
   /* api(projects.core.analytics)
    api(projects.core.common)
    api(projects.core.data)
    api(projects.core.model)
    api(projects.core.notifications)*/


    implementation(libs.androidx.test.rules)
    implementation(libs.hilt.android.testing)
    implementation(libs.kotlinx.datetime)
    implementation(libs.androidx.runner)
}