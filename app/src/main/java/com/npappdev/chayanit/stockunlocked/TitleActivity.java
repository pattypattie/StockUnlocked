package com.npappdev.chayanit.stockunlocked;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TitleActivity extends AppCompatActivity {

    //private static int SPLASH_TIME_OUT = 4500;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        Button lesson_bt = findViewById(R.id.lesson_bt);
        Button quiz_bt = findViewById(R.id.quiz_bt);
        Button exam_bt = findViewById(R.id.exam_bt);
        Button setting_bt = findViewById(R.id.setting);

        lesson_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TitleActivity.this,LessonActivity.class));
            }
        });

        quiz_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TitleActivity.this,QuizActivity.class));
            }
        });

        exam_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TitleActivity.this,ExamActivity.class));
            }
        });
        setting_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TitleActivity.this, SettingActivity.class));
            }
        });

//        final ImageButton imgbut = findViewById(R.id.imgbut);
//        imgbut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                buttonEffect(imgbut);
//                startActivity(new Intent(TitleActivity.this, SettingActivity.class));
//            }
//        });


//        new Handler().postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                Intent i=new Intent(TitleActivity.this,WelcomeActivity.class);//Start Another Activity
//                startActivity(i);
//                finish();
//            }
//        },SPLASH_TIME_OUT);

    }
//    public static void buttonEffect(View button){
//        button.setOnTouchListener(new View.OnTouchListener() {
//
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN: {
//                        v.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
//                        v.invalidate();
//                        break;
//                    }
//                    case MotionEvent.ACTION_UP: {
//                        v.getBackground().clearColorFilter();
//                        v.invalidate();
//                        break;
//                    }
//                }
//                return false;
//            }
//        });
//    }
}
