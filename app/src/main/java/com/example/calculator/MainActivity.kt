package com.example.calculator

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.pubnative.lite.sdk.views.HyBidBannerAdView
import net.pubnative.lite.sdk.views.PNAdView
import net.pubnative.lite.sdk.interstitial.HyBidInterstitialAd

class MainActivity : AppCompatActivity(), HyBidInterstitialAd.Listener {

    private lateinit var banner: HyBidBannerAdView
    private var interstitial: HyBidInterstitialAd? = null

    private lateinit var inputA: EditText
    private lateinit var inputB: EditText
    private lateinit var resultText: TextView
    private lateinit var calcBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputA = findViewById(R.id.inputA)
        inputB = findViewById(R.id.inputB)
        resultText = findViewById(R.id.resultText)
        calcBtn = findViewById(R.id.calcBtn)

        // Banner: load with zoneId + listener (PNAdView.Listener per HyBid wiki)
        banner = findViewById(R.id.hybid_banner)
        banner.load(
            getString(R.string.hybid_zone_id),
            object : PNAdView.Listener {
                override fun onAdLoaded() {
                    Log.d("HyBid", "Banner loaded")
                }

                override fun onAdLoadFailed(error: Throwable?) {
                    Log.e("HyBid", "Banner load failed: ${error?.message}")
                }

                override fun onAdImpression() {
                    Log.d("HyBid", "Banner impression")
                }

                override fun onAdClick() {
                    Log.d("HyBid", "Banner clicked")
                }
            }
        )

        // Interstitial: create with zoneId and listener (listener is implemented by this Activity)
        interstitial = HyBidInterstitialAd(this, getString(R.string.hybid_zone_id), this)
        interstitial?.load()

        // Calculator button: show interstitial if ready after calculation completes
        calcBtn.setOnClickListener {
            val a = inputA.text.toString().toDoubleOrNull() ?: 0.0
            val b = inputB.text.toString().toDoubleOrNull() ?: 0.0
            val sum = a + b
            resultText.text = "Result: $sum"

            if (interstitial?.isReady == true) {
                interstitial?.show()
            } else {
                Log.d("HyBid", "Interstitial not ready")
            }
        }
    }

    // Interstitial callbacks (exact methods from HyBid Interstitial docs)
    override fun onInterstitialLoaded() {
        Log.d("HyBid", "Interstitial loaded")
    }

    override fun onInterstitialLoadFailed(error: Throwable?) {
        Log.e("HyBid", "Interstitial load failed: ${error?.message}")
    }

    override fun onInterstitialImpression() {
        Log.d("HyBid", "Interstitial impression")
    }

    override fun onInterstitialDismissed() {
        Log.d("HyBid", "Interstitial dismissed")
    }

    override fun onInterstitialClick() {
        Log.d("HyBid", "Interstitial clicked")
    }

    override fun onDestroy() {
        super.onDestroy()
        try {
            banner.destroy()
        } catch (e: Throwable) { /* ignore */ }
        interstitial?.destroy()
    }
}
