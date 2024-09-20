package com.danguback.shubal

/**
 * This is shared between :app and :benchmarks module to provide configurations type safety.
 */
enum class ShubalBuildType(val applicationIdSuffix: String? = null) {
    DEBUG(".debug"),
    RELEASE,
}