package com.example.chayanit.stockunlocked;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lesson5QsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson5_qs);

        Bundle bundle = getIntent().getExtras();
        int QsNum = bundle.getInt("QsNum");

        Button backMenu = findViewById(R.id.backMenu);
        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lesson5QsActivity.this, TitleActivity.class));
            }
        });

        Button spinAg = findViewById(R.id.btn_spin);
        spinAg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lesson5QsActivity.this, Quiz5Activity.class));
            }
        });

        final Lesson5Qs1Fragment Lesson5Qs1Fragment = new Lesson5Qs1Fragment();
        final Lesson5Qs2Fragment Lesson5Qs2Fragment = new Lesson5Qs2Fragment();
        final Lesson5Qs3Fragment Lesson5Qs3Fragment = new Lesson5Qs3Fragment();
        final Lesson5Qs4Fragment Lesson5Qs4Fragment = new Lesson5Qs4Fragment();
        //final Lesson5Qs5Fragment Lesson5Qs5Fragment = new Lesson5Qs5Fragment();


        switch (QsNum) {
            case 1: getSupportFragmentManager().beginTransaction().add(R.id.fragmentl5, Lesson5Qs1Fragment).commit(); break;
            case 2: getSupportFragmentManager().beginTransaction().add(R.id.fragmentl5, Lesson5Qs2Fragment).commit(); break;
            case 3: getSupportFragmentManager().beginTransaction().add(R.id.fragmentl5, Lesson5Qs3Fragment).commit(); break;
            case 4: getSupportFragmentManager().beginTransaction().add(R.id.fragmentl5, Lesson5Qs4Fragment).commit(); break;
            //case 5: getSupportFragmentManager().beginTransaction().add(R.id.fragmentl5, Lesson5Qs5Fragment).commit(); break;


        }
        //getSupportFragmentManager().beginTransaction().add(R.id.fragmentl5, Lesson5Qs1Fragment).commit();

                    //getSupportFragmentManager().beginTransaction().remove(Lesson5Qs1Fragment).commit();
                   // getSupportFragmentManager().beginTransaction().add(R.id.fragmentl5, lesson3Quiz2Fragment).commit();
                    //currentQuiz = 2;
//                    getSupportFragmentManager().beginTransaction().remove(lesson3Quiz2Fragment).commit();
//                    getSupportFragmentManager().beginTransaction().add(R.id.fragmentl3, lesson3Quiz3Fragment).commit();





    }
}
