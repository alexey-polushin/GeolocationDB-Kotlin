plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
    id("org.jreleaser")
}

android {
    namespace = "me.lekseg.iplocation"
    compileSdk = 35

    defaultConfig {
        minSdk = 21
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        buildConfig = true
    }
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

version = "1.0.0"

publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "me.lekseg"
            artifactId = "iplocation"

            pom {
                name.set("iplocation")
                description.set("description")
                url.set("https://github.com/alexey-polushin/iplocation")
                issueManagement {
                    url.set("https://github.com/alexey-polushin/iplocation/issues")
                }

                scm {
                    url.set("https://github.com/alexey-polushin/iplocation")
                    connection.set("scm:git://github.com/alexey-polushin/iplocation.git")
                    developerConnection.set("scm:git://github.com/alexey-polushin/iplocation.git")
                }

                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://mit-license.org")
                        distribution.set("repo")
                    }
                }

                developers {
                    developer {
                        id.set("Lekseg")
                        name.set("Alexey Polushin")
                        email.set("leksi4ek@gmail.com")
                    }
                }

                afterEvaluate {
                    from(components["release"])
                }
            }
        }
    }
    repositories {
        maven {
            setUrl(layout.buildDirectory.dir("staging-deploy"))
        }
    }
}

jreleaser {
    release {
        github {
            skipRelease = true
            skipTag = true
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.serialization.kotlinx.json)
}