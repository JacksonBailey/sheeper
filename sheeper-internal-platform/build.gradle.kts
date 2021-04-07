plugins {
  `java-platform`
}

configure<JavaPlatformExtension> {
  allowDependencies()
}

dependencies {
  api(platform("org.springframework.boot:spring-boot-dependencies:2.4.4"))
  api(platform("com.fasterxml.jackson:jackson-bom:2.12.2"))

  constraints {
    api(project(":sheeper-api"))
    api(project(":sheeper-server"))
  }
}
