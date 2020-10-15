package com.myzong.zongprime.actv2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.myzong.zongprime.MainActivity;
import com.myzong.zongprime.R;
import com.myzong.zongprime.actv1.Actv1;

public class Actvtest2 extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actv2test2);


        ImageButton button3 =  findViewById(R.id.imageButton11);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent toyy = new Intent(Actvtest2.this, Actvtest22.class);
                startActivity(toyy);

            }});


    }}
