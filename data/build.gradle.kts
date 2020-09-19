plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kaptPlugin)
}
android {
    compileSdkVersion(AndroidSdk.compileSdk)
    defaultConfig {
        minSdkVersion(AndroidSdk.minSdk)
        targetSdkVersion(AndroidSdk.targetSdk)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }

    flavorDimensions ("PlaceApp")
    productFlavors {
        create("tapsi") {
            setDimension("PlaceApp")
            buildConfigField("String", "API_BASE_URL", "\"https://api.stackexchange.com/2.2/\"")
        }

    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    // For Kotlin projects
    kotlinOptions {
        jvmTarget = "1.8"
    }

}


dependencies {
    implementation(project(mapOf("path" to ":domain")))

    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.ktxCore)

    implementation(DaggerLib.dagger)
    implementation(DaggerLib.daggerSupport)
    kapt(DaggerLib.daggerCompiler)
    kapt(DaggerLib.daggerProcessor)

    implementation(Networking.retrofit)
    implementation(Networking.rxRetrofitAdapter)
    implementation(Networking.converterScalars)
    implementation(Networking.converterMoshi)
    api(Networking.moshi)
    kapt(Networking.moshiKotlin)

    implementation(RXLibraries.rxAndroid)
    implementation(RXLibraries.rxJava)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)
    testImplementation(TestLibraries.mockitoKotlin)


}