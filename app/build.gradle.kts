plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation(libs.guava)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

application {
    // Define the main class for the application.
    mainClass = "org.example.App"
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

// example api task
tasks.register<Copy>("copyTask") {
   from("src")
   into("src-copy")
}

tasks.register("hello") {
    doLast {
        println("Hello!")
    }
}

tasks.register("greet") {
    doLast {
        println("How are you?")
    }
    dependsOn("hello")
}

