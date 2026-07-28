# Walkthrough - Profile Screen Exam Implementation

I have completed the "Prelim Hands-on Exam" by building the Profile screen according to the provided requirements and wireframe.

## Changes Made

### 1. Theme Configuration
- **Color.kt**: Defined the "Liceo Maroon" color palette (`Maroon`, `LightMaroon`, `PageBackground`).
- **Theme.kt**: Created `ProfileCardLabTheme` which applies the Maroon color scheme to both Light and Dark modes.

### 2. Profile Screen Implementation
- **ProfileScreen.kt**: Created a new file in the `com.liceo.prelim.profilecard` package.
    - **Centered Layout**: Root `Column` uses `Arrangement.Center` and `Alignment.CenterHorizontally`.
    - **Circular Avatar**: 120.dp size, clipped to `CircleShape`, with a `primary` background and `onPrimary` border.
    - **Headers**: Styled Full Name (`headlineSmall`) and Course/Section (`titleMedium`).
    - **Info Card**: Material 3 `Card` grouping all personal information.
    - **Reusable InfoRow**: A DRY component used for the 5 required fields: Full Name, Course, Section, Mobile Number, and Email Address.

### 3. Verification
- **Previews**: Implemented "Profile — Light" and "Profile — Dark" previews.
- **Build**: The project compiles successfully.

## Previews

````carousel
![Profile — Light](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/com/liceo/prelim/profilecard/ProfileScreen.kt_ProfileLightPreview.png)
<!-- slide -->
![Profile — Dark](file:///Users/enrique/StudioProjects/edp-android-colab/app/src/main/java/com/liceo/prelim/profilecard/ProfileScreen.kt_ProfileDarkPreview.png)
````

> [!TIP]
> All colors and typography styles are read directly from `MaterialTheme`, ensuring that dark mode support is seamless and consistent with the Liceo Maroon brand.
