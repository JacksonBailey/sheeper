plugins {
  id("org.springframework.boot") version "2.3.4.RELEASE"
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
      sourceCompatibility = JavaVersion.VERSION_14
      targetCompatibility = JavaVersion.VERSION_14
      withSourcesJar()
    }
    tasks.named<Test>("test") {
      useJUnitPlatform()
    }
    dependencies {
      "implementation"(platform(project(":sheeper-internal-platform")))
      "annotationProcessor"(platform(project(":sheeper-internal-platform")))
      "testAnnotationProcessor"(platform(project(":sheeper-internal-platform")))

      "compileOnly"("org.projectlombok:lombok")
      "annotationProcessor"("org.projectlombok:lombok")
      "testCompileOnly"("org.projectlombok:lombok")
      "testAnnotationProcessor"("org.projectlombok:lombok")
    }
  }
}
