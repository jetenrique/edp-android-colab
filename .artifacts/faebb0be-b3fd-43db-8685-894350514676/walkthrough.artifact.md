# Walkthrough - Lab Activity 12: LiceoFieldKit

I have successfully implemented the **LiceoFieldKit** application, demonstrating the use of Hardware APIs (Accelerometer, CameraX, Location) and robust runtime permission handling.

## Changes Made

### Project Infrastructure
- **Updated Namespace**: Refactored the project to use `edu.liceo.fieldkit` as the root package.
- **Dependency Integration**: Added CameraX (`camera-camera2`, `camera-lifecycle`, `camera-compose`), Google Play Services Location, and Lifecycle Runtime Compose.
- **Manifest Configuration**: Declared all necessary permissions (`CAMERA`, `ACCESS_FINE_LOCATION`, `ACCESS_COARSE_LOCATION`, `VIBRATE`) and hardware features in `AndroidManifest.xml`.

### Permission System
- **[PermissionHelper.kt](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/edu/liceo/fieldkit/permissions/PermissionHelper.kt)**: Implemented a lifecycle-aware state manager for permissions that correctly handles "Granted", "Needs Rationale", "Denied/Blocked", and "Not Asked" states.
- **[PermissionGate.kt](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/edu/liceo/fieldkit/ui/PermissionGate.kt)**: Created a reusable UI wrapper that adapts to the permission state, providing clear instructions and buttons for each scenario.

### Hardware Features
- **Accelerometer (Level Check)**:
    - `rememberAccelerometer()` provides real-time sensor data with automatic registration/unregistration.
    - `LevelCard` visualizes the data, showing "LEVEL ✓" when the device is flat (tolerance ±0.5).
- **CameraX (Field Photo)**:
    - `CameraPreview` binds the CameraX stream to the Compose lifecycle.
    - `takePhoto()` captures images and saves them to the app-specific cache directory.
    - `CameraCard` provides the viewfinder, shutter button, and a dynamic thumbnail preview.
- **GPS (Where am I?)**:
    - `currentLocation()` fetches precise coordinates using the Fused Location Provider.
    - `LocationCard` handles both Precise and Approximate location permissions.

### Bonus Features
- **Shake to Capture**: Automatically triggers the camera when a device shake is detected (with a 1.5s cooldown).
- **Haptic Feedback**: The device vibrates (buzzes) when a photo is taken via shake.
- **Flashlight Toggle**: Integrated torch control directly into the camera viewfinder interface.

## Verification Results

### Automated Tests
- **Build Success**: The project compiles successfully on the `lab-activity-11` branch.

### Manual Verification
- **Permission Flow**: Verified that the app correctly shows rationales and leads the user to Settings when a permission is blocked.
- **Hardware Integration**: The Level Check reacts to orientation changes, and the Camera Preview is active once granted.

> [!IMPORTANT]
> The app is built on the `lab-activity-11` branch as per your request. Please ensure you are on this branch when reviewing the code.

render_diffs(file:///Users/enrique/StudioProjects/edp-android-colab/app/build.gradle.kts)
render_diffs(file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/edu/liceo/fieldkit/permissions/PermissionHelper.kt)
render_diffs(file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/edu/liceo/fieldkit/hardware/Accelerometer.kt)
render_diffs(file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/edu/liceo/fieldkit/hardware/CameraPreview.kt)
render_diffs(file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/edu/liceo/fieldkit/hardware/Location.kt)
