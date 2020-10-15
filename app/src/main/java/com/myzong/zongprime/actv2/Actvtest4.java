package com.myzong.zongprime.actv2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.myzong.zongprime.R;
import com.myzong.zongprime.actv1.Actv1;

public class Actvtest4 extends AppCompatActivity {

    private InterstitialAd interstitialAd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actv2test4);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        interstitialAd = new InterstitialAd(this);

        interstitialAd.setAdUnitId(getString(R.string.ad_interst));

        interstitialAd.loadAd(new AdRequest.Builder().build());

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                startGame();
            }
        });


        ImageButton button3 =  findViewById(R.id.imageButton11);
        final String PREFS_NAME = "MyPrefsFile3";
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        if (settings.getBoolean("my_first_time3", true)) {
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent toyy = new Intent(Actvtest4.this, Actvtest4.class);
                    startActivity(toyy);
                     }});
            settings.edit().putBoolean("my_first_time3", false).commit();
        } else {
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent toyy = new Intent(Actvtest4.this, Actvtest5.class);
                    startActivity(toyy);
                    showInterstitial(); }});}
    }
    private void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and restart the game.
        if (interstitialAd != null && interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            startGame();
        }
    }

    private void startGame() {
        // Request a new ad if one isn't already loaded, hide the button, and kick off the timer.
        if (!interstitialAd.isLoading() && !interstitialAd.isLoaded()) {
            AdRequest adRequest = new AdRequest.Builder().build();
            interstitialAd.loadAd(adRequest);
        }


    }}
