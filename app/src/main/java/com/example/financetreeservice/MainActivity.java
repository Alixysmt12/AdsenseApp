package com.example.financetreeservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    MaterialCardView link1,link2,link3,link4,link5,link6,link7,link8,link9,link10;
    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        adView.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                super.onAdClicked();
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {

                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
                super.onAdFailedToLoad(adError);
                adView.loadAd(adRequest);

            }

            @Override
            public void onAdImpression() {
                // Code to be executed when an impression is recorded
                // for an ad.
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }
        });
        link1 = findViewById(R.id.materialCardViewLink);
        link2 = findViewById(R.id.materialCardView2);
        link3 = findViewById(R.id.m3);
        link4 = findViewById(R.id.m4);
        link5 = findViewById(R.id.m5);
        link6 = findViewById(R.id.m6);
        link7 = findViewById(R.id.m7);
        link8 = findViewById(R.id.m8);
        link9 = findViewById(R.id.m9);
        link10 = findViewById(R.id.m10);

        link1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
                intent.putExtra("url","https://financetreeservice.net/");
                startActivity(intent);
            }
        });
        link2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
                intent.putExtra("url","https://newsnationwise.com/");
                startActivity(intent);
            }
        });
        link3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
                intent.putExtra("url","https://newshonest.com/");
                startActivity(intent);
            }
        });
        link4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
                intent.putExtra("url","https://moneymodest.blogspot.com/");
                startActivity(intent);
            }
        });
        link5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
                intent.putExtra("url","https://physicsofbody.blogspot.com/");
                startActivity(intent);
            }
        });
        link6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
                intent.putExtra("url","https://thetechschool24.blogspot.com//");
                startActivity(intent);
            }
        });
        link7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
                intent.putExtra("url","https://mydreamjobzz.blogspot.com/");
                startActivity(intent);
            }
        });
        link8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
                intent.putExtra("url","https://anewsvoice.blogspot.com/");
                startActivity(intent);
            }
        });
        link9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
                intent.putExtra("url","https://bestfoodreport.blogspot.com/");
                startActivity(intent);
            }
        });

        link10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
                intent.putExtra("url","https://4seasontravels.blogspot.com/");
                startActivity(intent);
            }
        });
    }
}