package com.myzong.zongprime.actv1;



import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.codemybrainsout.ratingdialog.RatingDialog;
import com.like.LikeButton;
import com.like.OnLikeListener;
import com.myzong.zongprime.MainActivity;
import com.myzong.zongprime.R;
import com.myzong.zongprime.actv2.Actvtest2;
import com.myzong.zongprime.actv3.Actv3;
import com.myzong.zongprime.actv3.Actv34;

import java.util.List;


public class AnimeActivity extends AppCompatActivity {
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actv1_2);

        showDialog();


        final String title  = getIntent().getExtras().getString("anime_title");
        String volume = getIntent().getExtras().getString("anime_volume");
        String duration = getIntent().getExtras().getString("anime_duration") ;
        final String activation = getIntent().getExtras().getString("anime_activation");
        String deactivation = getIntent().getExtras().getString("anime_deactivation");
        String price = getIntent().getExtras().getString("anime_price");


        TextView a_title = findViewById(R.id.textView4);
        TextView a_volume = findViewById(R.id.textView17);
        TextView a_duration = findViewById(R.id.textView6) ;
        TextView a_activation = findViewById(R.id.textView8);
        TextView a_deactivation = findViewById(R.id.textView9);
        TextView a_price = findViewById(R.id.textView18);

        a_title.setText(title);
        a_volume.setText(volume);
        a_duration.setText(duration);
        a_activation.setText(activation);
        a_deactivation.setText(deactivation);
        a_price.setText(price);

        LikeButton star = findViewById(R.id.star_button);
        LikeButton heart = findViewById(R.id.heart_button);
        LikeButton thumb = findViewById(R.id.like_button);
        heart.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                AnimeActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.myzong.zongprime"))); }
            @Override
            public void unLiked(LikeButton likeButton) {
                AnimeActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.myzong.zongprime"))); }
        });
        star.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                Intent toyy = new Intent(AnimeActivity.this, Actvtest2.class);
                startActivity(toyy); }
            @Override
            public void unLiked(LikeButton likeButton) {
                Intent toyy = new Intent(AnimeActivity.this, Actvtest2.class);
                startActivity(toyy); }
        });
        thumb.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent
                        .putExtra(Intent.EXTRA_TEXT,
                                title + " : use " + activation + " to activate this offer \n Install this App to get All the Offers: https://play.google.com/store/apps/details?id=com.myzong.zongprime");
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.facebook.orca");
                try {
                    startActivity(sendIntent);
                }
                catch (android.content.ActivityNotFoundException ex) {
                }
            }

            @Override
            public void unLiked(LikeButton likeButton) {
                Intent toyy = new Intent(AnimeActivity.this, Actvtest2.class);
                startActivity(toyy); }

        });

        ImageButton button1 = findViewById(R.id.imageView53);
        final String PREFS_NAME = "MyPrefsFilemm";
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        if (settings.getBoolean("my_first_timemm", true)) {
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent toyy = new Intent(AnimeActivity.this, Actvtest2.class);
                    startActivity(toyy);
                     }});
            settings.edit().putBoolean("my_first_timemm", false).commit();
        } else {
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent toyy = new Intent(AnimeActivity.this, Actv1.class);
                    startActivity(toyy);
                     }});}





        ImageButton button2 = findViewById(R.id.imageButton12);

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (ContextCompat.checkSelfPermission(AnimeActivity.this, Manifest.permission.CALL_PHONE)
                            != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(AnimeActivity.this,
                                new String[]{Manifest.permission.CALL_PHONE}, 1); }
                    String str = "Sub";
                    if (activation.contains("*")) {
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:"+ Uri.encode(activation)));
                        try{
                            startActivity(intent);
                        } catch (SecurityException e){
                            e.printStackTrace();
                        }
                    } else if (activation.contains(str)) {
                        Intent intent2 = new Intent("android.intent.action.VIEW");
                        intent2.setType("vnd.android-dir/mms-sms");
                        intent2.putExtra("sms_body", str);
                        startActivity(intent2);
                    } else{ AnimeActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.myzong.zongprime"))); }

                   }});





        ImageButton button5 = findViewById(R.id.imageButton6);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // custom dialog
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_share);



                ImageButton dialogButton = (ImageButton) dialog.findViewById(R.id.imageButton3);
                ImageButton dialogButton2 = (ImageButton) dialog.findViewById(R.id.imageButton17);
                ImageButton dialogButton3 = (ImageButton) dialog.findViewById(R.id.imageButton18);

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
                        whatsappIntent.putExtra(Intent.EXTRA_TEXT,  title + " : use " + activation + " to activate this offer \n Install this App to get All the Offers: https://play.google.com/store/apps/details?id=com.myzong.zongprime");
                        try {
                            AnimeActivity.this.startActivity(whatsappIntent);
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(AnimeActivity.this, "Whatsapp have not been installed.", Toast.LENGTH_SHORT).show();

                        }



                    }
                });
                dialogButton3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent
                                .putExtra(Intent.EXTRA_TEXT,
                                        title + " : use " + activation + " to activate this offer \n Install this App to get All the Offers: https://play.google.com/store/apps/details?id=com.myzong.zongprime");
                        sendIntent.setType("text/plain");
                        sendIntent.setPackage("com.facebook.orca");
                        try {
                            startActivity(sendIntent);
                        }
                        catch (android.content.ActivityNotFoundException ex) {
                        }


                    }
                });

                dialog.show();
            }
        });




        ImageButton button3 = findViewById(R.id.imageButton5);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_comp);



                ImageButton dialogButton = (ImageButton) dialog.findViewById(R.id.imageButton3);
                ImageButton dialogButton2 = (ImageButton) dialog.findViewById(R.id.imageButton4);
                ImageButton dialogButton3 = (ImageButton) dialog.findViewById(R.id.imageButton5);
                final ImageButton dialogButton4 = (ImageButton) dialog.findViewById(R.id.imageButton10);
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
                            AnimeActivity.this.startActivity(whatsappIntent);
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(AnimeActivity.this, "Whatsapp have not been installed.", Toast.LENGTH_SHORT).show();

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
                        Intent toyy = new Intent(AnimeActivity.this, Actv34.class);
                        startActivity(toyy);
                    }
                });

                dialog.show();
            }
        });

        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.shake);
        ImageButton myButton =  findViewById(R.id.imageButton5);
        myButton.setAnimation(myAnim);
    }
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    private void showDialog() {
        final RatingDialog ratingDialog = new RatingDialog.Builder(this)
                .session(4)
                .threshold(6)
                .title("Rate ZONG Packages Plus?\nThanks")
                .titleTextColor(R.color.colorAccent)
                .positiveButtonText("Not Now")
                .negativeButtonText("Never")
                .positiveButtonTextColor(R.color.colorAccent)
                .negativeButtonTextColor(R.color.grey_500)
                .formTitle("Submit Feedback")
                .formHint("How Do You Find Zong Packages App ?")
                .formSubmitText("Submit")
                .formCancelText("Cancel")
                .ratingBarColor(R.color.colorAccent)
                .playstoreUrl("https://play.google.com/store/apps/details?id=com.myzong.zongprime")

                .onRatingBarFormSumbit(new RatingDialog.Builder.RatingDialogFormListener() {
                    @Override
                    public void onFormSubmitted(String feedback) {

                    }
                }).build();

        ratingDialog.show();


    }
}
