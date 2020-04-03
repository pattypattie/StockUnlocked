package com.example.chayanit.stockunlocked;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpecialQuizActivity extends AppCompatActivity {

    TextView instructionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_quiz);

        Button backMenu = findViewById(R.id.backMenu);
        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SpecialQuizActivity.this, TitleActivity.class));
            }
        });

        instructionText = findViewById(R.id.instructionqspecial);
        instructionText.setText(Html.fromHtml("<h1>How much can you get?</h1>"));
    }
}
