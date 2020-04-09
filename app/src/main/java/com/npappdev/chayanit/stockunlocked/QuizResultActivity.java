package com.npappdev.chayanit.stockunlocked;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        Bundle bundle = getIntent().getExtras();

        TextView scoreReport = findViewById(R.id.textView33);
        TextView unlock = findViewById(R.id.unlockls);
        int QsNum = bundle.getInt("QsNum");
        int finalScore;
        Button unlockls = findViewById(R.id.unlockls);


        switch (QsNum){
            case 1 :
                finalScore = bundle.getInt("finalScore");
                //scoreReport.setText("Your score is : "+finalScore);
                //unlock.setText("Unlock lesson 2");
                unlockls.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SharedPreferences shared = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = shared.edit();
                        editor.putBoolean("ls2_enable",true);
                        editor.commit();
                        startActivity(new Intent(QuizResultActivity.this,Lesson2Activity.class));
                    }
                });
                break;
            case 2 :
                finalScore = bundle.getInt("finalScore");
                //scoreReport.setText("Your score is : "+finalScore);
                //unlock.setText("Unlock lesson 3");
                unlockls.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SharedPreferences shared = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = shared.edit();
                        editor.putBoolean("ls3_enable",true);
                        editor.commit();
                        startActivity(new Intent(QuizResultActivity.this,Lesson3Activity.class));
                    }
                });
                break;
            case 3 :
                finalScore = bundle.getInt("finalScore");
                //scoreReport.setText("Your score is : "+finalScore);
                //unlock.setText("Unlock lesson 4");
                unlockls.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SharedPreferences shared = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = shared.edit();
                        editor.putBoolean("ls4_enable",true);
                        editor.commit();
                        startActivity(new Intent(QuizResultActivity.this,Lesson4Activity.class));
                    }
                });
                break;
            case 4 :
                finalScore = bundle.getInt("finalScore");
                //scoreReport.setText("Your score is : "+finalScore);
                //unlock.setText("Unlock lesson 5");
                unlockls.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SharedPreferences shared = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = shared.edit();
                        editor.putBoolean("ls5_enable",true);
                        editor.commit();
                        startActivity(new Intent(QuizResultActivity.this,Lesson5Activity.class));
                    }
                });
                break;
            case 5 :
                finalScore = bundle.getInt("finalScore");
                //scoreReport.setText("Your score is : "+finalScore);
                //unlock.setText("Unlock lesson 6");
                unlockls.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SharedPreferences shared = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = shared.edit();
                        editor.putBoolean("ls6_enable",true);
                        editor.commit();
                        startActivity(new Intent(QuizResultActivity.this,Lesson6Activity.class));
                    }
                });
                break;
            case 6 :
                finalScore = bundle.getInt("finalScore");
                //scoreReport.setText("Your score is : "+finalScore);
                //unlock.setText("Take Exam");
                unlockls.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        SharedPreferences shared = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
//                        SharedPreferences.Editor editor = shared.edit();
//                        editor.putBoolean("ls5_enable",true);
//                        editor.commit();
                        startActivity(new Intent(QuizResultActivity.this,ExamActivity.class));
                    }
                });
                break;

        }



        Button quizResult_back = findViewById(R.id.resultBack);
        quizResult_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizResultActivity.this,TitleActivity.class));
            }
        });
    }
}
