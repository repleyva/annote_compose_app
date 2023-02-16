
const val kotlinVersion = "1.8.0"
const val composeVersion = "1.3.3"
const val composeMaterialVersion = "1.3.1"
const val composeCompilerVersion = "1.4.0"

object Libraries {

    private object Versions {
        const val ktxVersion = "1.9.0"
        const val constraintLayoutVersion = "2.1.4"
        const val lifecycleVersion = "2.5.1"
        const val androidMaterialVersion = "1.6.1"
        const val activityVersion = "1.5.1"
        const val fragmentVersion = "1.5.5"
        const val junitVersion = "4.13"
        const val mockitoVersion = "2.19.0"
        const val mockitoKotlinVersion = "2.2.0"
        const val junitRulesVersion = "1.2.0"
        const val junitExtVersion = "1.1.1"
        const val testVersion = "1.4.0"
        const val espressoVersion = "3.2.0"
        const val viewPager2Version = "1.1.0-beta01"
        const val serializationVersion = "1.3.2"
        const val navComposeVersion = "2.5.3"
        const val lottieVersion = "5.2.0"
        const val roomVersion = "2.5.0"
    }

    /**
     * Testing
     */

    val testingLibraries = arrayOf(
        "junit:junit:${Versions.junitVersion}",
        "org.mockito:mockito-core:${Versions.mockitoVersion}",
        "org.mockito:mockito-inline:${Versions.mockitoVersion}",
        "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlinVersion}"
    )

    val androidTestLibraries = arrayOf(
        "androidx.test:core:${Versions.testVersion}",
        "androidx.test:runner:${Versions.testVersion}",
        "androidx.test:rules:${Versions.junitRulesVersion}",
        "androidx.test.ext:junit:${Versions.junitExtVersion}",
        "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
    )

    /**
     * Ktx
     */

    val kotlinKtx = arrayOf(
        "androidx.core:core-ktx:${Versions.ktxVersion}",
        "androidx.activity:activity-ktx:${Versions.activityVersion}",
        "androidx.fragment:fragment-ktx:${Versions.fragmentVersion}",
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serializationVersion}",
    )

    /**
     * Lifecycle
     */

    val lifecycleLibraries = arrayOf(
        "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycleVersion}",
        "androidx.lifecycle:lifecycle-extensions:2.2.0",
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}",
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}",
        "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycleVersion}"
    )

    /**
     * AndroidX
     */

    val androidXLibraries = arrayOf(
        "com.google.android.material:material:${Versions.androidMaterialVersion}",
        "androidx.cardview:cardview:1.0.0",
        "androidx.legacy:legacy-support-v4:1.0.0",
        "androidx.appcompat:appcompat:1.1.0",
        "androidx.recyclerview:recyclerview:1.1.0",
        "androidx.vectordrawable:vectordrawable:1.1.0",
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}",
        "androidx.viewpager2:viewpager2:${Versions.viewPager2Version}"
    )

    /**
     * Compose
     */

    val composeLibrary = arrayOf(
        "androidx.compose.ui:ui:$composeVersion",
        "androidx.compose.material:material:$composeMaterialVersion",
        "androidx.compose.ui:ui-tooling-preview:$composeVersion",
        "androidx.activity:activity-compose:1.5.0-rc01",
        "androidx.compose.compiler:compiler:$composeCompilerVersion",
        "androidx.constraintlayout:constraintlayout-compose:1.0.1",
        "androidx.compose.runtime:runtime-livedata:$composeVersion",
        "androidx.navigation:navigation-compose:${Versions.navComposeVersion}",
        "androidx.compose.foundation:foundation:1.3.1"
    )

    /**
     * Lottie
     */

    val lottieLibrary = "com.airbnb.android:lottie:${Versions.lottieVersion}"

    /**
     * Room
     */

    val roomLibrary = arrayOf(
        "androidx.room:room-runtime:${Versions.roomVersion}",
        "androidx.room:room-ktx:${Versions.roomVersion}"
    )
    val roomKaptLibrary =  "androidx.room:room-compiler:${Versions.roomVersion}"

    /**
     * Dagger Hilt
     */

    val hiltLibrary = arrayOf(
        "com.google.dagger:hilt-android:2.44",
        "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03",
        "androidx.hilt:hilt-navigation-compose:1.0.0",
        "androidx.hilt:hilt-work:1.0.0",
    )
    val hiltKaptLibrary = arrayOf(
        "com.google.dagger:hilt-android-compiler:2.44",
        "androidx.hilt:hilt-compiler:1.0.0"
    )

    /**
     * Datastore
     */

    val datastoreLibrary = "androidx.datastore:datastore-preferences:1.0.0"

    /**
     * Accompanist
     */

    val accompanistLibrary = listOf(
        "com.google.accompanist:accompanist-pager:0.24.3-alpha",
        "com.google.accompanist:accompanist-pager-indicators:0.24.3-alpha"
    )
}