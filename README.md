# CalculatorWithHyBid (Android) - Ready-to-upload sample project

**What this archive contains**
- A minimal Android Studio project skeleton (Kotlin) implementing a simple calculator UI.
- HyBid integration placeholders (Interstitial preloading & show flow) and guidance on where to add the real SDK calls.
- `screenshots/` folder with two mock screenshots (banner visible on main screen; interstitial mock on calculation complete).
- Step-by-step instructions to import into Android Studio, integrate HyBid SDK, and publish to GitHub yourself.

**Important notes (read first)**
- I cannot create/push a GitHub repository for you from here. Instead this zip contains a complete project you can open in Android Studio and push to a repo.
- The HyBid SDK requires network access and signing with your environment; this bundle contains placeholder code and comments that show exactly where to add the HyBid SDK and credentials.
- HyBid documentation (integration examples used): https://github.com/pubnative/verve-hybid-x-android-sample and https://developers.verve.com/reference/hybid-android-sdk. Please follow those for the exact SDK versions and API updates.

---
## Quick start (run locally)
1. Unzip this archive and open the folder `CalculatorWithHyBid` in **Android Studio (Arctic Fox / Chipmunk or later)**.
2. Let Gradle sync. The project uses placeholders for HyBid artifacts — see `app/build.gradle` and README notes.
3. Replace the placeholder HyBid dependencies with the version you want, and add this Maven repository to project-level `build.gradle` if needed:

   ```gradle
   allprojects {
       repositories {
           google()
           mavenCentral()
           // Verve JFrog repo (example)
           maven { url "https://verve.jfrog.io/artifactory/verve-gradle-release" }
       }
   }
   ```
4. Set your HyBid app token & zone id in `app/src/main/res/values/strings.xml` (the included values are the ones you provided):
   - `hybid_app_token = "dde3c298b47648459f8ada4a982fa92d"`
   - `hybid_zone_id = "1"`
5. Open `app/src/main/java/com/example/calculator/MyApp.kt` and **uncomment** the HyBid initialization lines after you have installed the SDK dependency.
6. Build & run on a real device (recommended) or emulator. To test interstitial behaviour, perform a calculation; the app will call the `showInterstitial()` placeholder after calculation completes.

## How to push to GitHub (one-liner inside the project folder)
```bash
git init
git add .
git commit -m "Initial commit - CalculatorWithHyBid sample"
# create a repo on GitHub (via web) then:
git remote add origin https://github.com/<your-username>/CalculatorWithHyBid.git
git branch -M main
git push -u origin main
```

## Where the HyBid SDK integration points are (short)
- `MyApp.kt` -> HyBid SDK initialization (Application.onCreate)
- `MainActivity.kt` -> create hyBid object, preload interstitial during `onCreate/onStart`, and call `hyBidX.showAd(...)` right after a calculation completes
- `activity_main.xml` -> `FrameLayout` with id `adContainer` for the banner placeholder (replace it with real banner view once you add the banner artifact)

## HyBid resources (useful links)
- HyBid Android sample (HyBidX): https://github.com/pubnative/verve-hybid-x-android-sample
- HyBid Android SDK docs: https://developers.verve.com/reference/hybid-android-sdk
- Maven artifacts (mvnrepository): https://mvnrepository.com/artifact/net.pubnative/hybid.sdk

---
If you want, I can also convert this into a GitHub-ready repo (I can't push for you, but I can provide exact Git commands or a GH Actions script).

