# Ranger Android

Minimal Jetpack Compose app matching the Ranger Android welcome screen.

## Run locally

1. Open this folder in **Android Studio** (Ladybug or newer recommended).
2. Let Gradle sync, then run on an emulator or device (**Run ▶**).

Or from the command line (with `ANDROID_HOME` set):

```bash
./gradlew :app:assembleDebug
```

## What you will see

- Pale lavender background (`#FBF8FF`)
- Centered headline: “Hello from Ranger on” / “Android”
- Tagline: `androidtest · kotlin · compose`

Main UI lives in `app/src/main/java/com/ranger/androidtest/MainActivity.kt`.
