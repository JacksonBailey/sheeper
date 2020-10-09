plugins {
  java
  id("org.flywaydb.flyway")
  id("org.springframework.boot")
}

dependencies {
  implementation(project(":sheeper-api"))
  implementation(project(":sheeper-db"))
  implementation("org.springframework.boot:spring-boot-starter-jooq")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.xerial:sqlite-jdbc")

  testImplementation("org.xerial:sqlite-jdbc")
  testImplementation("org.springframework.boot:spring-boot-starter-test") {
    exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
  }
}

tasks.withType<org.flywaydb.gradle.task.AbstractFlywayTask> {
  doFirst {
    mkdir("${project.buildDir}/db")
  }
  outputs.apply {
    cacheIf { true }
    dir("${project.buildDir}/db")
  }
}

flyway {
  url = "jdbc:sqlite:${project.buildDir}/db/sheeper.db"
  locations = arrayOf("filesystem:" + project(":sheeper-db").buildDir.path + "/resources/main/db/migration")
}

tasks.named<Test>("test") {
  dependsOn(tasks.withType<org.flywaydb.gradle.task.FlywayMigrateTask>())
}
