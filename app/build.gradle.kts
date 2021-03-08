plugins {
  id("com.android.application")
  id("kotlin-android")
  id("com.google.firebase.firebase-perf")
  id("com.google.gms.google-services")
}

android {
  compileSdkVersion(30)
  buildToolsVersion = "30.0.3"

  defaultConfig {
    applicationId = "com.sperske.gradlerepro"
    minSdkVersion(23)
    targetSdkVersion(30)
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    getByName("debug") {
      withGroovyBuilder {
        "FirebasePerformance" {
          // Set this flag to "false" to disable @AddTrace annotation processing and
          // automatic HTTP/S network request monitoring
          // for a specific build variant at compile time.
          invokeMethod("setInstrumentationEnabled", false)
        }
      }
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
}

dependencies {
  implementation("androidx.core:core-ktx:1.3.2")
  implementation("androidx.appcompat:appcompat:1.2.0")
  implementation("com.google.android.material:material:1.3.0")

  implementation(platform("com.google.firebase:firebase-bom:26.6.0"))
  implementation("com.google.firebase:firebase-analytics-ktx")
  implementation("com.google.firebase:firebase-perf-ktx")
}