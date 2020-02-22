package com.example.chayanit.stockunlocked;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class LessonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        Button lesson1_bt = findViewById(R.id.lesson1);
        Button lesson2_bt = findViewById(R.id.lesson2);
        Button lesson3_bt = findViewById(R.id.lesson3);
        Button lesson4_bt = findViewById(R.id.lesson4);
        Button lesson5_bt = findViewById(R.id.lesson5);

        lesson5_bt.setEnabled(false);
        //lesson2_bt.setEnabled(false);
        lesson3_bt.setEnabled(false);
        lesson4_bt.setEnabled(false);

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

        ImageButton lesson_back = findViewById(R.id.lessonback);
        lesson_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LessonActivity.this,TitleActivity.class));
            }
        });



    }

}
