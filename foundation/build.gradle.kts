import org.jetbrains.kotlin.config.JvmTarget
import java.util.Properties


plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    id("org.jetbrains.dokka")
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.gyf.foundation"
    compileSdk = 35

    defaultConfig {
        minSdk = 21
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        jvmTarget = JvmTarget.JVM_1_8.description
    }
    buildFeatures {
        aidl = true
        viewBinding = true
    }
}


dependencies {

    // Android
    api(libs.androidx.core.ktx)
    api(libs.androidx.appcompat)
    api(libs.androidx.lifecycle.service)

    // Compose
    api(platform(libs.androidx.compose.bom))
    api(libs.androidx.runtime.android)
    api(libs.androidx.ui)
    api(libs.androidx.ui.graphics)
    api(libs.androidx.ui.tooling.preview)

    // Kotlin
    api(kotlin("reflect"))
    api(libs.kotlinx.coroutines.android)

    // Third-party
    api(libs.material)
    api(libs.moshi.kotlin)
    api(libs.okhttp)
    api(libs.baserecyclerviewadapterhelper4)

    // markdown
    api(libs.markwon.core)
    api(libs.ext.latex)
    api(libs.ext.strikethrough)
    api(libs.ext.tables)
    api(libs.ext.tasklist)
    api(libs.html)
    api(libs.image)
    api(libs.image.glide)
    api(libs.inline.parser)
    api(libs.linkify)
    api(libs.noties.syntax.highlight) {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    api(libs.prism4j) {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    kapt(libs.prism4j.bundler)

    // Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

val localProperties = Properties()
localProperties.load(project.rootProject.file("local.properties").inputStream())

publishing {
    repositories {
        maven {
            name = "foundation"
            isAllowInsecureProtocol = true
            url = uri(
                if (version.toString().endsWith("SNAPSHOT")) {
                    ""
                } else {
                    ""
                }
            )
            credentials {
                username = localProperties.getProperty("repositoryUsername")
                password = localProperties.getProperty("repositoryPassword")
            }
        }
    }
}

mavenPublishing {
    coordinates("com.gyf.foundation", project.name, "1.0.0")
}