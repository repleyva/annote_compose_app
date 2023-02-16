buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        maven { url = uri("https://maven.google.com") }
        maven { url = uri("https://jitpack.io") }
    }
    dependencies {
        classpath(Build.androidGradlePlugin)
        classpath(Build.kotlinGradlePlugin)
    }
}

plugins {
    id(Pluggins.hilt) version "2.44" apply false
    id(Pluggins.androidLibrary) version("7.3.1") apply false
    kotlin(Pluggins.kotlinAndroid) version(kotlinVersion) apply false
    kotlin(Pluggins.kotlinJvm) version(kotlinVersion) apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}