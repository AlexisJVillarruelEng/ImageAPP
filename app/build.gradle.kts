import org.gradle.kotlin.dsl.implementation

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
}

android {
    namespace = "dev.alexisvillarruel.imageapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "dev.alexisvillarruel.imageapp"
        minSdk = 30
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.firebase.database)
    implementation(libs.firebase.auth)
    implementation(libs.androidx.credentials)
    implementation(libs.androidx.credentials.play.services.auth)
    implementation(libs.googleid)
    implementation(libs.firebase.firestore)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    //navigation
    implementation("androidx.navigation:navigation-compose:2.8.9")
    //livedata
    implementation("androidx.compose.runtime:runtime-livedata:1.7.8")
    //Coil compose
    implementation("io.coil-kt:coil-compose:2.2.2")
    //fuentes de google
    implementation("androidx.compose.ui:ui-text-google-fonts:1.7.8")
    //iconos exctendidos
    implementation("androidx.compose.material:material-icons-extended:1.7.8")
    //lottie
    implementation("com.airbnb.android:lottie-compose:6.0.0")
    implementation ("androidx.appcompat:appcompat:1.7.0")
    //Dagger hilt
    implementation("com.google.dagger:hilt-android:2.56.2")
    kapt("com.google.dagger:hilt-android-compiler:2.56.2")
    // ViewModel Hilt para Compose
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    //Firebase
    implementation(platform("com.google.firebase:firebase-bom:33.14.0"))
    //Datastore
    implementation("androidx.datastore:datastore-preferences:1.1.7")
    // Google Sign-In
    implementation ("com.google.android.gms:play-services-auth:21.3.0")
}