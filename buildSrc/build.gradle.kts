import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

repositories {
    jcenter()
}

plugins {
    `kotlin-dsl`
    kotlin("jvm") version "1.4.10"
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}