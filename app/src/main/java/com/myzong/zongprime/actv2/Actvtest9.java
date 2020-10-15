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

public class Actvtest9 extends AppCompatActivity {


    private InterstitialAd interstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actv2test9);



        ImageButton button3 =  findViewById(R.id.imageButton11);

            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent toyy = new Intent(Actvtest9.this, Actvtest10.class);
                    startActivity(toyy);
                    }});}

   }
