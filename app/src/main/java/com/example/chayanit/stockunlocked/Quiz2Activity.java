package com.example.chayanit.stockunlocked;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Quiz2Activity extends AppCompatActivity{

    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        ImageButton quiz2_back = findViewById(R.id.quiz2back);
        quiz2_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Quiz2Activity.this, Lesson2Activity.class));
            }
        });

        Button backMenu = findViewById(R.id.backMenu);
        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Quiz2Activity.this, TitleActivity.class));
            }
        });

        if(savedInstanceState == null){
            Lesson2Quiz1Fragment lesson2Quiz1Fragment = new Lesson2Quiz1Fragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentl2q1, lesson2Quiz1Fragment).commit();
        }




    }

}
