[![GitHub Actions](https://img.shields.io/github/workflow/status/reimersoftware/jsonl-serialization/CI?style=flat-square)](https://github.com/reimersoftware/jsonl-serialization/actions?query=workflow%3A"CI")
[![JitPack](https://img.shields.io/jitpack/v/github/reimersoftware/jsonl-serialization?style=flat-square)](https://jitpack.io/#dev.reimer/jsonl-serialization)

# 🗜️ jsonl-serialization<sup>[α](#status-α)</sup>

Kotlin serialization for the [JSON Lines](http://jsonlines.org/) format.

## Gradle Dependency

This library is available on [**jitpack.io**](https://jitpack.io/#dev.reimer/jsonl-serialization).  
Add this in your `build.gradle.kts` or `build.gradle` file:

<details open><summary>Kotlin</summary>

```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("dev.reimer:jsonl-serialization:<version>")
}
```

</details>

<details><summary>Groovy</summary>

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'dev.reimer:jsonl-serialization:<version>'
}
```

</details>

## Status α

⚠️ _Warning:_ This project is in an experimental alpha stage:
- The API may be changed at any time without further notice.
- Development still happens on `master`.
- Pull Requests are highly appreciated!