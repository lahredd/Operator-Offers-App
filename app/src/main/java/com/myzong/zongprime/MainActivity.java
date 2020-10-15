package com.myzong.zongprime;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;


import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.myzong.zongprime.actv1.Actv1;
import com.myzong.zongprime.actv2.Actv2;
import com.myzong.zongprime.actv2.Actvtest2;
import com.myzong.zongprime.actv3.Actv3;

public class MainActivity extends AppCompatActivity {

    private InterstitialAd interstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton button1 = findViewById(R.id.Button2);
        final String PREFS_NAME = "MyPrefsFile";
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        if (settings.getBoolean("my_first_time", true)) {
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent toyy = new Intent(MainActivity.this, Actvtest2.class);
                    startActivity(toyy);
                    showInterstitial(); }});
            settings.edit().putBoolean("my_first_time", false).commit();
        } else {
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent toyy = new Intent(MainActivity.this, Actv1.class);
                    startActivity(toyy);
                    showInterstitial(); }});}

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.CALL_PHONE}, 5); }

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

        ImageButton button2 =  findViewById(R.id.imageButton3);
        ImageButton button3 =  findViewById(R.id.imageButton4);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent toyy = new Intent(MainActivity.this, Actv2.class);
                startActivity(toyy);
                showInterstitial();


            }});


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toyy = new Intent(MainActivity.this, Actv3.class);
                startActivity(toyy);
                showInterstitial();


            }});

        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.shake);
        ImageButton myButton =  findViewById(R.id.imageButton4);
        myButton.setAnimation(myAnim);

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
    }






}
