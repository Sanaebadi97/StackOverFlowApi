import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(BuildPlugins.javaLibraryPlugin)
    id(BuildPlugins.kotlinPlugin)
    id(BuildPlugins.kaptPlugin)
}


dependencies {
    implementation(Libraries.kotlinStdLib)
    implementation(RXLibraries.rxAndroid)
    implementation(RXLibraries.rxJava)
    implementation(Libraries.arrow)

    implementation(DaggerLib.dagger)
    implementation(DaggerLib.daggerSupport)
    kapt(DaggerLib.daggerCompiler)
    kapt(DaggerLib.daggerProcessor)

    implementation(RXLibraries.rxAndroid)
    implementation(RXLibraries.rxJava)
    implementation(RXLibraries.rxKotlin)

    testImplementation(TestLibraries.junit4)
    testImplementation(TestLibraries.mockitoKotlin)
}


// compile bytecode to java 8 (default is java 6)
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}