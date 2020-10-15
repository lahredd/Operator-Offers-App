package com.myzong.zongprime.actv3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;


import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.Firebase;
import com.myzong.zongprime.Client;
import com.myzong.zongprime.MainActivity;
import com.myzong.zongprime.R;
import com.myzong.zongprime.actv2.Actvtest2;

public class Actv34 extends AppCompatActivity {

    ImageButton SubmitButton;
    EditText EditText1, EditText2,EditText3, EditText4;
    public static final String Firebase_Server_URL = "https://zng-project.firebaseio.com";
    String name, email, phone, gift;
    Firebase firebase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actv3_4);

        Firebase.setAndroidContext(Actv34.this);

        firebase = new Firebase(Firebase_Server_URL);

        SubmitButton = findViewById(R.id.imageButton11);

        EditText1 = findViewById(R.id.editText2);
        EditText2 = findViewById(R.id.editText6);
        EditText3 = findViewById(R.id.editText7);
        EditText4 = findViewById(R.id.editText);

        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Client client = new Client();

                GetDataFromEditText();

                client.setStudentName(name);
                client.setStudentEmail(email);
                client.setStudentPhone(phone);
                client.setStudentGift(gift);

                firebase.push().setValue(client);

                Intent toyy = new Intent(Actv34.this, Actvtest2.class);
                startActivity(toyy);


            }
        });}

        public void GetDataFromEditText(){

            name = EditText1.getText().toString().trim();
            email  = EditText2.getText().toString().trim();
            phone  = EditText3.getText().toString().trim();
            gift  = EditText4.getText().toString().trim();

        }


    }

