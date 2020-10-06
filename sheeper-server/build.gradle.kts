plugins {
  java
  id("org.springframework.boot")
}

dependencies {
  implementation(project(":sheeper-api"))
  implementation("com.fasterxml.jackson.core:jackson-databind")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework:spring-web")
  testImplementation("org.junit.jupiter:junit-jupiter")
  testImplementation("org.springframework.boot:spring-boot-starter-test") {
    exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
  }
}
