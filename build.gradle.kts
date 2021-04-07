plugins {
  id("org.springframework.boot") version "2.4.4"
}

allprojects {
  repositories {
    mavenCentral()
  }
}

subprojects {
  group = "com.jb4j.sheeper"
  version = "0.1.0-SNAPSHOT"

  plugins.withType<JavaPlugin> {
    configure<JavaPluginExtension> {
      sourceCompatibility = JavaVersion.VERSION_16
      targetCompatibility = JavaVersion.VERSION_16
      withSourcesJar()
    }
    tasks.named<Test>("test") {
      useJUnitPlatform()
    }
    dependencies {
      "implementation"(platform(project(":sheeper-internal-platform")))
    }
  }
}
