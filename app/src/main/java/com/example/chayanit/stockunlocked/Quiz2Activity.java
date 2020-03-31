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

        final Lesson2Quiz1Fragment lesson2Quiz1Fragment = new Lesson2Quiz1Fragment();
        final Lesson2Quiz2Fragment lesson2Quiz2Fragment = new Lesson2Quiz2Fragment();

        currentQuiz = (int)(Math.random()*2);
        if(currentQuiz==0){
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentl2, lesson2Quiz1Fragment).commit();
        } else{
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentl2, lesson2Quiz2Fragment).commit();
        }


        final Button nextQbtn = findViewById(R.id.nextQ);
        nextQbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(currentQuiz==0){
                    getSupportFragmentManager().beginTransaction().remove(lesson2Quiz1Fragment).commit();
                    getSupportFragmentManager().beginTransaction().add(R.id.fragmentl2, lesson2Quiz2Fragment).commit();
                }else{
                    getSupportFragmentManager().beginTransaction().remove(lesson2Quiz2Fragment).commit();
                    getSupportFragmentManager().beginTransaction().add(R.id.fragmentl2, lesson2Quiz1Fragment).commit();
                }
                nextQbtn.setEnabled(false);
            }
        });




    }

}
