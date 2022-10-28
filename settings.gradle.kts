pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }

    plugins {
        val kotlinVersion = extra["kotlin.version"] as String
        kotlin("multiplatform").version(kotlinVersion)
        kotlin("android").version(kotlinVersion)
        kotlin("plugin.parcelize").version(kotlinVersion)

        val agpVersion = extra["agp.version"] as String
        id("com.android.application").version(agpVersion)

        val composeVersion = extra["compose.version"] as String
        id("org.jetbrains.compose").version(composeVersion)

        val sqldelightVersion = extra["sqldelight.version"] as String
        id("com.squareup.sqldelight").version(sqldelightVersion)
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

rootProject.name = "working-time"
include(":app")