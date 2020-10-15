package com.myzong.zongprime.actv2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.myzong.zongprime.MainActivity;
import com.myzong.zongprime.R;

public class Actv2 extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actv2);

        ImageButton button2 = findViewById(R.id.imageView5);
        ImageButton button3 = findViewById(R.id.imageView7);
        ImageButton button4 = findViewById(R.id.imageView8);
        ImageButton button5 = findViewById(R.id.imageView9);
        ImageButton button6 = findViewById(R.id.imageView53);
        ImageButton button7 = findViewById(R.id.imageView4);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toyy = new Intent(Actv2.this, MainActivity.class);
                startActivity(toyy);}});

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Actv2.this, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(Actv2.this,
                            Manifest.permission.CALL_PHONE)) {
                    } else {
                        ActivityCompat.requestPermissions(Actv2.this,
                                new String[]{Manifest.permission.CALL_PHONE}, 1); }}

                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+ Uri.encode("*222#")));
                try{
                    startActivity(intent);
                } catch (SecurityException e){
                    e.printStackTrace();
                }}});
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Actv2.this, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(Actv2.this,
                            Manifest.permission.CALL_PHONE)) {
                    } else {
                        ActivityCompat.requestPermissions(Actv2.this,
                                new String[]{Manifest.permission.CALL_PHONE}, 1); }}
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+ Uri.encode("*102*2#")));
                try{
                    startActivity(intent);
                } catch (SecurityException e){
                    e.printStackTrace();
                }}});
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Actv2.this, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(Actv2.this,
                            Manifest.permission.CALL_PHONE)) {
                    } else {
                        ActivityCompat.requestPermissions(Actv2.this,
                                new String[]{Manifest.permission.CALL_PHONE}, 1); }}
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+ Uri.encode("*102*3#")));
                try{
                    startActivity(intent);
                } catch (SecurityException e){
                    e.printStackTrace();
                }}});
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Actv2.this, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(Actv2.this,
                            Manifest.permission.CALL_PHONE)) {
                    } else {
                        ActivityCompat.requestPermissions(Actv2.this,
                                new String[]{Manifest.permission.CALL_PHONE}, 1); }}
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+ Uri.encode("*102*4#")));
                try{
                    startActivity(intent);
                } catch (SecurityException e){
                    e.printStackTrace();
                }}});
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Actv2.this, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(Actv2.this,
                            Manifest.permission.CALL_PHONE)) {
                    } else {
                        ActivityCompat.requestPermissions(Actv2.this,
                                new String[]{Manifest.permission.CALL_PHONE}, 1); }}
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+ Uri.encode("*911#")));
                try{
                    startActivity(intent);
                } catch (SecurityException e){
                    e.printStackTrace();
                }}});
    }
}
