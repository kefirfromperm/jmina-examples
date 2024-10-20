plugins {
    id("java")
}

group = "dev.jmina"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-api:2.0.13")
    implementation("org.slf4j:slf4j-simple:2.0.13")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // Dependency on JMina
    testImplementation("dev.jmina:jmina:0.1.3")
}

tasks.test {
    useJUnitPlatform()

    // JMina configuration
    systemProperty("slf4j.provider", "dev.jmina.log.MinaServiceProvider")
    systemProperty("jmina.delegate.provider", "org.slf4j.simple.SimpleServiceProvider")
    systemProperty("jmina.context.global", "false")
}