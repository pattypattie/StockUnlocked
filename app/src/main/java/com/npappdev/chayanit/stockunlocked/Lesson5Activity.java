package com.npappdev.chayanit.stockunlocked;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Lesson5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson5);

        Button unlockls6_bt = findViewById(R.id.unlockls6);
        Button take_quiz5 = findViewById(R.id.takequiz5);

        unlockls6_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences shared = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putBoolean("ls6_enable",true);
                editor.putBoolean("qz5_enable",true);
                editor.commit();
                startActivity(new Intent(Lesson5Activity.this,Lesson6Activity.class));

            }});


        take_quiz5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences shared = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putBoolean("qz5_enable",true);
                editor.commit();
                startActivity(new Intent(Lesson5Activity.this,Quiz5Activity.class));

            }
        });

        ImageButton lesson5_back = findViewById(R.id.lesson5back);
        lesson5_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lesson5Activity.this,LessonActivity.class));
            }
        });
    }
}
