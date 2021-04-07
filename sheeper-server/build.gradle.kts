plugins {
  java
  id("org.springframework.boot")
}

dependencies {
  implementation(project(":sheeper-api"))
  implementation("org.springframework.boot:spring-boot-starter-web")

  testImplementation("org.springframework.boot:spring-boot-starter-test") {
    exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
  }
}
