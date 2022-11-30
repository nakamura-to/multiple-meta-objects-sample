plugins {
    idea
    kotlin("jvm") version "1.7.20"
    id("com.google.devtools.ksp") version "1.7.20-1.0.6"
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "idea")
    apply(plugin = "com.google.devtools.ksp")
    apply(plugin = "org.jetbrains.kotlin.jvm")

    dependencies {
        val komapperVersion = "1.4.0"
        platform("org.komapper:komapper-platform:$komapperVersion").let {
            implementation(it)
            ksp(it)
        }
        implementation("org.komapper:komapper-starter-jdbc")
        implementation("org.komapper:komapper-dialect-h2-jdbc")
        ksp("org.komapper:komapper-processor")
    }

    tasks {
        withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
            kotlinOptions.jvmTarget = "11"
        }
    }

    idea {
        module {
            sourceDirs = sourceDirs + file("build/generated/ksp/main/kotlin")
            testSourceDirs = testSourceDirs + file("build/generated/ksp/test/kotlin")
            generatedSourceDirs = generatedSourceDirs + file("build/generated/ksp/main/kotlin") + file("build/generated/ksp/test/kotlin")
        }
    }
}