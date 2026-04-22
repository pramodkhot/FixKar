# FixKar — Project Structure (Phase 1)

Every file and folder in the project, with purpose.

```
FixKar/                                    ← root (the folder you downloaded)
│
├── README.md                              ← ⭐ read this first
├── PROJECT_STRUCTURE.md                   ← this file
├── .gitignore                             ← files git should ignore
│
├── settings.gradle.kts                    ← Gradle: declares ":app" module
├── build.gradle.kts                       ← Gradle: root, declares plugins
├── gradle.properties                      ← Gradle: JVM + perf flags
│
├── gradle/
│   ├── libs.versions.toml                 ← ⭐ ALL dependency versions live here
│   └── wrapper/
│       └── gradle-wrapper.properties      ← which Gradle version to download
│
├── .devcontainer/
│   └── devcontainer.json                  ← GitHub Codespaces environment config
│
├── .github/
│   └── workflows/
│       └── build.yml                      ← auto-builds APK on every git push
│
└── app/                                   ← the app module
    │
    ├── build.gradle.kts                   ← app-level Gradle (deps, SDK versions)
    ├── proguard-rules.pro                 ← release-build minification rules
    ├── google-services.placeholder.json   ← dummy Firebase file for CI
    │
    └── src/main/
        │
        ├── AndroidManifest.xml            ← permissions, launcher, Firebase meta
        │
        ├── java/com/fixkar/app/           ← Kotlin source (MVVM layers)
        │   │
        │   ├── FixKarApplication.kt       ← Hilt + Firebase init
        │   ├── MainActivity.kt            ← single activity, Compose host
        │   │
        │   ├── core/                      ← shared helpers
        │   │   ├── Constants.kt           ← Firestore keys, roles, statuses
        │   │   └── Result.kt              ← Success/Error/Loading sealed class
        │   │
        │   ├── data/                      ← (Phase 2+) Firebase data sources
        │   │   ├── firebase/              ← .gitkeep (empty for now)
        │   │   └── repository/            ← .gitkeep (empty for now)
        │   │
        │   ├── domain/
        │   │   └── model/                 ← .gitkeep (User, Job, Bid, Review — Phase 2+)
        │   │
        │   ├── di/
        │   │   └── AppModule.kt           ← Hilt provides FirebaseAuth, Firestore, FCM
        │   │
        │   └── ui/
        │       ├── theme/                 ← Material 3 theme
        │       │   ├── Color.kt           ← brand palette (orange)
        │       │   ├── Type.kt            ← large font sizes for low-tech users
        │       │   └── Theme.kt           ← light/dark scheme + dynamic toggle
        │       │
        │       └── navigation/
        │           └── AppNavigation.kt   ← NavHost + placeholder home screen
        │
        └── res/                           ← Android resources
            │
            ├── values/
            │   ├── strings.xml            ← ⭐ English (master keys)
            │   ├── colors.xml             ← legacy color refs
            │   └── themes.xml             ← system theme (status bar, etc.)
            │
            ├── values-hi/
            │   └── strings.xml            ← ⭐ Hindi (हिन्दी) translations
            │
            ├── values-mr/
            │   └── strings.xml            ← ⭐ Marathi (मराठी) translations
            │
            ├── drawable/
            │   └── ic_launcher_foreground.xml  ← wrench icon (vector)
            │
            ├── mipmap-anydpi-v26/          ← adaptive launcher icon (Android 8+)
            │   ├── ic_launcher.xml
            │   └── ic_launcher_round.xml
            │
            ├── mipmap-anydpi/              ← legacy launcher icon (Android 7)
            │   ├── ic_launcher.xml
            │   └── ic_launcher_round.xml
            │
            └── xml/
                ├── backup_rules.xml        ← no cloud backup (protect tokens)
                └── data_extraction_rules.xml
```

## Files you will touch most often

| You want to… | Edit this file |
|---|---|
| Add/change a visible text | `app/src/main/res/values/strings.xml` (+ `values-hi`, `values-mr`) |
| Change app colors | `app/src/main/java/com/fixkar/app/ui/theme/Color.kt` |
| Bump a library version | `gradle/libs.versions.toml` |
| Add a new screen | `app/src/main/java/com/fixkar/app/ui/navigation/AppNavigation.kt` |
| Change min/target Android | `app/build.gradle.kts` |
| Add a Firebase dependency | `app/build.gradle.kts` + `gradle/libs.versions.toml` |

## Files you should NEVER edit by hand

- Files inside `app/build/`, `.gradle/`, `build/` (these are generated).
- `app/google-services.json` — this comes from Firebase, keep it secret, never commit.

## What's missing right now (to be added in later phases)

| Phase | Will add |
|---|---|
| 2 | Login screen, OtpVerify screen, AuthRepository, AuthViewModel |
| 3 | Profile screen, RoleSelection, UserRepository |
| 4 | PostJob screen, JobRepository, category master list |
| 5 | WorkerListScreen, matching logic |
| 6 | BidScreen, BidRepository |
| 7 | Job status transitions |
| 8 | ReviewScreen, ReviewRepository |
| 9 | FCM service class + Cloud Functions triggers |
| 10 | Language switcher in Settings |
