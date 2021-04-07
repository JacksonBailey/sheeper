rootProject.name = "sheeper"

include("sheeper-api")
include("sheeper-db")
include("sheeper-internal-platform")
include("sheeper-server")

pluginManagement {
  plugins {
    id("nu.studer.jooq") version "5.1.1"
    id("org.flywaydb.flyway") version "7.0.2"
    id("org.springframework.boot") version "2.4.4"
  }
}
