plugins {
    alias(libs.plugins.kotlin.jvm)
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