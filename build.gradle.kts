import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version ("7.0.0")
}

val pluginName = "votecheker"

group = "me.joesvart.$pluginName"
version = "1.0-SNAPSHOT"

dependencies {
    compileOnly("org.spigotmc:spigot:1.8.8-R0.1-SNAPSHOT")

    implementation("me.yushust.inject:core:0.4.5-SNAPSHOT")
}

repositories {
    mavenLocal()
    mavenCentral()

    maven("https://jitpack.io")

    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://repo.codemc.io/repository/nms/")
    maven("https://repo.unnamed.team/repository/unnamed-snapshots/")
    maven("https://repo.unnamed.team/repository/unnamed-releases")
    maven("https://repo.unnamed.team/repository/unnamed-public/")
}

tasks {
    processResources {
        filesMatching("**/*.yml") {
            filter<org.apache.tools.ant.filters.ReplaceTokens>(
                "tokens" to mapOf("version" to project.version)
            )
        }
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<ShadowJar> {
    archiveFileName.set("$pluginName-$version.jar")
}
