package com.myzong.zongprime.actv1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import androidx.appcompat.app.AppCompatActivity;

import com.codemybrainsout.ratingdialog.RatingDialog;
import com.myzong.zongprime.MainActivity;
import com.myzong.zongprime.R;
import com.myzong.zongprime.actv2.Actvtest2;

public class Actv1 extends AppCompatActivity {


    @Override
    public void onBackPressed() {
//  super.onBackPressed();
        Intent toyy = new Intent(Actv1.this, MainActivity.class);
        startActivity(toyy);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actv1);

        ImageButton button6 =  findViewById(R.id.imageView53);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toyy = new Intent(Actv1.this, MainActivity.class);
                startActivity(toyy);}});

        ImageButton button2 =  findViewById(R.id.imageView5);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toyy = new Intent(Actv1.this, Actv11.class);
                startActivity(toyy); }});
        ImageButton button3 =  findViewById(R.id.imageView7);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toyy = new Intent(Actv1.this, Actv112.class);
                startActivity(toyy); }});
        ImageButton button4 =  findViewById(R.id.imageView8);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toyy = new Intent(Actv1.this, Actv113.class);
                startActivity(toyy); }});
        ImageButton button5 =  findViewById(R.id.imageView9);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toyy = new Intent(Actv1.this, Actv114.class);
                startActivity(toyy); }});
        ImageButton button7 =  findViewById(R.id.imageView3);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toyy = new Intent(Actv1.this, Actv115.class);
                startActivity(toyy); }});

        final RatingDialog ratingDialog = new RatingDialog.Builder(this)
                .session(2)
                .title("How You Find The App?")

                .ratingBarColor(R.color.black)

                .onRatingChanged(new RatingDialog.Builder.RatingDialogListener() {
                    @Override
                    public void onRatingSelected(float rating, boolean thresholdCleared) {
                        Intent toyy = new Intent(Actv1.this, Actvtest2.class);
                        startActivity(toyy);
                    }
                })
                .onRatingBarFormSumbit(new RatingDialog.Builder.RatingDialogFormListener() {
                    @Override
                    public void onFormSubmitted(String feedback) {
                        Intent toyy = new Intent(Actv1.this, Actvtest2.class);
                        startActivity(toyy);
                    }
                }).build();

        ratingDialog.show();




    }


}
