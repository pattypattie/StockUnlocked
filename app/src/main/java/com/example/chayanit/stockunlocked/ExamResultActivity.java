package com.example.chayanit.stockunlocked;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExamResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_result);

        Button examResult_back = findViewById(R.id.resultBack);
        TextView scoreReport = findViewById(R.id.textView33);
        Intent intent = getIntent();
        String finalScore = intent.getStringExtra("finalScore");
        scoreReport.setText("Your score is : "+finalScore);

        examResult_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExamResultActivity.this,TitleActivity.class));
            }
        });
    }
}
