# FixKar

Local service marketplace for India. Customers post work (plumbing, painting, farm labour, etc.), nearby workers bid price + start time, customer picks one.

- **Stack:** Kotlin, Jetpack Compose, MVVM, Hilt, Firebase (Auth / Firestore / FCM)
- **Min Android:** 7.0 (API 24)
- **Languages:** English, Hindi, Marathi

---

## Phase status

| Phase | Status |
|---|---|
| 1. Project setup | **DONE** (this commit) |
| 2. Authentication (Phone OTP + Google) | pending |
| 3. User profile / role | pending |
| 4. Job posting | pending |
| 5. Worker matching | pending |
| 6. Bidding | pending |
| 7. Job selection | pending |
| 8. Reviews | pending |
| 9. FCM notifications | pending |
| 10. Multi-language switcher | pending |

---

## How you (Pramod) will work — no Android Studio needed

You will use **GitHub + GitHub Codespaces** as your full cloud dev environment. APKs are produced by **GitHub Actions** automatically.

### One-time setup (do this once, in order)

#### 1. Create the GitHub repo

1. Go to https://github.com/new
2. Name it `FixKar` (or anything)
3. Make it **Public**
4. Click **Create repository**
5. Copy the instructions under "push an existing repository from the command line" — you'll use them below.

#### 2. Upload the code to GitHub

From this workspace folder, in a terminal:

```bash
cd <path to FixKar folder>
git init
git branch -M main
git add .
git commit -m "Phase 1: project setup"
git remote add origin https://github.com/<your-username>/FixKar.git
git push -u origin main
```

#### 3. Create the Firebase project

1. Go to https://console.firebase.google.com/
2. Add project → name it **FixKar** → disable Analytics for now (you can enable later).
3. Once created, click **Add app → Android**.
4. Package name: `com.fixkar.app`
5. Debug signing certificate SHA-1: *leave blank for now* (we'll add after first Codespaces build).
6. Download the **google-services.json** file.

You need TWO Android apps in Firebase actually:
- `com.fixkar.app` (release)
- `com.fixkar.app.debug` (what Codespaces builds produce)

Add both. Download the merged `google-services.json` again after adding both apps.

#### 4. Add the Firebase file as a GitHub secret

Codespaces and CI will read it from a secret, so it never gets committed.

1. Open your downloaded `google-services.json`
2. Copy the **entire contents**
3. On GitHub: your repo → **Settings → Secrets and variables → Actions → New repository secret**
4. Name: `GOOGLE_SERVICES_JSON`
5. Value: paste the file contents
6. Save

#### 5. Enable Firebase services you'll need

In Firebase Console:
- **Authentication → Sign-in method:** enable *Phone* and *Google*.
- **Firestore Database → Create database:** in test mode (we'll tighten rules in Phase 4).
- **Cloud Messaging:** already on by default.

---

## Daily workflow

### Editing the code (in Codespaces)

1. Open your repo on GitHub.
2. Click green **< > Code** button → **Codespaces** tab → **Create codespace on main**.
3. Wait ~2 minutes. You get a full VS Code in the browser with Android SDK pre-installed.
4. First time only, in the terminal:
   ```bash
   gradle wrapper --gradle-version 8.9
   chmod +x gradlew
   ```
5. Drop `google-services.json` into `app/` (drag from your computer), or paste the contents.
6. Build a debug APK:
   ```bash
   ./gradlew :app:assembleDebug
   ```
7. The APK lands at `app/build/outputs/apk/debug/app-debug.apk`. Right-click → **Download** to install on your phone.

### Getting APKs automatically (CI)

Every time you `git push` to `main`, GitHub Actions builds an APK for you.

1. Go to your repo → **Actions** tab.
2. Click the latest run → **Artifacts** → download `fixkar-debug-apk`.
3. Unzip → install the APK on your Android phone (enable *Install unknown apps* first).

### Installing on your phone (testing)

1. On the phone, enable **Settings → Security → Install unknown apps** for your browser / file manager.
2. Download the APK.
3. Tap to install.

---

## Project structure (MVVM)

```
app/src/main/java/com/fixkar/app/
├── FixKarApplication.kt   Application class, Hilt + Firebase init
├── MainActivity.kt        Single Activity, hosts Compose
├── core/                  Constants, Result wrapper
├── data/                  Repositories + Firebase data sources (Phase 2+)
├── domain/model/          Data classes (User, Job, Bid, Review)
├── di/AppModule.kt        Hilt bindings
└── ui/
    ├── theme/             Colours, typography, Material 3 theme
    └── navigation/        NavHost + per-screen composables
```

---

## What Phase 1 gives you

When you install the Phase 1 APK you'll see:
- Orange brand splash / launcher icon
- A single screen showing "FixKar — Local help, on your street"

That's deliberately minimal. It proves the whole toolchain works: build, sign, install, render Compose, load string resources.

Phase 2 will replace this screen with the Login flow.

---

## Publishing to Play Store (later, when app is ready)

We'll cover this in a dedicated phase. High-level:

1. Generate a release keystore (one-time).
2. Add it as a GitHub secret.
3. GitHub Actions builds a signed `.aab` (App Bundle).
4. Upload to Play Console (Internal testing → Closed testing → Production).

Don't worry about this now — focus on finishing features first.
