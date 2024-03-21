plugins {
    kotlin("plugin.serialization") version "1.9.0"
    kotlin("jvm") version "1.9.23"
    alias(libs.plugins.sonatypeCentralPortalPublisher)
}

group = "world.avionik"
version = "1.0.1"

repositories {
    mavenCentral()

    // papermc repositories
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly(kotlin("stdlib"))

    // avionik-world dependencies
    compileOnly("world.avionik:config-kit:1.0.2")

    // papermc dependencies
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
}

signing {
    useGpgCmd()
    sign(configurations.archives.get())
}

centralPortal {
    username = project.findProperty("sonatypeUsername") as String
    password = project.findProperty("sonatypePassword") as String

    pom {
        name.set("Location Manager")
        description.set("Sets minecraft locations in a file")
        url.set("https://github.com/avionik-world/location-manager")

        developers {
            developer {
                id.set("niklasnieberler")
                email.set("admin@avionik.world")
            }
        }
        licenses {
            license {
                name.set("Apache-2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        scm {
            url.set("https://github.com/avionik-world/location-manager.git")
            connection.set("git:git@github.com:avionik-world/location-manager.git")
        }
    }
}