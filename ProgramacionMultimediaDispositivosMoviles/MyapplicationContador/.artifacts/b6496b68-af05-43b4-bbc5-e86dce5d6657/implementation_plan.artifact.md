# Fix layout and ID references in MainActivity

The user is experiencing issues where `activity_main.xml` and its component IDs are not recognized in `MainActivity.kt`.

## User Review Required

> [!IMPORTANT]
> The primary issue is an incorrect import of `android.R`, which points to Android's system resources instead of your project's resources. Additionally, the IDs used in `MainActivity.kt` do not match the IDs defined in `activity_main.xml`.

## Proposed Changes

### [app]

#### [MODIFY] [MainActivity.kt](file:///C:/Users/dario/Desktop/2-FPdam/ProgramacionMultimediaDispositivosMoviles/MyapplicationContador/app/src/main/java/com/first/myapplicationcontador1/MainActivity.kt)
- Remove `import android.R`.
- Update `textoContador` and `btnContador` variable names or their `findViewById` targets to match `activity_main.xml`.
- In `activity_main.xml`, the IDs are `TextDisplayContador` and `ButtomSumarContador`.

## Verification Plan

### Automated Tests
- I will run `analyze_file` on `MainActivity.kt` after the changes to ensure all references are resolved.

### Manual Verification
- The code should compile without the "Unresolved reference" errors.
