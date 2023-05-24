package com.example.financetreeservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.webView);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("url");
            //The key argument here must match that used in the other activity
            webView.loadUrl(value);
        }

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                findViewById(R.id.progressbar).setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                findViewById(R.id.progressbar).setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
        });

        webView.getSettings().setJavaScriptEnabled(true);
        //Zoom
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        //Cache and storage
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //optional settings
        webView.getSettings().setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAppCacheEnabled(true);
        //Others
        webView.setFocusable(true);
        webView.setFocusableInTouchMode(true);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);//the best for games

        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-8420943667648993/8924345663", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        //Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        //Log.d(TAG, loadAdError.toString());
                        mInterstitialAd = null;
                    }
                });
        /*mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
            @Override
            public void onAdClicked() {
                // Called when a click is recorded for an ad.
//                Log.d(TAG, "Ad was clicked.");
            }

            @Override
            public void onAdDismissedFullScreenContent() {
                // Called when ad is dismissed.
                // Set the ad reference to null so you don't show the ad a second time.
//                Log.d(TAG, "Ad dismissed fullscreen content.");
                mInterstitialAd = null;
            }

            @Override
            public void onAdFailedToShowFullScreenContent(AdError adError) {
                // Called when ad fails to show.
//                Log.e(TAG, "Ad failed to show fullscreen content.");
                mInterstitialAd = null;
            }

            @Override
            public void onAdImpression() {
                // Called when an impression is recorded for an ad.
//                Log.d(TAG, "Ad recorded an impression.");
            }

            @Override
            public void onAdShowedFullScreenContent() {
                // Called when ad is shown.
//                Log.d(TAG, "Ad showed fullscreen content.");
            }
        });*/
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {

            webView.goBack();
            if (mInterstitialAd != null) {
                mInterstitialAd.show(WebViewActivity.this);
            } else {
//                Toast.makeText(this, "The interstitial ad wasn't ready yet.", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onBackPressed();
            if (mInterstitialAd != null) {
                mInterstitialAd.show(WebViewActivity.this);
            } else {
//                Toast.makeText(this, "The interstitial ad wasn't ready yet.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}