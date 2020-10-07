rootProject.name = "sheeper"

include("sheeper-api")
include("sheeper-internal-platform")
include("sheeper-server")

pluginManagement {
  plugins {
    id("org.springframework.boot") version "2.3.4.RELEASE"
  }
}
