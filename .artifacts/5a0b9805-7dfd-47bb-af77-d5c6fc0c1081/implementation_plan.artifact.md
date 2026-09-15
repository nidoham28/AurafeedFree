# Implementation Plan - Fix and Polish Theme System

The goal is to fix inconsistencies and complete the implementation of the theme system (Color, Type, Theme, ThemeManager) in the Aurafeed project. This includes integrating the `ThemeManager` with the root `AurafeedTheme`, adding missing `Shapes`, and refining typography and color slots.

## User Review Required

> [!NOTE]
> I am integrating `ThemeManager.isDarkTheme()` as the default value for `darkTheme` in `AurafeedTheme`. This ensures that the theme reactiveley updates when the user changes their preference in the app settings.

> [!IMPORTANT]
> I will be creating a new [Shape.kt](file:///D:/Development/Projects/Aurafeed Free/shared/src/commonMain/kotlin/com/aurafeed/free/ui/theme/Shape.kt) file to define the Material 3 shapes, which were previously missing.

## Proposed Changes

### UI Theme Component

#### [NEW] [Shape.kt](file:///D:/Development/Projects/Aurafeed Free/shared/src/commonMain/kotlin/com/aurafeed/free/ui/theme/Shape.kt)
- Define `AppShapes` using Material 3 `Shapes`.

#### [MODIFY] [Color.kt](file:///D:/Development/Projects/Aurafeed Free/shared/src/commonMain/kotlin/com/aurafeed/free/ui/theme/Color.kt)
- Minor cleanup and ensuring all brand colors are consistent.
- Add semantic colors for `success` and `warning` if missing.

#### [MODIFY] [Type.kt](file:///D:/Development/Projects/Aurafeed Free/shared/src/commonMain/kotlin/com/aurafeed/free/ui/theme/Type.kt)
- Refine typography scale for social feed use cases.
- Add a placeholder for custom font integration.

#### [MODIFY] [Theme.kt](file:///D:/Development/Projects/Aurafeed Free/shared/src/commonMain/kotlin/com/aurafeed/free/ui/theme/Theme.kt)
- Integrate `ThemeManager` as the default source for `darkTheme`.
- Add `shapes = AppShapes` to `MaterialTheme`.
- Fix trailing comma warnings and add support for `surfaceTint` in light theme if desired (or keep it clean).

#### [MODIFY] [ThemeManager.kt](file:///D:/Development/Projects/Aurafeed Free/shared/src/commonMain/kotlin/com/aurafeed/free/ui/theme/ThemeManager.kt)
- Add utility properties for checking the current mode.
- Improve the `toggle` logic to be more intuitive.

## Verification Plan

### Automated Tests
- I will run `analyze_file` on all modified files to ensure no new warnings or errors are introduced.

### Manual Verification
- The user can verify that changing the theme in the app settings now correctly updates the UI without requiring a manual `darkTheme` pass to `AurafeedTheme`.
- Verify that components like Cards and Buttons now use the defined `AppShapes`.
