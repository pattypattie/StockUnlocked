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

    int currentQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);


        Button backMenu = findViewById(R.id.backMenu);
        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Quiz2Activity.this, TitleActivity.class));
            }
        });

        //if(savedInstanceState == null){
            //Lesson2Quiz1Fragment lesson2Quiz1Fragment = new Lesson2Quiz1Fragment();
            //Lesson2Quiz2Fragment lesson2Quiz2Fragment = new Lesson2Quiz2Fragment();
            //getSupportFragmentManager().beginTransaction().add(R.id.fragmentl2q1, lesson2Quiz1Fragment).commit();
            //getSupportFragmentManager().beginTransaction().add(R.id.fragmentl2q1, lesson2Quiz2Fragment).commit();
        //}

        final Lesson2Quiz1Fragment lesson2Quiz1Fragment = new Lesson2Quiz1Fragment();
        final Lesson2Quiz2Fragment lesson2Quiz2Fragment = new Lesson2Quiz2Fragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentl2, lesson2Quiz1Fragment).commit();
        currentQuiz = 1;

        final Button nextQbtn = findViewById(R.id.nextQ);
        nextQbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(currentQuiz==1){
                    getSupportFragmentManager().beginTransaction().remove(lesson2Quiz1Fragment).commit();
                    getSupportFragmentManager().beginTransaction().add(R.id.fragmentl2, lesson2Quiz2Fragment).commit();
                    currentQuiz = 2;
                }else if(currentQuiz==2){
                    // next quiz fragment
                }
            }
        });




    }

}
