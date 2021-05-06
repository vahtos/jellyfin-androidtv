buildscript {
	repositories {
		mavenCentral()
		google()
	}

	dependencies {
		val kotlinVersion: String by project
		classpath("com.android.tools.build:gradle:4.2.0")
		classpath(kotlin("gradle-plugin", kotlinVersion))
		classpath(kotlin("serialization", kotlinVersion))
	}
}

allprojects {
	// Dependencies
	repositories {
		mavenCentral()
		google()
		jcenter()
	}
}

plugins {
	id("io.gitlab.arturbosch.detekt").version("1.16.0")
}

// Detekt configuration
subprojects {
	plugins.apply("io.gitlab.arturbosch.detekt")

	detekt {
		buildUponDefaultConfig = true
		ignoreFailures = true
		config = files("$rootDir/detekt.yml")
		basePath = rootDir.absolutePath

		reports {
			sarif.enabled = true
		}
	}
}
