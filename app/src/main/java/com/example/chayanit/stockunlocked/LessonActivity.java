package com.example.chayanit.stockunlocked;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class LessonActivity extends AppCompatActivity {

    private static final String MY_PREFS = "my_prefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        SharedPreferences shared = getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE);

        Button lesson1_bt = findViewById(R.id.lesson1);
        Button lesson2_bt = findViewById(R.id.lesson2);
        Button lesson3_bt = findViewById(R.id.lesson3);
        Button lesson4_bt = findViewById(R.id.lesson4);
        Button lesson5_bt = findViewById(R.id.lesson5);
        Button lesson6_bt = findViewById(R.id.lesson6);

//
//        lesson5_bt.setEnabled(false);
//        lesson2_bt.setEnabled(false);
//        lesson3_bt.setEnabled(false);
//        lesson4_bt.setEnabled(false);

//        SharedPreferences.Editor editor = shared.edit();
//        editor.putBoolean("ls2_enable", false);
//        editor.putBoolean("ls3_enable", false);
//        editor.putBoolean("ls4_enable", false);
//        editor.putBoolean("ls5_enable", false);
//        editor.commit();

        boolean ls2state = shared.getBoolean("ls2_enable", false);
        boolean ls3state = shared.getBoolean("ls3_enable", false);
        boolean ls4state = shared.getBoolean("ls4_enable", false);
        boolean ls5state = shared.getBoolean("ls5_enable", false);
        boolean ls6state = shared.getBoolean("ls6_enable", false);

        lesson2_bt.setEnabled(ls2state);
        lesson3_bt.setEnabled(ls3state);
        lesson4_bt.setEnabled(ls4state);
        lesson5_bt.setEnabled(ls5state);
        lesson6_bt.setEnabled(ls6state);


        lesson1_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LessonActivity.this,Lesson1Activity.class));
            }
        });

        lesson2_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LessonActivity.this,Lesson2Activity.class));
            }
        });

        lesson3_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LessonActivity.this,Lesson3Activity.class));
            }
        });

        lesson4_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LessonActivity.this,Lesson4Activity.class));
            }
        });

        lesson5_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LessonActivity.this,Lesson5Activity.class));
            }
        });

        lesson6_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LessonActivity.this,Lesson6Activity.class));
            }
        });

        ImageButton lesson_back = findViewById(R.id.lessonback);
        lesson_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LessonActivity.this,TitleActivity.class));
            }
        });



    }

}
