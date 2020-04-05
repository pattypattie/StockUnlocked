package com.example.chayanit.stockunlocked;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

public class Quiz6Activity extends AppCompatActivity {

    int randomFragment;
    ArrayList<Fragment> fragments;
    Button nextQbtn;
    Fragment lesson6Quiz1Fragment, lesson6Quiz2Fragment, lesson6Quiz3Fragment, currentFragment;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz6);

        nextQbtn = findViewById(R.id.nextQ);
        Button backMenu = findViewById(R.id.backMenu);
        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Quiz6Activity.this, TitleActivity.class));
            }
        });

        lesson6Quiz1Fragment = new Lesson6Quiz1Fragment();
        lesson6Quiz2Fragment = new Lesson6Quiz2Fragment();
        lesson6Quiz3Fragment = new Lesson6Quiz3Fragment();

        randomFragment = -1;
        fragments = new ArrayList<Fragment>(3);
        fragments.addAll(Arrays.asList(lesson6Quiz1Fragment, lesson6Quiz2Fragment, lesson6Quiz3Fragment));

        randomPart();

        nextQbtn = findViewById(R.id.nextQ);
        nextQbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                randomPart();
            }
        });

    }

    public void randomPart() {

        if (count == 3) {
            Intent i = new Intent(Quiz6Activity.this, QuizResultActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("finalScore", 2);
            bundle.putInt("QsNum", 6);
            i.putExtras(bundle);
            Quiz6Activity.this.finish();
            startActivity(i);
        } else {

            if (randomFragment != -1) {
                fragments.remove(currentFragment);
                fragments.trimToSize();
            } else {
                currentFragment = lesson6Quiz1Fragment;
            }

            if (fragments.size() != 0) {
                randomFragment = (int) (Math.random() * fragments.size());
                getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
                currentFragment = fragments.get(randomFragment);
                getSupportFragmentManager().beginTransaction().add(R.id.fragmentl6, currentFragment).commit();
            }
            if (fragments.size() == 1) {
                //nextQbtn.setEnabled(false);
            }
        }
        count++;
    }
}
