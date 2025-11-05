plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.cultiveplus.cultiveplusapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.cultiveplus.cultiveplusapp"
        minSdk = 28
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
        viewBinding = true
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
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    val retrofit_version = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")

    val coroutines_version = "1.7.3" // Use a versão mais recente
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version")

    // 3. (Opcional, mas recomendado) Logging de requisições com OkHttp
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    // Dependência necessária para 'by viewModels()' e outras extensões de Fragment.
    val fragment_version = "1.7.0" // Use a versão mais recente
    implementation("androidx.fragment:fragment-ktx:$fragment_version")

    // Dependência para 'by viewModels()' em Activity (embora você esteja em Fragment, é bom ter)
    val activity_version = "1.9.0" // Use a versão mais recente
    implementation("androidx.activity:activity-ktx:$activity_version")

    // Dependência de Lifecycle e ViewModel
    val lifecycle_version = "2.8.0" // Use a versão mais recente
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // (Opcional, mas comum)
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
}