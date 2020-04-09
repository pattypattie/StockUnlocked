package com.npappdev.chayanit.stockunlocked;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ImageButton quiz_back = findViewById(R.id.quizback);
        quiz_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizActivity.this,TitleActivity.class));
            }
        });

        SharedPreferences shared = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);

        Button quiz1_bt = findViewById(R.id.quiz1);
        Button quiz2_bt = findViewById(R.id.quiz2);
        Button quiz3_bt = findViewById(R.id.quiz3);
        Button quiz4_bt = findViewById(R.id.quiz4);
        Button quiz5_bt = findViewById(R.id.quiz5);
        Button quiz6_bt = findViewById(R.id.quiz6);
        Button quizSpecial_bt = findViewById(R.id.quizSpecial);


        boolean quiz1state = shared.getBoolean("qz1_enable", false);
        boolean quiz2state = shared.getBoolean("qz2_enable", false);
        boolean quiz3state = shared.getBoolean("qz3_enable", false);
        boolean quiz4state = shared.getBoolean("qz4_enable", false);
        boolean quiz5state = shared.getBoolean("qz5_enable", false);
        boolean quiz6state = shared.getBoolean("qz6_enable", false);


        quiz1_bt.setEnabled(quiz1state);
        quiz2_bt.setEnabled(quiz2state);
        quiz3_bt.setEnabled(quiz3state);
        quiz4_bt.setEnabled(quiz4state);
        quiz5_bt.setEnabled(quiz5state);
        quiz6_bt.setEnabled(quiz6state);
        quizSpecial_bt.setEnabled(quiz6state);

        quiz1_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizActivity.this,Quiz1Activity.class));
            }
        });

        quiz2_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizActivity.this,Quiz2Activity.class));
            }
        });
        quiz3_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizActivity.this,Quiz3Activity.class));
            }
        });
        quiz4_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizActivity.this,Quiz4Activity.class));
            }
        });
        quiz5_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizActivity.this,Quiz5Activity.class));
            }
        });
        quiz6_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizActivity.this,Quiz6Activity.class));
            }
        });
        quizSpecial_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizActivity.this, SpecialQuizActivity.class));
            }
        });
    }
}
