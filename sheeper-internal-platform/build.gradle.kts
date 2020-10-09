plugins {
  `java-platform`
}

configure<JavaPlatformExtension> {
  allowDependencies()
}

dependencies {
  api(platform("org.springframework.boot:spring-boot-dependencies:2.3.4.RELEASE"))

  constraints {
    api(project(":sheeper-api"))
    api(project(":sheeper-db"))
    api(project(":sheeper-server"))

    api("org.projectlombok:lombok:1.18.12")
    api("org.xerial:sqlite-jdbc:3.32.3.2")
  }
}
