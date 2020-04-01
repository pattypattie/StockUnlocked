package com.example.chayanit.stockunlocked;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Quiz5Activity extends AppCompatActivity {

    Button button;
    TextView textView;
    ImageView wheelRoul;

    Random r;
    int degree = 0, degree_old = 0;
    //his was 37 but i had an extra zero
    //becau[se there is 38 sectors on the wheel (9.47 degrees each)
    //private static final float FACTOR = 4.7368f;
    private static final float FACTOR = 45f;
    int qsno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz5);

        final Button enterqs = findViewById(R.id.btn_qs);
        enterqs.setEnabled(false);
        enterqs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Quiz5Activity.this, Lesson5QsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("QsNum", qsno);
                //bundle.putInt("finalScore", mScore);
                i.putExtras(bundle);
                Quiz5Activity.this.finish();
                startActivity(i);
                //startActivity(new Intent(Quiz5Activity.this, Lesson5QsActivity.class));
            }
        });

        Button backMenu = findViewById(R.id.backMenu);
        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Quiz5Activity.this, TitleActivity.class));
            }
        });


        button = (Button) findViewById(R.id.btn_spin);
        textView = (TextView) findViewById(R.id.textView);
        wheelRoul = (ImageView) findViewById(R.id.imRoulette);

        r = new Random();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                degree_old = degree % 360;
                degree = r.nextInt(360) + 720;
                RotateAnimation rotate = new RotateAnimation(degree_old, degree,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(3600);
                rotate.setFillAfter(true);
                rotate.setInterpolator(new DecelerateInterpolator());
                rotate.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {
                        textView.setText("");
                        enterqs.setEnabled(false);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        textView.setText(currentNumber(360 - (degree % 360)));
                        enterqs.setEnabled(true);
                        //Toast.makeText(Quiz5Activity.this, degree, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                wheelRoul.startAnimation(rotate);
            }
        });
    }
    private String currentNumber(int degrees) {
        String text = "";
        if (degrees >= (FACTOR * 1) && degrees < (FACTOR * 2)){
            text = "Question 1";
            qsno = 4;
        }
        if (degrees >= (FACTOR * 2) && degrees < (FACTOR * 3)){
            text = "Question 2";
            qsno =4;
        }
        if (degrees >= (FACTOR * 3) && degrees < (FACTOR * 4)){
            text = "Question 3";
            qsno =4;
        }
        if (degrees >= (FACTOR * 4) && degrees < (FACTOR * 5)){
            text = "Question 4";
            qsno =4;
        }
        if (degrees >= (FACTOR * 5) && degrees < (FACTOR * 6)){
            text = "Question 2";
            qsno =4;
        }
        if (degrees >= (FACTOR * 6) && degrees < (FACTOR * 7)){
            qsno = 4;
            text = "Question 3";
        }
        if (degrees >= (FACTOR * 7) && degrees < (FACTOR * 8)){
            qsno = 4;
            text = "Question 1";
        }
        if (degrees <= (FACTOR * 1)){
            qsno = 4;
            text = "Question 4";
        }

        return text;

    }
}
