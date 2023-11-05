import org.jetbrains.kotlin.konan.properties.Properties

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    kotlin("kapt")
}

android {
    namespace = "io.github.shofucchi.network"
    compileSdkPreview = "UpsideDownCake"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val apiKey = Properties().readLocalProperties(key = "API_KEY")
        buildConfigField("String", "API_KEY", "\"${apiKey}\"")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.ktx)
    implementation(libs.retrofit2)
    implementation(libs.retrofit2.kotlin.serialization.converter)
    implementation(libs.okhttp3)
    implementation(libs.kotlinx.serialization)
    implementation(libs.dagger.hilt)
    kapt(libs.dagger.hilt.compiler)
}

kapt {
    correctErrorTypes = true
}

fun Properties.readLocalProperties(key: String) = run {
    this.load(project.rootProject.file("local.properties").inputStream())
    return@run this.getProperty(key)
}