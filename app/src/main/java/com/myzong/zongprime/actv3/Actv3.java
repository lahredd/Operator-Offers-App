package com.myzong.zongprime.actv3;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.myzong.zongprime.R;

import java.util.List;

public class Actv3 extends AppCompatActivity {
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actv3);

        ImageButton button1 = findViewById(R.id.imageButton);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_comp);



                ImageButton dialogButton =  dialog.findViewById(R.id.imageButton3);
                ImageButton dialogButton2 =  dialog.findViewById(R.id.imageButton4);
                ImageButton dialogButton3 =  dialog.findViewById(R.id.imageButton5);
                final ImageButton dialogButton4 = dialog.findViewById(R.id.imageButton10);
                dialogButton4.setEnabled(false);


                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent iintent = new Intent(Intent.ACTION_SEND);
                        iintent.setType("text/plain");

                        iintent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.myzong.zongprime");

                        boolean facebookAppFoundd = false;
                        List<ResolveInfo> matches = getPackageManager().queryIntentActivities(iintent, 0);
                        for (ResolveInfo info : matches) {
                            if (info.activityInfo.packageName.toLowerCase().startsWith("com.facebook.katana")) {
                                iintent.setPackage(info.activityInfo.packageName);
                                facebookAppFoundd = true;
                                break;
                            }
                        }
                        if (!facebookAppFoundd) {
                            String sharerUrl = "https://www.facebook.com/sharer/sharer.php?u=" + "https://play.google.com/store/apps/details?id=com.myzong.zongprime";
                            iintent = new Intent(Intent.ACTION_VIEW, Uri.parse(sharerUrl));
                        }

                        startActivity(iintent);

                    }
                });
                dialogButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                        whatsappIntent.setType("text/plain");
                        whatsappIntent.setPackage("com.whatsapp");
                        whatsappIntent.putExtra(Intent.EXTRA_TEXT,  "Install this App to get All ZONG Offers: https://play.google.com/store/apps/details?id=com.myzong.zongprime");
                        try {
                            Actv3.this.startActivity(whatsappIntent);
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(Actv3.this, "Whatsapp have not been installed.", Toast.LENGTH_SHORT).show();

                        }


                    }
                });
                dialogButton3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogButton4.setEnabled(true);

                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent
                                .putExtra(Intent.EXTRA_TEXT,
                                        "Install this App to get All ZONG Offers: https://play.google.com/store/apps/details?id=com.myzong.zongprime");
                        sendIntent.setType("text/plain");
                        sendIntent.setPackage("com.facebook.orca");
                        try {
                            startActivity(sendIntent);
                        }
                        catch (android.content.ActivityNotFoundException ex) {
                        }


                    }
                });
                dialogButton4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent toyy = new Intent(Actv3.this, Actv34.class);
                        startActivity(toyy);
                    }
                });

                dialog.show();

            }});
    }
}
