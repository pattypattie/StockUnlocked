package com.npappdev.chayanit.stockunlocked;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private static int SPLASH_TIME_OUT = 3200;
    private static final String MY_PREFS = "my_prefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //SharedPreferences shared = getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE);
        //final boolean firsttimer = shared.getBoolean("first_time", true);

//        if(firsttimer==true) {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    Intent i = new Intent(MainActivity.this, IntroActivity.class);//Start Another Activity

                    // Intent i=new Intent(MainActivity.this,TitleActivity.class);//Start Another Activity

                    startActivity(i);
                    finish();
                }
            }, SPLASH_TIME_OUT);
//            SharedPreferences.Editor editor = shared.edit();
//            editor.putBoolean("first_time",false);
//            editor.commit();

//        } else {
//            new Handler().postDelayed(new Runnable() {
//
//                @Override
//                public void run() {
//
//                    //Intent i = new Intent(MainActivity.this, IntroActivity.class);//Start Another Activity
//
//                    Intent i=new Intent(MainActivity.this,TitleActivity.class);//Start Another Activity
//
//                    startActivity(i);
//                    finish();
//                }
//            }, SPLASH_TIME_OUT);
//        }



    }
}
