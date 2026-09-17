# Implementation Plan - Lab Activity 12: LiceoFieldKit

Develop LiceoFieldKit, a campus field-report app that utilizes Hardware APIs (Accelerometer, CameraX, Location) and manages runtime permissions.

## User Review Required

> [!IMPORTANT]
> - The project namespace will be updated to `edu.liceo.fieldkit` as per requirements.
> - New dependencies for CameraX, Location Services, and Lifecycle will be added.
> - The app will be implemented on the `lab-activity-11` branch as requested by the user, despite the document mentioning `lab-activity-12`.

## Proposed Changes

### Build Configuration & Manifest

#### [MODIFY] [build.gradle.kts (App)](file:///Users/enrique/StudioProjects/edp-android-colab/app/build.gradle.kts)
- Update `namespace` to `edu.liceo.fieldkit`.
- Add GIVEN dependencies:
  - `androidx.camera:camera-camera2:1.6.1`
  - `androidx.camera:camera-lifecycle:1.6.1`
  - `androidx.camera:camera-compose:1.6.1`
  - `com.google.android.gms:play-services-location:21.4.0`
  - `androidx.lifecycle:lifecycle-runtime-compose:2.10.0`

#### [MODIFY] [AndroidManifest.xml](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/AndroidManifest.xml)
- Add permissions: `CAMERA`, `ACCESS_FINE_LOCATION`, `ACCESS_COARSE_LOCATION`, `VIBRATE`.
- Add feature: `android.hardware.camera` (required=false).

### Package: edu.liceo.fieldkit.permissions

#### [NEW] [PermissionHelper.kt](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/edu/liceo/fieldkit/permissions/PermissionHelper.kt)
- Implement `PermStatus` enum and `PermissionState` class.
- Implement `permStatus()` to check permission state (Granted, NeedsRationale, Denied, NotAsked).
- Implement `rememberPermission()` using `rememberLauncherForActivityResult` and `LifecycleResumeEffect`.

### Package: edu.liceo.fieldkit.hardware

#### [NEW] [Accelerometer.kt](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/edu/liceo/fieldkit/hardware/Accelerometer.kt)
- Implement `rememberAccelerometer()` to read sensor data safely with lifecycle awareness.

#### [NEW] [CameraPreview.kt](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/edu/liceo/fieldkit/hardware/CameraPreview.kt)
- Implement `CameraPreview` using CameraX and `CameraXViewfinder`.

#### [NEW] [Photo.kt](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/edu/liceo/fieldkit/hardware/Photo.kt)
- Implement `takePhoto()` to save images to the app's cache directory.

#### [NEW] [Location.kt](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/edu/liceo/fieldkit/hardware/Location.kt)
- Implement `currentLocation()` using Fused Location Provider.

#### [NEW] [Bonus.kt](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/edu/liceo/fieldkit/hardware/Bonus.kt)
- Implement `isShake()` and `buzz()` for extra credit features.

### Package: edu.liceo.fieldkit.ui

#### [NEW] [PermissionGate.kt](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/edu/liceo/fieldkit/ui/PermissionGate.kt)
- Implement a reusable wrapper to handle different permission states (Granted, NotAsked, Rationale, Denied).

#### [NEW] [LevelCard.kt](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/edu/liceo/fieldkit/ui/LevelCard.kt)
- Implement the UI for the accelerometer-based level check.

#### [NEW] [CameraCard.kt](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/edu/liceo/fieldkit/ui/CameraCard.kt)
- Implement the UI for CameraX preview and capture.
- Include Bonus: Shake-to-capture and Torch toggle.

#### [NEW] [LocationCard.kt](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/edu/liceo/fieldkit/ui/LocationCard.kt)
- Implement the UI for tagging current location with permission handling.

### Main Entry Point

#### [MODIFY] [MainActivity.kt](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/edu/liceo/fieldkit/MainActivity.kt)
- Replace with the GIVEN `MainActivity` structure.

## Verification Plan

### Automated Tests
- Run Gradle sync and build to ensure all dependencies are correct.

### Manual Verification
1. Verify Accelerometer: Numbers change and "LEVEL ✓" appears when the device is flat.
2. Verify Camera Permissions: Test all states (Not asked, Rationale, Blocked, Granted).
3. Verify Photo Capture: Save a photo and check the thumbnail.
4. Verify Location: Tag location and check coordinates.
5. Verify Bonus: Shake the device to take a photo; toggle the torch.
