package com.npappdev.chayanit.stockunlocked;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Lesson2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2);

        final TextView accountInfo = findViewById(R.id.textView3);
        final TextView accountInfoDetail = findViewById(R.id.textView14);

        Button unlockls3_bt = findViewById(R.id.unlockls3);
        Button take_quiz2 = findViewById(R.id.takequiz2);


        unlockls3_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences shared = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putBoolean("ls3_enable",true);
                editor.putBoolean("qz2_enable",true);
                editor.commit();
                startActivity(new Intent(Lesson2Activity.this,Lesson3Activity.class));

            }});

        take_quiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences shared = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putBoolean("qz2_enable",true);
                editor.putBoolean("ls3_enable",true);
                editor.commit();
                startActivity(new Intent(Lesson2Activity.this,Quiz2Activity.class));

            }
        });

        ImageButton lesson2_back = findViewById(R.id.lesson2back);
        lesson2_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lesson2Activity.this,LessonActivity.class));
            }
        });

        Button bookbank1 = findViewById(R.id.buttonBank1);
        bookbank1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accountInfo.setText("Cash Account");
                accountInfoDetail.setText("- Requires a cash/stock collateral deposit of 20% of your approved credit limit\n" +
                        "- Cash will be settled in the 2 business day (T+2) after the trading date (T)");
            }
        });

        Button bookbank2 = findViewById(R.id.buttonBank2);
        bookbank2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accountInfo.setText("Cash Balance");
                accountInfoDetail.setText("- Requires a 100% cash collateral deposit to your stock trading account, in which all cash outstanding can be traded");
            }
        });

        Button bookbank3 = findViewById(R.id.buttonBank3);
        bookbank3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accountInfo.setText("Credit Balance Account/Margin Account");
                accountInfoDetail.setText("- Investors are allowed to borrow funds from the broker to purchase stocks");
            }
        });

    }

}
