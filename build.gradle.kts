import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.5"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	id("org.flywaydb.flyway") version "9.5.1"
}

group = "com.guacamole"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

val springBootVersion = "2.7.5"
val flywayVersion = "9.4.0"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web:$springBootVersion")
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc:$springBootVersion")

	runtimeOnly("com.mysql:mysql-connector-j:8.0.31")
	implementation("org.flywaydb:flyway-core:$flywayVersion")
	implementation("org.flywaydb:flyway-mysql:$flywayVersion")

	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.4")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:$springBootVersion")
	testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVersion")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

flyway {

}