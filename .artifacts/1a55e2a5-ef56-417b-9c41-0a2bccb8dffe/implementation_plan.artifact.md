# Implementation Plan - Profile Screen Exam

This plan follows the "Prelim Hands-on Exam" requirements to build a Profile screen using Jetpack Compose and the "Liceo Maroon" theme.

## User Review Required

> [!IMPORTANT]
> The requested file `ProfileScreen.kt` and package `com.liceo.prelim.profilecard` do not currently exist in the project. I will create them to match the exam instructions.
>
> I will also update the existing theme in `ui/theme/` to reflect the "Liceo Maroon" colors described in the prompt, as the current theme appears to be the default one.

## Proposed Changes

### UI Theme

#### [MODIFY] [Color.kt](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/ui/theme/Color.kt)
- Define "Liceo Maroon" colors: `Maroon`, `LightMaroon`, etc.

#### [MODIFY] [Theme.kt](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/ui/theme/Theme.kt)
- Rename the theme to `ProfileCardLabTheme`.
- Update the color schemes to use the Maroon palette.

### Profile Screen Component

#### [NEW] [ProfileScreen.kt](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/com/liceo/prelim/profilecard/ProfileScreen.kt)
- Implement `ProfileScreen` with:
    - Centered root `Column`.
    - Circular avatar (120.dp) with initials.
    - Name and Course/Section subtitle.
    - Material 3 `Card` containing 5 `InfoRow` items.
    - Reusable `InfoRow` component.
- Order of fields: Full Name, Course, Section, Mobile Number, Email Address.
- Implement Light and Dark mode previews.

### Entry Point

#### [MODIFY] [MainActivity.kt](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/MainActivity.kt)
- Update to use `ProfileCardLabTheme` and the new `ProfileScreen`.

## Verification Plan

### Automated Tests
- Run `gradle_build("app:assembleDebug")` to ensure compilation.
- Run `analyze_file` on the new `ProfileScreen.kt`.

### Manual Verification
- Use `render_compose_preview` to verify the "Profile — Light" and "Profile — Dark" previews.
- Ensure the layout matches the wireframe (Centered, Circular Avatar, Card with 5 rows).
