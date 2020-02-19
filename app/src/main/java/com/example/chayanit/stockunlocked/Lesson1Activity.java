package com.example.chayanit.stockunlocked;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ImageButton;


public class Lesson1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1);


        Button unlockls2_bt = findViewById(R.id.unlockls2);

        unlockls2_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {}});
                

        ImageButton lesson1_back = findViewById(R.id.lesson1back);
        lesson1_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lesson1Activity.this,LessonActivity.class));

            }
        });
    }

}
