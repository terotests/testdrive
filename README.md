# Android Hello World (Ranger)

Minimal [Ranger](https://terotests.github.io/Ranger/) Android app generated from [RangerStarter](https://github.com/terotests/RangerStarter).

The greeting lives in Ranger (`src/Shared.rgr`), compiles to Kotlin, and is shown by the Jetpack Compose host in `platforms/android/`.

## Commands

```bash
npm install
npm run check          # type-check Shared.rgr
npm run android:build  # compile Ranger → Kotlin and assemble debug APK
npm run android:install # build and install on a connected device/emulator
```

Requires Java 17+, `ANDROID_HOME` with SDK platform 35 and build-tools, and `adb` for install.
