plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	kotlin("plugin.allopen") version "1.9.25"
	kotlin("plugin.serialization") version "1.9.25"

	id("org.springframework.boot") version "3.4.0"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.kotlin"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-logging")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")

	implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")

    implementation("mysql:mysql-connector-java:8.0.32")

	implementation("org.modelmapper:modelmapper:3.1.0")

	testImplementation("org.springframework.boot:spring-boot-starter-test")

	runtimeOnly("org.springframework.boot:spring-boot-devtools")
}

tasks.withType<Test> {
    useJUnitPlatform() // Enables JUnit 5 for testing
}

tasks.compileKotlin {
    kotlinOptions {
        jvmTarget = "17" // Set the JVM target version to match your JDK
    }
}

tasks.compileTestKotlin {
    kotlinOptions {
        jvmTarget = "17"
    }
}