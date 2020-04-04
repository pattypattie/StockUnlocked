package com.example.chayanit.stockunlocked;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpecialQuizActivity extends AppCompatActivity {

    TextView nameText, instructionText;
    Button letsgobtn;

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

        nameText = findViewById(R.id.namespecial);
        nameText.setText(Html.fromHtml("<h1>How much can you get?</h1>"));
        instructionText = findViewById(R.id.instructionspecial);
        instructionText.setText(Html.fromHtml("&emsp Welcome to the trading simulation game! Now you have <b>$500</b> and <b>100 stocks</b> of HappyStock company. You will be given some scenarios, and you have to choose your action. Let's see how much you'll have at the end. "));
        letsgobtn = findViewById(R.id.letsgo);
        letsgobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letsgobtn.setVisibility(View.GONE);
                nameText.setVisibility(View.GONE);
                instructionText.setVisibility(View.GONE);
            }
        });
    }
}
