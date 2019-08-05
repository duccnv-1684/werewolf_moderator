object Versions {
    const val kotlin = "1.3.10"
    const val androidPlugin = "3.5.0-rc02"
    const val androidxCore = "1.0.0-rc02"
    const val archCore = "2.0.0-beta01"
    const val room = "2.0.0-beta01"
    const val lifecycle = "2.0.0-beta01"
    const val navigation = "2.1.0-beta02"
    const val support = "1.0.0-rc02"
    const val glide = "4.7.1"
    const val koin = "1.0.1"
    const val junit = "4.12"
    const val espresso = "3.1.0-alpha4"
    const val mockito = "2.7.19"
    const val mockitoAll = "1.10.19"
    const val hamcrest = "1.3"
    const val atslRunner = "1.1.0-alpha1"
    const val atslRules = "1.1.0-alpha1"
    const val mockWebserver = "3.8.1"
    const val robolectric = "3.4.2"
    const val retrofit = "2.3.0"
    const val okLogging = "3.9.0"
    const val constraintLaout = "1.1.3"
    const val rxJava = "2.2.2"
    const val rxAndroid = "2.1.0"
    const val timber = "4.5.1"
    const val easyPermission = "1.3.1"
    /**
    versions.multi_dex = '1.0.3'
    versions.dagger = "2.16"
    versions.apache_commons = "2.5"
    versions.dexmaker = "2.2.0"
    versions.paging = "1.0.0"
    versions.work = "1.0.0-alpha02"
    versions.easy_permission = "1.3.1"
     */
}

object BuildPlugins {
    const val androidPlugin = "com.android.tools.build:gradle:${Versions.androidPlugin}"
}

object Android {
    const val minSdk = 21
    const val targetSdk = 28
    const val applicationId = "com.example.clean"
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object GradlePlugins {
    const val android = "com.android.application"
    const val kotlin = "kotlin"
    const val kotlinAndroid = "android"
    const val kotlinExt = "android.extensions"
    const val kotlinApt = "kapt"
    const val javaLib = "java-library"
    const val androidLib = "com.android.library"
}

object Modules {
    const val domain = ":domain"
    const val data = ":data"
}

object AndroidJUnit {
    const val runner = "android.support.test.runner.AndroidJUnitRunner"
}

object BuildType {
    const val debug = "debug"
    const val release = "release"

    const val minifyRelease = true
    const val proguardRelease = "proguard-rules.pro"

    const val minifyDebug = false
    const val proguardDebug = "proguard-rules.pro"
}

object Libs {
    //KTX
    const val ktx = "androidx.core:core-ktx:${Versions.androidxCore}"
    const val archTesting = "androidx.arch.core:core-testing:${Versions.archCore}"
    const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"

    // Support libs
    const val supportAnnotations = "androidx.annotation:annotation:${Versions.support}"
    const val supportAppCompat = "androidx.appcompat:appcompat:${Versions.support}"
    const val supportRecyclerview = "androidx.recyclerview:recyclerview:${Versions.support}"
    const val supportCardview = "androidx.cardview:cardview:${Versions.support}"
    const val supportDesign = "com.google.android.material:material:${Versions.support}"
    const val supportV4 = "androidx.legacy:legacy-support-v4:${Versions.support}"

    // Constraint Layout
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLaout}"

    // databinding compiler
    const val bindingCompiler = "androidx.databinding:databinding-compiler:${Versions.androidPlugin}"

    // room database
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomRxjava2 = "androidx.room:room-rxjava2:${Versions.room}"

    // lifecycle
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"

    // navigation
    const val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    // RxKotlin & RxJava
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"

    // retrofit
    const val retrofitRuntime = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofitMock = "com.squareup.retrofit2:retrofit-mock:${Versions.retrofit}"
    const val retrofitAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val okLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okLogging}"

    // Glide for image loader
    const val glideRuntime = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    // Permission for AndroidX
    const val permission = "com.github.bachhoan88:permissionsx:${Versions.easyPermission}"

    // Timber for logging
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    // JUnit for testing
    const val junit = "junit:junit:${Versions.junit}"

    // KTX testing
    const val kotlinTest = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlinAllopen = "org.jetbrains.kotlin:kotlin-allopen:${Versions.kotlin}"

    // Ruler & Runner testing
    const val atslRunner = "androidx.test:runner:$${Versions.atslRunner}"
    const val atslRules = "androidx.test:rules:${Versions.atslRules}"

    // espresso for testing
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso}"
    const val espressoIntents = "androidx.test.espresso:espresso-intents:${Versions.espresso}"

    // robolectric for testing
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"

    // Mockito for testing
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockitoAll = "org.mockito:mockito-all:${Versions.mockitoAll}"
    const val mockitoWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebserver}"

    // Hamcrest for testing
    const val hamcrest = "org.hamcrest:hamcrest-all:${Versions.hamcrest}"

    // KOIN
    const val koinCore = "org.koin:koin-core:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    const val koinScope = "org.koin:koin-androidx-scope:${Versions.koin}"
    const val koinJava = "org.koin:koin-java:${Versions.koin}"

    const val koinTest = "org.koin:koin-test:${Versions.koin}"
}