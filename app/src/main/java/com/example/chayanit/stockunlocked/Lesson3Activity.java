package com.example.chayanit.stockunlocked;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Lesson3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3);

        Button unlockls4_bt = findViewById(R.id.unlockls4);

        unlockls4_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences shared = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putBoolean("ls4_enable",true);
                editor.commit();
                startActivity(new Intent(Lesson3Activity.this,Lesson4Activity.class));

            }});


        ImageButton lesson3_back = findViewById(R.id.lesson3back);
        lesson3_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lesson3Activity.this,LessonActivity.class));
            }
        });
    }
}
