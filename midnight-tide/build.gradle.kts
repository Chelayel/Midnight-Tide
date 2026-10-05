plugins {
    id("java")
    id("org.jetbrains.intellij.platform") version "2.17.0"
}

group = "com.midnight.theme"
// A tag builds and publishes at the tag's version (release.yml); gradle.properties
// only labels local builds and builds off main.
version = (findProperty("pluginVersion") as String?) ?: "0.0.0"

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        // IntelliJ IDEA 2025.3, the first build with the Islands Dark parent theme.
        // Themes are compatible across every JetBrains IDE on the same platform build.
        intellijIdea("2025.3")
    }
}

intellijPlatform {
    instrumentCode = false
    buildSearchableOptions = false
    pluginConfiguration {
        version = project.version.toString()
        ideaVersion {
            // Not lower: the theme's parent, Islands Dark, first shipped in 2025.3.
            sinceBuild = "253"
            untilBuild = provider { null }   // forward-compatible
        }
    }
    // `./gradlew publishPlugin` with JETBRAINS_MARKETPLACE_TOKEN set (a token from
    // https://plugins.jetbrains.com/author/me/tokens).
    publishing {
        token = providers.environmentVariable("JETBRAINS_MARKETPLACE_TOKEN")
    }
    pluginVerification {
        ides {
            // JetBrains' pick of IDE builds for the declared since-build range.
            recommended()
        }
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}
