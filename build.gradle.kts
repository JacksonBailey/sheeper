import org.springframework.boot.gradle.plugin.SpringBootPlugin

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
      withJavadocJar()
      withSourcesJar()
    }
    tasks.named<Test>("test") {
      useJUnitPlatform()
    }
    dependencies {
      "implementation"(platform(SpringBootPlugin.BOM_COORDINATES))
      "compileOnly"("org.projectlombok:lombok:1.18.12")
      "annotationProcessor"("org.projectlombok:lombok:1.18.12")
      "testCompileOnly"("org.projectlombok:lombok:1.18.12")
      "testAnnotationProcessor"("org.projectlombok:lombok:1.18.12")
    }
  }
}
