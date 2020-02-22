package com.example.chayanit.stockunlocked;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Lesson2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2);

        final TextView accountInfo = findViewById(R.id.textView3);

        Button unlockls3_bt = findViewById(R.id.unlockls3);
        Button take_quiz2 = findViewById(R.id.takequiz2);


        unlockls3_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences shared = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putBoolean("ls3_enable",true);
                editor.commit();
                startActivity(new Intent(Lesson2Activity.this,Lesson3Activity.class));

            }});

        take_quiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences shared = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putBoolean("qz2_enable",true);
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


        RadioGroup rGroup = (RadioGroup)findViewById(R.id.radiogroupaccount);
        RadioButton checkedRadioButton = (RadioButton)rGroup.findViewById(rGroup.getCheckedRadioButtonId());

        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId) {
                    case -1:
                        break;
                    case R.id.account1:
                        accountInfo.setText("Cash Account");
                        break;
                    case R.id.account2:
                        accountInfo.setText("Cash Balance");
                        break;
                    case R.id.account3:
                        accountInfo.setText("Credit Balance Account");
                        break;
                }
            }
        });

    }

}
