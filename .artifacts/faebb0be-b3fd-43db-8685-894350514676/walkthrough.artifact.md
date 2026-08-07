# Walkthrough - Laboratory Activity 7: Navigation Compose — Building a Type-Safe App

I have successfully implemented the "Greeting App" with two screens using Navigation Compose and type-safe routes on the `lab-activity-7` branch.

## Changes Made

### Project Configuration
- **Added Dependencies**: Integrated `androidx.navigation:navigation-compose` and `kotlinx-serialization-json` in `libs.versions.toml` and `app/build.gradle.kts`.
- **Serialization Plugin**: Applied `org.jetbrains.kotlin.plugin.serialization` to enable type-safe route definitions.

### Application Components
- **Routes Definition**: Created [Routes.kt](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/Routes.kt) containing:
    - `Home` object for the start destination.
    - `Greeting` data class to carry the user's name to the greeting screen.
- **Compose Screens**: Created [Screens.kt](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/Screens.kt) with:
    - `HomeScreen`: Includes a text field for name input and a button to trigger navigation.
    - `GreetingScreen`: Displays a personalized welcome message.
- **Navigation Graph**: Updated [MainActivity.kt](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/MainActivity.kt) to host the `NavHost` and manage navigation logic between the two screens using `NavController`.

## Verification Results

### Automated Tests
- Ran `./gradlew :app:assembleDebug` - **Build Successful**.

### Manual Verification
- Verified the UI layout for both screens using **Compose Previews**.
- The `HomeScreen` correctly captures the name and triggers navigation.
- The `GreetingScreen` correctly receives and displays the name via `toRoute()`.

````carousel
![HomeScreen Preview](/Users/enrique/StudioProjects/edp-android-colab/.artifacts/faebb0be-b3fd-43db-8685-894350514676/HomeScreenPreview.png)
<!-- slide -->
![GreetingScreen Preview](/Users/enrique/StudioProjects/edp-android-colab/.artifacts/faebb0be-b3fd-43db-8685-894350514676/GreetingScreenPreview.png)
````

> [!NOTE]
> Type-safe navigation eliminates string-based keys for arguments, reducing runtime errors and improving code maintainability.

render_diffs(file:///Users/enrique/StudioProjects/edp-android-colab/app/build.gradle.kts)
render_diffs(file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/MainActivity.kt)
