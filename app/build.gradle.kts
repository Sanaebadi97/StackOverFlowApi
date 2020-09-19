plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kaptPlugin)
    id(BuildPlugins.safeArgs)
}

android {
    compileSdkVersion(AndroidSdk.compileSdk)
    defaultConfig {
        applicationId = AndroidSdk.applicationId
        minSdkVersion(AndroidSdk.minSdk)
        targetSdkVersion(AndroidSdk.targetSdk)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures{
        viewBinding = true

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

    implementation(project(mapOf("path" to ":data")))
    api(project(mapOf("path" to ":domain")))

    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.material)

    implementation(Libraries.glide)
    implementation(Libraries.glideCompiler)

    implementation(JetPackLibraries.lifecycleViewModel)
    implementation(JetPackLibraries.lifecycleLiveData)


    implementation(JetPackLibraries.navigationFragment)
    implementation(JetPackLibraries.navigationUi)


    implementation(RXLibraries.rxAndroid)
    implementation(RXLibraries.rxJava)

    implementation(DaggerLib.dagger)
    implementation(DaggerLib.daggerSupport)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    kapt(DaggerLib.daggerCompiler)
    kapt(DaggerLib.daggerProcessor)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)
}