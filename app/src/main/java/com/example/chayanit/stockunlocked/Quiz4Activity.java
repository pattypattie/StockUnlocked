package com.example.chayanit.stockunlocked;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Quiz4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);

        final Lesson4Quiz1Fragment lesson4Quiz1Fragment = new Lesson4Quiz1Fragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentl4, lesson4Quiz1Fragment).commit();

        Button backMenu = findViewById(R.id.backMenu);
        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Quiz4Activity.this, TitleActivity.class));
            }
        });


    }
}
