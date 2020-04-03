package com.example.chayanit.stockunlocked;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class ExamActivity extends AppCompatActivity {

    public Button b1, b2, b3, b4, nextQbtn;
    public TextView questionText, scoreText, checkCorrectText, explainText;
    public ImageView questionImage;
    public int random_question = 0;
    public int random_answer_order = 0;

    //keep track of how many questions have been answered
    int questionCounter = 0;

    //keep track of the user's score
    int testScore = 0;

    //track user's current level
    int level = 1;

    //for image
    int resId;

    String[] questionLevel1 = {"Level1_Q1", "Level1_Q2", "Level1_Q3", "Level1_Q4", "Level1_Q5", "Level1_Q6", "Level1_Q7", "Level1_Q8", "Level1_Q9", "Level1_Q10"};
    String[] questionLevel2 = {"Level2_Q1", "Level2_Q2", "Level2_Q3", "Level2_Q4", "Level2_Q5", "Level2_Q6", "Level2_Q7", "Level2_Q8", "Level2_Q9", "Level2_Q10"};
    String[] questionLevel3 = {"Level3_Q1", "Level3_Q2", "Level3_Q3", "Level3_Q4", "Level3_Q5", "Level3_Q6", "Level3_Q7", "Level3_Q8", "Level3_Q9", "Level3_Q10"};
    String[] questionLevel4 = {"Level4_Q1", "Level4_Q2", "Level4_Q3", "Level4_Q4", "Level4_Q5", "Level4_Q6", "Level4_Q7", "Level4_Q8", "Level4_Q9", "Level4_Q10"};

    String[] explainLevel1 = {"explainlvl1_Q1", "explainlvl1_Q2", "explainlvl1_Q3", "explainlvl1_Q4", "explainlvl1_Q5", "explainlvl1_Q6", "explainlvl1_Q7", "explainlvl1_Q8", "explainlvl1_Q9", "explainlvl1_Q10"};
    String[] explainLevel2 = {"explainlvl2_Q1", "explainlvl2_Q2", "explainlvl2_Q3", "explainlvl2_Q4", "explainlvl2_Q5", "explainlvl2_Q6", "explainlvl2_Q7", "explainlvl2_Q8", "explainlvl2_Q9", "explainlvl2_Q10"};
    String[] explainLevel3 = {"explainlvl3_Q1", "explainlvl3_Q2", "explainlvl3_Q3", "explainlvl3_Q4", "explainlvl3_Q5", "explainlvl3_Q6", "explainlvl3_Q7", "explainlvl3_Q8", "explainlvl3_Q9", "explainlvl3_Q10"};
    String[] explainLevel4 = {"explainlvl4_Q1", "explainlvl4_Q2", "explainlvl4_Q3", "explainlvl4_Q4", "explainlvl4_Q5", "explainlvl4_Q6", "explainlvl4_Q7", "explainlvl4_Q8", "explainlvl4_Q9", "explainlvl4_Q10"};

    //image file name if the question needs image
    String[] picLevel1 = {"", "", "", "", "", "", "", "", "", ""};
    String[] picLevel2 = {"", "", "", "", "", "", "", "", "", ""};
    String[] picLevel3 = {"", "", "", "", "", "", "", "", "", ""};
    String[] picLevel4 = {"", "", "", "", "", "", "", "", "", ""};


    //The correct answer is stored in index 0 (a1)
    String[][] answerLevel1 =
            {{"l1q1a1", "l1q1a2", "l1q1a3", "l1q1a4"},
                    {"l1q2a1", "l1q2a2", "l1q2a3", "l1q2a4"},
                    {"l1q3a1", "l1q3a2", "l1q3a3", "l1q3a4"},
                    {"l1q4a1", "l1q4a2", "l1q4a3", "l1q4a4"},
                    {"l1q5a1", "l1q5a2", "l1q5a3", "l1q5a4"},
                    {"l1q6a1", "l1q6a2", "l1q6a3", "l1q6a4"},
                    {"l1q7a1", "l1q7a2", "l1q7a3", "l1q7a4"},
                    {"l1q8a1", "l1q8a2", "l1q8a3", "l1q8a4"},
                    {"l1q9a1", "l1q9a2", "l1q9a3", "l1q9a4"},
                    {"l1q10a1", "l1q10a2", "l1q10a3", "l1q10a4"}};

    String[][] answerLevel2 =
            {{"l2q1a1", "l2q1a2", "l2q1a3", "l2q1a4"},
                    {"l2q2a1", "l2q2a2", "l2q2a3", "l2q2a4"},
                    {"l2q3a1", "l2q3a2", "l2q3a3", "l2q3a4"},
                    {"l2q4a1", "l2q4a2", "l2q4a3", "l2q4a4"},
                    {"l2q5a1", "l2q5a2", "l2q5a3", "l2q5a4"},
                    {"l2q6a1", "l2q6a2", "l2q6a3", "l2q6a4"},
                    {"l2q7a1", "l2q7a2", "l2q7a3", "l2q7a4"},
                    {"l2q8a1", "l2q8a2", "l2q8a3", "l2q8a4"},
                    {"l2q9a1", "l2q9a2", "l2q9a3", "l2q9a4"},
                    {"l2q10a1", "l2q10a2", "l2q10a3", "l2q10a4"}};

    String[][] answerLevel3 =
            {{"l3q1a1", "l3q1a2", "l3q1a3", "l3q1a4"},
                    {"l3q2a1", "l3q2a2", "l3q2a3", "l3q2a4"},
                    {"l3q3a1", "l3q3a2", "l3q3a3", "l3q3a4"},
                    {"l3q4a1", "l3q4a2", "l3q4a3", "l3q4a4"},
                    {"l3q5a1", "l3q5a2", "l3q5a3", "l3q5a4"},
                    {"l3q6a1", "l3q6a2", "l3q6a3", "l3q6a4"},
                    {"l3q7a1", "l3q7a2", "l3q7a3", "l3q7a4"},
                    {"l3q8a1", "l3q8a2", "l3q8a3", "l3q8a4"},
                    {"l3q9a1", "l3q9a2", "l3q9a3", "l3q9a4"},
                    {"l3q10a1", "l3q10a2", "l3q10a3", "l3q10a4"}};

    String[][] answerLevel4 =
            {{"l4q1a1", "l4q1a2", "l4q1a3", "l4q1a4"},
                    {"l4q2a1", "l4q2a2", "l4q2a3", "l4q2a4"},
                    {"l4q3a1", "l4q3a2", "l4q3a3", "l4q3a4"},
                    {"l4q4a1", "l4q4a2", "l4q4a3", "l4q4a4"},
                    {"l4q5a1", "l4q5a2", "l4q5a3", "l4q5a4"},
                    {"l4q6a1", "l4q6a2", "l4q6a3", "l4q6a4"},
                    {"l4q7a1", "l4q7a2", "l4q7a3", "l4q7a4"},
                    {"l4q8a1", "l4q8a2", "l4q8a3", "l4q8a4"},
                    {"l4q9a1", "l4q9a2", "l4q9a3", "l4q9a4"},
                    {"l4q10a1", "l4q10a2", "l4q10a3", "l4q10a4"}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        questionText = findViewById(R.id.textView2);
        Button btn_none = findViewById(R.id.buttonnone);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        scoreText = findViewById(R.id.score);
        questionImage = findViewById(R.id.imageView70);
        explainText = findViewById(R.id.examExplainText);
        nextQbtn = findViewById(R.id.nextExam);
        checkCorrectText = findViewById(R.id.correctText);

        btn_none.setVisibility(View.INVISIBLE);
        nextQbtn.setEnabled(false);

        createNewQuestion(1);

        nextQbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questionCounter!=10){ //limit to 10 questions per one exam
                    createNewQuestion(level);
                    nextQbtn.setEnabled(false);
                }else{
                    //startActivity(new Intent(ExamActivity.this,ExamResultActivity.class));
                    Intent intent = new Intent(ExamActivity.this,ExamResultActivity.class);
                    intent.putExtra("finalScore", testScore+"");
                    startActivity(intent);
                }
            }
        });

        ImageButton exam_back = findViewById(R.id.examback);
        exam_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExamActivity.this,TitleActivity.class));
            }
        });

    }

    public static int getResourceByFilename(Context context, String filename) {
        return context.getResources().getIdentifier(filename, "drawable", context.getPackageName());
    }

    public void createNewQuestion(int level){

        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);

        if(level==1){
            setAnswerText(answerLevel1, questionLevel1, picLevel1, explainLevel1);
        }
        else if(level==2){
            setAnswerText(answerLevel2, questionLevel2, picLevel2, explainLevel2);
        }
        else if(level==3){
            setAnswerText(answerLevel3, questionLevel3, picLevel3, explainLevel3);
        }
        else if(level==4){
            setAnswerText(answerLevel4, questionLevel4, picLevel4, explainLevel4);
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAnswer(1);
            }});
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAnswer(2);
            }});
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAnswer(3);
            }});
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAnswer(4);
            }});

    }

    public void setAnswerText(String[][] ansString, String[] quesString, String[] picString, String[] explainString){

        do{
            random_question = (int)(Math.random()*quesString.length);
        }
        while(quesString[random_question]=="");

        random_answer_order = (int)((Math.random()*4)+1);

        questionText.setText(""+ quesString[random_question]);
        if(random_answer_order==1) {
            b1.setText(""+ansString[random_question][0]);
            b2.setText("" + ansString[random_question][1]);
            b3.setText("" + ansString[random_question][2]);
            b4.setText("" + ansString[random_question][3]);
        }
        else if(random_answer_order==2){
            b2.setText(""+ansString[random_question][0]);
            b3.setText("" + ansString[random_question][1]);
            b4.setText("" + ansString[random_question][2]);
            b1.setText("" + ansString[random_question][3]);
        }
        else if(random_answer_order==3){
            b3.setText(""+ansString[random_question][0]);
            b4.setText("" + ansString[random_question][1]);
            b1.setText("" + ansString[random_question][2]);
            b2.setText("" + ansString[random_question][3]);
        }
        else if(random_answer_order==4){
            b4.setText(""+ansString[random_question][0]);
            b1.setText("" + ansString[random_question][1]);
            b2.setText("" + ansString[random_question][2]);
            b3.setText("" + ansString[random_question][3]);
        }

        explainText.setText(explainString[random_question]);
        explainText.setVisibility(View.GONE);
        checkCorrectText.setVisibility(View.INVISIBLE);

        //if the question has image, show it. else don't
        if(picString[random_question]!=""){
            resId = this.getResources().getIdentifier(picString[random_question], "drawable", this.getPackageName());
            questionImage.setImageResource(resId);
            questionImage.setVisibility(View.VISIBLE);
        } else{
            questionImage.setVisibility(View.GONE);
        }

        //remove duplicate
        quesString[random_question] = "";
        picString[random_question] = "";
        explainString[random_question] = "";

    }

    public void clickAnswer(int btn_number){
        if(btn_number==random_answer_order){ //if the answer is correct, increase one level
            testScore+=level; //as level gets higher, the score is higher
            level++;
            checkCorrectText.setText("Correct!");
            if(level>4){
                level = 4; //the highest level is 4
            }
        }
        else{ //if the answer is incorrect, decrease one level
            level--;
            checkCorrectText.setText("Incorrect");
            if(level<1){
                level = 1; //the lowest level is 1
            }
        }
        explainText.setVisibility(View.VISIBLE);
        checkCorrectText.setVisibility(View.VISIBLE);
        scoreText.setText("Score : "+testScore);
        questionCounter++;
        nextQbtn.setEnabled(true);
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);

    }
}
