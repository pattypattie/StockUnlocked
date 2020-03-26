package com.example.chayanit.stockunlocked;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Quiz6Activity extends AppCompatActivity {

    int currentQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz6);

        final Lesson6Quiz1Fragment lesson6Quiz1Fragment = new Lesson6Quiz1Fragment();
        final Lesson6Quiz2Fragment lesson6Quiz2Fragment = new Lesson6Quiz2Fragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentl6, lesson6Quiz1Fragment).commit();
        currentQuiz = 1;

        final Button nextQbtn = findViewById(R.id.nextQ);
        nextQbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(currentQuiz==1){
                    getSupportFragmentManager().beginTransaction().remove(lesson6Quiz1Fragment).commit();
                    getSupportFragmentManager().beginTransaction().add(R.id.fragmentl6, lesson6Quiz2Fragment).commit();
                    currentQuiz = 2;
                }else if(currentQuiz==2){
                    // next quiz fragment
                }
            }
        });

    }
}
