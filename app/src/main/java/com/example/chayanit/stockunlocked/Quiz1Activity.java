package com.example.chayanit.stockunlocked;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


public class Quiz1Activity extends AppCompatActivity {



    private Quiz1Library mQuestionLibrary = new Quiz1Library();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    int count = 0;
    //int question [];
    //int i = 0;
    List<Integer> question = new ArrayList<Integer>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);


        //randomQs();
       // mQuestionNumber = (int)question.get(count);


        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);

        updateQuestion();

        //Start of Button Listener for Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice1.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    Toast.makeText(Quiz1Activity.this, "correct", Toast.LENGTH_SHORT).show();

                    if (mQuestionNumber == 3) {
                        Intent i = new Intent(Quiz1Activity.this, QuizResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("QsNum", 1);
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        Quiz1Activity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }

                    //updateQuestion();
                    //This line of code is optiona
                    //Toast.makeText(Quiz1Activity.this, "correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(Quiz1Activity.this, "wrong", Toast.LENGTH_SHORT).show();
                    if (mQuestionNumber == 3) {
                        Intent i = new Intent(Quiz1Activity.this, QuizResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("QsNum", 1);
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        Quiz1Activity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                    //updateQuestion();
                }
            }
        });

        //End of Button Listener for Button1

        //Start of Button Listener for Button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice2.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    Toast.makeText(Quiz1Activity.this, "correct", Toast.LENGTH_SHORT).show();
                    if (mQuestionNumber == 3) {
                        Intent i = new Intent(Quiz1Activity.this, QuizResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        bundle.putInt("QsNum", 1);
                        i.putExtras(bundle);
                        Quiz1Activity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }

                }else {
                    Toast.makeText(Quiz1Activity.this, "wrong", Toast.LENGTH_SHORT).show();
                    if (mQuestionNumber == 3) {
                        Intent i = new Intent(Quiz1Activity.this, QuizResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        bundle.putInt("QsNum", 1);
                        i.putExtras(bundle);
                        Quiz1Activity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });

        //End of Button Listener for Button2


        //Start of Button Listener for Button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice3.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    //This line of code is optiona
                    Toast.makeText(Quiz1Activity.this, "correct", Toast.LENGTH_SHORT).show();
                    if (mQuestionNumber == 3) {
                        Intent i = new Intent(Quiz1Activity.this, QuizResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        bundle.putInt("QsNum", 1);
                        i.putExtras(bundle);
                        Quiz1Activity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }


                }else {
                    Toast.makeText(Quiz1Activity.this, "wrong", Toast.LENGTH_SHORT).show();
                    if (mQuestionNumber == 3) {
                        Intent i = new Intent(Quiz1Activity.this, QuizResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        bundle.putInt("QsNum", 1);
                        i.putExtras(bundle);
                        Quiz1Activity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });


        ImageButton lesson1_back = findViewById(R.id.Quiz1back);
        lesson1_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Quiz1Activity.this,QuizActivity.class));

            }
        });
        Button unlockls2_bt = findViewById(R.id.unlockls2);
        unlockls2_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences shared = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putBoolean("ls2_enable",true);
                editor.commit();
                startActivity(new Intent(Quiz1Activity.this,Lesson2Activity.class));
            }});
    }


    private void updateQuestion(){
        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));

        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
        mQuestionNumber++;
        //mQuestionNumber = (int) izy.next();

    }


    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }

//    public void randomQs(){
//        HashSet hs = new HashSet();
//        while(hs.size()<mQuestionLibrary.mQuestions.length){
//
//            int num=(int)(Math.random()*100);
//
//            hs.add(num);
//
//        }
//        Iterator izy = hs.iterator();
//
//        //mQuestionNumber = (int) izy.next();
//        for (int i =0; i< mQuestionLibrary.mQuestions.length;i++){
//                question.add((int)izy.next());
//
//        }
////        while (izy.hasNext()){
////            question.add((int)izy.next());
////        }
//    }

}
