HYBID INTEGRATION NOTES (short)

Use the official HyBid docs to choose the SDK artifact you want to integrate (standalone HyBid SDK or HyBidX).
Example artifact groups found on mvnrepository:
  - net.pubnative:hybid.sdk
  - net.pubnative:hybid.sdk.banner (modular banner artifact)
  - net.pubnative:hybidx (HyBidX sample repo uses hybidx)

Steps:
  1. Add repository (verve.jfrog) to project-level repositories if needed.
  2. Add the SDK dependency to app/build.gradle (implementation 'net.pubnative:hybid.sdk:3.x.x').
  3. Initialize SDK in Application.onCreate (see MyApp.kt). For HyBidX sample: HyBidX.initialize(this)
  4. Create hyBid/hyBidX object in Activity and call hyBidX.load(context, zoneId) to preload/interstitial.
  5. For banners: replace the FrameLayout adContainer with the SDK's banner view and call load() as documented.

Docs & samples (authoritative):
  - HyBidX sample: https://github.com/pubnative/verve-hybid-x-android-sample
  - HyBid Android docs: https://developers.verve.com/reference/hybid-android-sdk
