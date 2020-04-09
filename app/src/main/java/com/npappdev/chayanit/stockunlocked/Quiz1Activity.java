package com.npappdev.chayanit.stockunlocked;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.Arrays;
import java.util.Collections;


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

    Integer[] arr = new Integer[mQuestionLibrary.mQuestions.length];
    String explain;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        Collections.shuffle(Arrays.asList(arr));

        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        final TextView result = (TextView)findViewById(R.id.result);
        final Button nextQs = findViewById(R.id.nextQs);
        Button backMenu = findViewById(R.id.backMenu);
        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Quiz1Activity.this, TitleActivity.class));
            }
        });

        mScoreView.setVisibility(View.INVISIBLE);

        updateQuestion();

        nextQs.setVisibility(View.INVISIBLE);
        nextQs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateQuestion();
                result.setText("");
                nextQs.setVisibility(View.INVISIBLE);
                //startActivity(new Intent(Quiz1Activity.this, TitleActivity.class));
            }
        });

        //Start of Button Listener for Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice1.getText() == mAnswer){
                    mScore = mScore + 1;
                    //updateScore(mScore);
                    //mButtonChoice2.setVisibility(View.GONE);
                    //mButtonChoice3.setVisibility(View.GONE);
                    mButtonChoice2.setBackgroundColor(Color.GRAY);
                    mButtonChoice3.setBackgroundColor(Color.GRAY);
                    mButtonChoice1.setBackgroundColor(Color.parseColor("#66a103"));
                    mButtonChoice1.setEnabled(false);
                    mButtonChoice2.setEnabled(false);
                    mButtonChoice3.setEnabled(false);

                    //Toast.makeText(Quiz1Activity.this, "correct", Toast.LENGTH_SHORT).show();

                    if (count == 3) {
                        result.setText("Correct!\n"+explain);
                        nextQs.setVisibility(View.VISIBLE);
                        //nextQs.setText("Result");
                        nextQs.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startResult();
                            }
                        });
//                        Intent i = new Intent(Quiz1Activity.this, QuizResultActivity.class);
//                        Bundle bundle = new Bundle();
//                        bundle.putInt("QsNum", 1);
//                        bundle.putInt("finalScore", mScore);
//                        i.putExtras(bundle);
//                        Quiz1Activity.this.finish();
//                        startActivity(i);
                    } else {
//                        mButtonChoice1.setVisibility(View.GONE);
//                        mButtonChoice2.setVisibility(View.GONE);
//                        mButtonChoice3.setVisibility(View.GONE);
                        result.setText("Correct!\n"+explain);
                        nextQs.setVisibility(View.VISIBLE);
//                        updateQuestion();

                    }


                } else {
//                    //Toast.makeText(Quiz1Activity.this, "wrong", Toast.LENGTH_SHORT).show();
//                    if (count == 3) {
////                        Intent i = new Intent(Quiz1Activity.this, QuizResultActivity.class);
////                        Bundle bundle = new Bundle();
////                        bundle.putInt("QsNum", 1);
////                        bundle.putInt("finalScore", mScore);
////                        i.putExtras(bundle);
////                        Quiz1Activity.this.finish();
////                        startActivity(i);
//                    } else {
                        result.setText("Incorrect Try again!");
                        //updateQuestion();
                    //}
                }
            }
        });

        mButtonChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice3.getText() == mAnswer){
                    mScore = mScore + 1;
                    //updateScore(mScore);
//                    mButtonChoice1.setVisibility(View.GONE);
//                    mButtonChoice2.setVisibility(View.GONE);
//                    mButtonChoice3.setEnabled(false);
                    mButtonChoice1.setBackgroundColor(Color.GRAY);
                    mButtonChoice2.setBackgroundColor(Color.GRAY);
                    mButtonChoice3.setBackgroundColor(Color.parseColor("#66a103"));
                    mButtonChoice1.setEnabled(false);
                    mButtonChoice2.setEnabled(false);
                    mButtonChoice3.setEnabled(false);

                    //Toast.makeText(Quiz1Activity.this, "correct", Toast.LENGTH_SHORT).show();

                    if (count == 3) {
                        result.setText("Correct!\n"+explain);
                        nextQs.setVisibility(View.VISIBLE);
                        //nextQs.setText("Result");
                        nextQs.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startResult();
                            }
                        });
//                        Intent i = new Intent(Quiz1Activity.this, QuizResultActivity.class);
//                        Bundle bundle = new Bundle();
//                        bundle.putInt("QsNum", 1);
//                        bundle.putInt("finalScore", mScore);
//                        i.putExtras(bundle);
//                        Quiz1Activity.this.finish();
//                        startActivity(i);
                    } else {
//                        mButtonChoice1.setVisibility(View.GONE);
//                        mButtonChoice2.setVisibility(View.GONE);
//                        mButtonChoice3.setVisibility(View.GONE);
                        result.setText("Correct!\n"+explain);
                        nextQs.setVisibility(View.VISIBLE);
//                        updateQuestion();

                    }


                }else {
//                    //Toast.makeText(Quiz1Activity.this, "wrong", Toast.LENGTH_SHORT).show();
//                    if (count == 3) {
////                        Intent i = new Intent(Quiz1Activity.this, QuizResultActivity.class);
////                        Bundle bundle = new Bundle();
////                        bundle.putInt("QsNum", 1);
////                        bundle.putInt("finalScore", mScore);
////                        i.putExtras(bundle);
////                        Quiz1Activity.this.finish();
////                        startActivity(i);
//                    } else {
                        result.setText("Incorrect Try again!");
                        //updateQuestion();
                   // }
                }
            }
        });
        mButtonChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice2.getText() == mAnswer){
                    mScore = mScore + 1;
                    //updateScore(mScore);
//                    mButtonChoice1.setVisibility(View.GONE);
//                    mButtonChoice3.setVisibility(View.GONE);
//                    mButtonChoice2.setEnabled(false);
                    mButtonChoice1.setBackgroundColor(Color.GRAY);
                    mButtonChoice3.setBackgroundColor(Color.GRAY);
                    mButtonChoice2.setBackgroundColor(Color.parseColor("#66a103"));
                    mButtonChoice1.setEnabled(false);
                    mButtonChoice2.setEnabled(false);
                    mButtonChoice3.setEnabled(false);
                    //Toast.makeText(Quiz1Activity.this, "correct", Toast.LENGTH_SHORT).show();

                    if (count == 3) {
                        result.setText("Correct!\n"+explain);
                        nextQs.setVisibility(View.VISIBLE);
                        //nextQs.setText("Result");
                        nextQs.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startResult();
                            }
                        });
//                        Intent i = new Intent(Quiz1Activity.this, QuizResultActivity.class);
//                        Bundle bundle = new Bundle();
//                        bundle.putInt("QsNum", 1);
//                        bundle.putInt("finalScore", mScore);
//                        i.putExtras(bundle);
//                        Quiz1Activity.this.finish();
//                        startActivity(i);
                    } else {
//                        mButtonChoice1.setVisibility(View.GONE);
//                        mButtonChoice2.setVisibility(View.GONE);
//                        mButtonChoice3.setVisibility(View.GONE);
                        result.setText("Correct!\n"+explain);
                        nextQs.setVisibility(View.VISIBLE);
//                        updateQuestion();

                    }


                }else {
                    //Toast.makeText(Quiz1Activity.this, "wrong", Toast.LENGTH_SHORT).show();
//                    if (count == 3) {
////                        Intent i = new Intent(Quiz1Activity.this, QuizResultActivity.class);
////                        Bundle bundle = new Bundle();
////                        bundle.putInt("QsNum", 1);
////                        bundle.putInt("finalScore", mScore);
////                        i.putExtras(bundle);
////                        Quiz1Activity.this.finish();
////                        startActivity(i);
//                    } else {
                        result.setText("Incorrect Try again!");
                        //updateQuestion();
                   // }
                }
            }
        });

        //End of Button Listener for Button1

        //Start of Button Listener for Button2
//        mButtonChoice2.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                //My logic for Button goes in here
//
//                if (mButtonChoice2.getText() == mAnswer){
//                    mScore = mScore + 1;
//                    updateScore(mScore);
//                    Toast.makeText(Quiz1Activity.this, "correct", Toast.LENGTH_SHORT).show();
//                    if (count == 3) {
////                        Intent i = new Intent(Quiz1Activity.this, QuizResultActivity.class);
////                        Bundle bundle = new Bundle();
////                        bundle.putInt("finalScore", mScore);
////                        bundle.putInt("QsNum", 1);
////                        i.putExtras(bundle);
////                        Quiz1Activity.this.finish();
////                        startActivity(i);
//                    } else {
//                        updateQuestion();
//                    }
//
//                }else {
//                    Toast.makeText(Quiz1Activity.this, "wrong", Toast.LENGTH_SHORT).show();
//                    if (count == 3) {
////                        Intent i = new Intent(Quiz1Activity.this, QuizResultActivity.class);
////                        Bundle bundle = new Bundle();
////                        bundle.putInt("finalScore", mScore);
////                        bundle.putInt("QsNum", 1);
////                        i.putExtras(bundle);
////                        Quiz1Activity.this.finish();
////                        startActivity(i);
//                    } else {
//                        result.setText("Incorrect Try again!");
////                        updateQuestion();
//                    }
//                }
//            }
//        });
//
//        //End of Button Listener for Button2
//
//
//        //Start of Button Listener for Button3
//        mButtonChoice3.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                //My logic for Button goes in here
//
//                if (mButtonChoice3.getText() == mAnswer){
//                    mScore = mScore + 1;
//                    updateScore(mScore);
//                    //This line of code is optiona
//                    Toast.makeText(Quiz1Activity.this, "correct", Toast.LENGTH_SHORT).show();
//                    if (count == 3) {
////                        Intent i = new Intent(Quiz1Activity.this, QuizResultActivity.class);
////                        Bundle bundle = new Bundle();
////                        bundle.putInt("finalScore", mScore);
////                        bundle.putInt("QsNum", 1);
////                        i.putExtras(bundle);
////                        Quiz1Activity.this.finish();
//                        //startActivity(i);
//                    } else {
//                        updateQuestion();
//                    }
//
//
//                }else {
//                    Toast.makeText(Quiz1Activity.this, "wrong", Toast.LENGTH_SHORT).show();
//                    if (count == 3) {
////                        Intent i = new Intent(Quiz1Activity.this, QuizResultActivity.class);
////                        Bundle bundle = new Bundle();
////                        bundle.putInt("finalScore", mScore);
////                        bundle.putInt("QsNum", 1);
////                        i.putExtras(bundle);
////                        Quiz1Activity.this.finish();
////                        startActivity(i);
//                    } else {
//                        result.setText("Incorrect Try again!");
////                        updateQuestion();
//                    }
//                }
//            }
//        });



    }


    private void updateQuestion(){
        mButtonChoice1.setVisibility(View.VISIBLE);
        mButtonChoice2.setVisibility(View.VISIBLE);
        mButtonChoice3.setVisibility(View.VISIBLE);
        mButtonChoice1.setEnabled(true);
        mButtonChoice2.setEnabled(true);
        mButtonChoice3.setEnabled(true);
        mQuestionNumber = arr[count];
        mButtonChoice1.setBackgroundColor(Color.parseColor("#0091EA"));
        mButtonChoice2.setBackgroundColor(Color.parseColor("#0091EA"));
        mButtonChoice3.setBackgroundColor(Color.parseColor("#0091EA"));
        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));


        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
        explain = mQuestionLibrary.ls1getResult(mQuestionNumber);

        count++;

    }

    public void startResult(){
        Intent i = new Intent(Quiz1Activity.this, QuizResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("finalScore", mScore);
        bundle.putInt("QsNum", 1);
        i.putExtras(bundle);
        Quiz1Activity.this.finish();
        startActivity(i);
    }

    //Set<Integer> set = new LinkedHashSet<Integer>();

//    private void updateScore(int point) {
//        mScoreView.setText("" + mScore);
//    }


}
