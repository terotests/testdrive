# Hello World (Kotlin)

Minimal Android app that logs and displays **Hello World**.

## Build

Requires Android SDK 34 and JDK 17+. Set `ANDROID_HOME`, then:

```bash
./gradlew assembleDebug
```

APK output: `app/build/outputs/apk/debug/app-debug.apk`

## Run on emulator

```bash
adb install -r app/build/outputs/apk/debug/app-debug.apk
adb shell am start -n com.example.helloworld/.MainActivity
adb logcat -s HelloWorld:I
```

On hosts without KVM, start the emulator with software acceleration, for example:

```bash
emulator -avd <your_avd> -accel off -no-window -gpu swiftshader_indirect
```
