import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig
import org.gradle.api.JavaVersion

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinxSerialization)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_1_8)
        }
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        outputModuleName.set("composeApp")
        browser {
            val rootDirPath = project.rootDir.path
            val projectDirPath = project.projectDir.path
            commonWebpackConfig {
                outputFileName = "composeApp.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(rootDirPath)
                        add(projectDirPath)
                    }
                }
            }
        }
        binaries.executable()
    }

//    js {
//        browser {}
//        binaries.executable()
//    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.ui)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)
                implementation(libs.androidx.lifecycle.viewmodel)
                implementation(libs.androidx.lifecycle.runtimeCompose)

                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kotlinx.datetime)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.activity.compose)
//                implementation(libs.androidx.compose.ui.tooling.preview)
                implementation(compose.preview)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.browser)
                implementation(libs.kotlin.test)
            }
        }
    }
}

android {
    namespace = "com.kwanhee.portfolio" // 실제 프로젝트 패키지 이름으로 변경
    compileSdk = 35 // 최신 SDK로 설정

    defaultConfig {
        minSdk = 24 // 최소 지원 SDK
        targetSdk = 35
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}