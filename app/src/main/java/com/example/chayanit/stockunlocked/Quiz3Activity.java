package com.example.chayanit.stockunlocked;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

public class Quiz3Activity extends AppCompatActivity {

    int currentQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);

        Button backMenu = findViewById(R.id.backMenu);
        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Quiz3Activity.this, TitleActivity.class));
            }
        });

        final lesson3Quiz1Fragment lesson3Quiz1Fragment = new lesson3Quiz1Fragment();
        final lesson3Quiz2Fragment lesson3Quiz2Fragment = new lesson3Quiz2Fragment();
        final Lesson3Quiz3Fragment lesson3Quiz3Fragment = new Lesson3Quiz3Fragment();

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentl3, lesson3Quiz1Fragment).commit();
        currentQuiz = 1;

        final Button nextQbtn = findViewById(R.id.nextQ);
        nextQbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(currentQuiz==1){
                    getSupportFragmentManager().beginTransaction().remove(lesson3Quiz1Fragment).commit();
                    getSupportFragmentManager().beginTransaction().add(R.id.fragmentl3, lesson3Quiz2Fragment).commit();
                    currentQuiz = 2;
                }else if(currentQuiz==2){
                    getSupportFragmentManager().beginTransaction().remove(lesson3Quiz2Fragment).commit();
                    getSupportFragmentManager().beginTransaction().add(R.id.fragmentl3, lesson3Quiz3Fragment).commit();
                    currentQuiz = 3;
                } else if(currentQuiz ==3){

                }
            }
        });




    }


}
