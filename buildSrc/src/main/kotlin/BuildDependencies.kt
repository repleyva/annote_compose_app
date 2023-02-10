object Build {
    object Versions {
        const val buildToolsVersion = "7.2.2"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val googleServicePlugin = "com.google.gms:google-services:$googleServiceVersion"
    const val crashlyticsPlugin = "com.google.firebase:firebase-crashlytics-gradle:$crashlyticsVersion"

}