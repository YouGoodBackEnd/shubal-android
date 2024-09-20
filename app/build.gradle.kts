import com.danguback.shubal.ShubalBuildType

plugins {
    alias(libs.plugins.shubal.android.application)
    alias(libs.plugins.shubal.android.application.compose)
    alias(libs.plugins.shubal.android.application.flavors)
    alias(libs.plugins.shubal.android.application.jacoco)
  //  alias(libs.plugins.shubal.android.application.firebase)
    alias(libs.plugins.shubal.hilt)
    id("com.google.android.gms.oss-licenses-plugin")
    alias(libs.plugins.roborazzi)
}

android {
    namespace = "com.danguback.shubal"
    defaultConfig {
        applicationId = "com.danguback.shubal"
        versionCode = 1
        versionName = "0.0.1" // X.Y.Z; X = Major, Y = minor, Z = Patch level

        // Custom test runner to set up Hilt dependency graph //TODO: 수정해야함.
        //testInstrumentationRunner =""
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = ShubalBuildType.DEBUG.applicationIdSuffix
        }
        release {
            isMinifyEnabled = true
            applicationIdSuffix = ShubalBuildType.RELEASE.applicationIdSuffix
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            // To publish on the Play store a private signing key is required, but to allow anyone
            // who clones the code to sign and run the release variant, use the debug signing key.
            // TODO: Abstract the signing configuration to a separate file to avoid hardcoding this.
            // Play 스토어에 게시하려면 개인 서명 키가 필요하지만 누구나 사용할 수 있도록 허용해야 합니다
            // 누가 코드를 복제하여 릴리스 변형에 서명하고 실행하는지, 디버그 서명 키를 사용합니다.
            // TODO: 서명 구성을 다른 파일로 추상화하여 하드코딩하지 않도록 합니다.
            signingConfig = signingConfigs.named("debug").get()
        }
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    /*implementation(projects.feature.interests)
    implementation(projects.feature.foryou)
    implementation(projects.feature.bookmarks)
    implementation(projects.feature.topic)
    implementation(projects.feature.search)
    implementation(projects.feature.settings)

    implementation(projects.core.common)
    implementation(projects.core.ui)
    implementation(projects.core.designsystem)
    implementation(projects.core.model)
    implementation(projects.core.analytics)
    implementation(projects.sync.work)*/

    implementation(project(":core:data"))
    implementation(project(":core:designsystem"))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3.adaptive)
    implementation(libs.androidx.compose.material3)
   // implementation(libs.androidx.compose.material3.adaptive.layout)
    //implementation(libs.androidx.compose.material3.adaptive.navigation)
    //implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.compose.runtime.tracing)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.window.core)
    implementation(libs.coil.kt)

    //ksp(libs.hilt.compiler)

    //debugImplementation(libs.androidx.compose.ui.testManifest)
    // debugImplementation(projects.uiTestHiltManifest)

    // kspTest(libs.hilt.compiler)

    //  testImplementation(projects.core.dataTest)
    //testImplementation(libs.hilt.android.testing)
    //  testImplementation(projects.sync.syncTest)

    //testDemoImplementation(libs.robolectric)
    //testDemoImplementation(libs.roborazzi)
    // testDemoImplementation(projects.core.screenshotTesting)

    androidTestImplementation(kotlin("test"))
    //androidTestImplementation(projects.core.dataTest)
    //androidTestImplementation(projects.core.datastoreTest)
    //androidTestImplementation(libs.androidx.test.espresso.core)
    //androidTestImplementation(libs.androidx.navigation.testing)
  //  androidTestImplementation(libs.androidx.compose.ui.test)
  //  androidTestImplementation(libs.hilt.android.testing)

}


dependencyGuard {
    configuration("prodReleaseRuntimeClasspath")
}
