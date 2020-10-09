plugins {
  java
  id("nu.studer.jooq")
  id("org.flywaydb.flyway")
}

dependencies {
  implementation("org.jooq:jooq")
  implementation("org.xerial:sqlite-jdbc")
  jooqGenerator("org.xerial:sqlite-jdbc:3.32.3.2")
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

tasks.withType<nu.studer.gradle.jooq.JooqGenerate> {
  dependsOn(tasks.withType<org.flywaydb.gradle.task.FlywayMigrateTask>())
  allInputsDeclared.set(true)
  outputs.cacheIf { true }
}

flyway {
  url = "jdbc:sqlite:${project.buildDir}/db/sheeper.db"
}

jooq {
  configurations {
    create("main") {
      jooqConfiguration.apply {
        logging = org.jooq.meta.jaxb.Logging.WARN
        jdbc.apply {
          driver = "org.sqlite.JDBC"
          url = "jdbc:sqlite:${project.buildDir}/db/sheeper.db"
        }
        generator.apply {
          name = "org.jooq.codegen.JavaGenerator"
          database.apply {
            name = "org.jooq.meta.sqlite.SQLiteDatabase"
          }
          generate.apply {
            isDeprecated = false
            isRecords = true
            isImmutablePojos = true
            isFluentSetters = true
          }
          target.apply {
            packageName = "com.jb4j.sheeper.db.jooq"
          }
        }
      }
    }
  }
}
