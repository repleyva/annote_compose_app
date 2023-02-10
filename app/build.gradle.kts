plugins {
    id(Pluggins.androidApplication)
    kotlin(Pluggins.kotlinKapt)
    kotlin(Pluggins.kotlinAndroid)
}

android {
    namespace = Application.appId
    compileSdk = Application.compileSdk

    defaultConfig {
        applicationId = Application.appId
        minSdk = Application.minSdk
        targetSdk = Application.targetSdk
        versionCode = Application.versionCode
        versionName = Application.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = composeCompilerVersion
    }
    packagingOptions {
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/gradle/incremental.annotation.processors")
    }
}

dependencies {

    Libraries.testingLibraries.forEach { implementation(it) }

    Libraries.androidXLibraries.forEach { implementation(it) }

    Libraries.composeLibrary.forEach { implementation(it) }

    Libraries.kotlinKtx.forEach { implementation(it) }

    Libraries.androidTestLibraries.forEach { implementation(it) }

    Libraries.lifecycleLibraries.forEach { implementation(it) }

}