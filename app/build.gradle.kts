plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    //kotlin("kapt")
}

android {
    compileSdkVersion(Apps.compileSdk)
    buildToolsVersion("29.0.3")

    defaultConfig {
        applicationId = "com.marty.fragmentcomms"
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)
        versionCode = Apps.versionCode
        versionName = Apps.versionName
//        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }
}

//    buildTypes {
//        release {
//            minifyEnabled false
//            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
//        }
//    }

//}

dependencies {
//    implementation fileTree(dir: 'libs', include: ['*.jar'])
    //implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.core:core-ktx:1.2.0")
    implementation("io.reactivex.rxjava3:rxjava:3.0.4")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("com.jakewharton.rxbinding4:rxbinding:4.0.0")
    testImplementation("junit:junit:4.12")
    //androidTestImplementation("androidx.test.ext:junit:1.1.1")
    //androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}
