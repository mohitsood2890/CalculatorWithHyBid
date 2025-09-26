package com.example.calculator

import android.app.Application
import net.pubnative.lite.sdk.HyBid

// import com.pubnative.hybidx.HyBidX // <-- uncomment when HyBidX (or HyBid SDK) is added

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize HyBid SDK (example - uncomment after adding the dependency)
        // HyBidX.initialize(this)
        // or with the standalone SDK: HyBid.initialize(this, "<YOUR-APP-TOKEN>")
        //override fun onCreate() {
        //    super.onCreate()
        HyBid.initialize(getString(R.string.hybid_app_token), this) // Example init
       // }

    }
}
