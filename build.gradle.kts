import com.vanniktech.maven.publish.MavenPublishBaseExtension
import org.jetbrains.dokka.gradle.DokkaTask

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.jetbrains.dokka) apply false
    alias(libs.plugins.vanniktech.publish) apply false
}

subprojects {
    val project = this@subprojects
    if (project.name == "app") return@subprojects
    apply(plugin = "org.jetbrains.dokka")

    tasks.withType<DokkaTask>().configureEach {
        val newName = name.lowercase().replace("dokka", "")
        outputDirectory.set(layout.projectDirectory.dir("docs/$newName"))
        dokkaSourceSets {
            configureEach {
                includeNonPublic.set(false) // 是否包含非公共 API
                skipEmptyPackages.set(true) // 跳过空包
                reportUndocumented.set(false) // 报告未文档化的内容
                suppressInheritedMembers.set(true) // 抑制继承的成员
                jdkVersion.set(8) // JDK 版本
            }
        }
    }
}

subprojects {
    val project = this@subprojects
    if (project.name == "app") return@subprojects
    if (plugins.hasPlugin("com.android.application")) {
        // 如果是 application 模块，直接跳过
        return@subprojects
    }
    apply(plugin = "com.vanniktech.maven.publish")

    plugins.withId("com.vanniktech.maven.publish") {
        configure<MavenPublishBaseExtension> {

            pom {
                name.set(project.name)
                description.set("Foundation is a collection of foundational libraries.")
                inceptionYear.set("2024")
                url.set("http://10.10.130.200:8090/cockpit/x9sp_platform/demo_app/Foundation")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("ifange")
                        name.set("Ifan.Ge")
                        url.set("repo")
                    }
                }
                scm {
                    url.set("http://10.10.130.200:8090/cockpit/x9sp_platform/demo_app/Foundation")
                    connection.set("scm:git:ssh://git@10.10.130.200:10022/cockpit/x9sp_platform/demo_app/Foundation.git")
                    developerConnection.set("scm:git:ssh://git@10.10.130.200:10022/cockpit/x9sp_platform/demo_app/Foundation.git")
                }
            }
        }
    }
}
