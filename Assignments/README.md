# How to implement Java programming

## Java Installation

The Java version used in this environment is between Java 17 - 20.
However, I would recommend using Java 17 since it is a Long-Term-Support (LTS) version, please see the reference [here](https://www.oracle.com/java/technologies/java-se-support-roadmap.html).

Here is the [link](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) to download Java 17.

## Gradle Installation

Gradle is a build automation tool used primarily for Java-based projects.

To install Gradle, it is required to have [(Software Development Kit Manager (SDKMAN!)](https://sdkman.io/), a tool for managing parallel versions of multiple Software Development Kits (SDKs).

1. Installing SDKMAN!
    
    `curl -s "https://get.sdkman.io" | bash`

2. Installing Gradle

    `sdk install gradle 7.3`

    In case of using other Java version, please see the compatibility matrix between Java and Gradle version [here](https://docs.gradle.org/current/userguide/compatibility.html).


Please find the [Gradle 7.3 user manual](https://docs.gradle.org/7.3.3/userguide/userguide.html). Also, find the example of building a Gradle project [here](https://docs.gradle.org/current/samples/sample_building_java_applications.html).

Example code:

1. Running Gradle: `./gradlew run`
2. Building Gradle: `./gradlew build`
