# Implementation Plan - Laboratory Activity 7: Navigation Compose — Building a Type-Safe App

Build a two-screen Android app using Jetpack Compose and Navigation Compose, utilizing type-safe routes with Kotlin serialization.

## User Review Required

> [!IMPORTANT]
> I will be adding the Kotlin Serialization plugin and Navigation Compose dependencies. I will use the project's Kotlin version (`2.2.10`) for the serialization plugin as instructed (matching the Kotlin version).

## Proposed Changes

### Build Configuration

#### [MODIFY] [libs.versions.toml](file:///Users/enrique/StudioProjects/edp-android-colab/gradle/libs.versions.toml)
- Add `kotlinxSerialization` version.
- Add `navigationCompose` version.
- Add `kotlinx-serialization-json` library.
- Add `androidx-navigation-compose` library.
- Add `kotlin-serialization` plugin.

#### [MODIFY] [build.gradle.kts (App Module)](file:///Users/enrique/StudioProjects/edp-android-colab/app/build.gradle.kts)
- Apply `kotlin-serialization` plugin.
- Add `androidx-navigation-compose` and `kotlinx-serialization-json` dependencies.

### Application Logic

#### [NEW] [Routes.kt](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/Routes.kt)
- Define `Home` object and `Greeting` data class with `@Serializable`.

#### [NEW] [Screens.kt](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/Screens.kt)
- Implement `HomeScreen` with `OutlinedTextField` and "Show Greeting" button.
- Implement `GreetingScreen` to display the welcome message.

#### [MODIFY] [MainActivity.kt](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/MainActivity.kt)
- Set up `NavController` and `NavHost`.
- Register `Home` and `Greeting` destinations.
- Use `navController.navigate` and `backStackEntry.toRoute()` for type-safe navigation.

## Verification Plan

### Automated Tests
- Run `./gradlew assembleDebug` to ensure successful compilation and dependency resolution.

### Manual Verification
1. Launch the app.
2. Enter a name in the `HomeScreen`.
3. Tap "Show Greeting".
4. Verify the `GreetingScreen` displays "Hello, [Name]! Welcome to Jetpack Navigation.".
5. Press the Back button and verify return to `HomeScreen`.
