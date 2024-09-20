plugins {
    alias(libs.plugins.shubal.jvm.library)
    alias(libs.plugins.shubal.hilt)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(kotlin("test"))
    testImplementation(libs.turbine)

}