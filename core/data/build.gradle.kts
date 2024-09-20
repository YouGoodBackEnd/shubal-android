plugins {
    alias(libs.plugins.shubal.android.library)
    alias(libs.plugins.shubal.hilt)
    id("kotlinx-serialization")

}

android {
    namespace = "com.danguback.core.data"
}

dependencies {
    api(project(":core:common"))
}