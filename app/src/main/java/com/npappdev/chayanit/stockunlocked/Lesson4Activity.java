package com.npappdev.chayanit.stockunlocked;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Lesson4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson4);

        Button unlockls5_bt = findViewById(R.id.unlockls5);
        Button take_quiz4 = findViewById(R.id.takequiz4);


        unlockls5_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences shared = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putBoolean("ls5_enable",true);
                editor.putBoolean("qz4_enable",true);
                editor.commit();
                startActivity(new Intent(Lesson4Activity.this,Lesson5Activity.class));

            }});

        take_quiz4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences shared = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putBoolean("qz4_enable",true);
                editor.putBoolean("ls5_enable",true);
                editor.commit();
                startActivity(new Intent(Lesson4Activity.this,Quiz4Activity.class));

            }
        });

        ImageButton lesson4_back = findViewById(R.id.lesson4back);
        lesson4_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lesson4Activity.this,LessonActivity.class));
            }
        });
    }
}
