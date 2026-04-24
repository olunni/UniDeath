plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.shadow)
}

group = "dev.oluni"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly(libs.paper.api)
}

kotlin {
    jvmToolchain(11)
}

tasks.shadowJar {
    archiveClassifier.set("")
}