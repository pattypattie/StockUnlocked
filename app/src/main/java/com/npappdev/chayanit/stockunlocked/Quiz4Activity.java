package com.npappdev.chayanit.stockunlocked;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Quiz4Activity extends AppCompatActivity {

    int currentQuiz = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);

        Button backMenu = findViewById(R.id.backMenu);
        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Quiz4Activity.this, TitleActivity.class));
            }
        });

        final Lesson4Quiz1Fragment lesson4Quiz1Fragment = new Lesson4Quiz1Fragment();
        final Lesson4Quiz2Fragment lesson4Quiz2Fragment = new Lesson4Quiz2Fragment();
//
//        currentQuiz = (int)(Math.random()*2);
//        if(currentQuiz==0){
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentl4, lesson4Quiz1Fragment).commit();
            currentQuiz++;
//        } else{
//            getSupportFragmentManager().beginTransaction().add(R.id.fragmentl4, lesson4Quiz2Fragment).commit();
//        }


//        final Button nextQbtn = findViewById(R.id.nextQ);
//        nextQbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if(currentQuiz==1){
//                    getSupportFragmentManager().beginTransaction().remove(lesson4Quiz1Fragment).commit();
//                    getSupportFragmentManager().beginTransaction().add(R.id.fragmentl4, lesson4Quiz2Fragment).commit();
//                    currentQuiz++;
//                }else if (currentQuiz==2){
////                    getSupportFragmentManager().beginTransaction().remove(lesson4Quiz2Fragment).commit();
////                    getSupportFragmentManager().beginTransaction().add(R.id.fragmentl4, lesson4Quiz1Fragment).commit();
//                    Intent i = new Intent(Quiz4Activity.this, QuizResultActivity.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putInt("finalScore", 2);
//                    bundle.putInt("QsNum", 4);
//                    i.putExtras(bundle);
//                    Quiz4Activity.this.finish();
//                    startActivity(i);
//                }
//                //nextQbtn.setEnabled(false);
//            }
//        });


    }
}
