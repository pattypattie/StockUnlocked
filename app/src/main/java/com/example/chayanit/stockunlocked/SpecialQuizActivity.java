package com.example.chayanit.stockunlocked;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SpecialQuizActivity extends AppCompatActivity {

    TextView nameText, instructionText, scenarioText, explainText, finalText, amountSelectText, actionText;
    Button letsgobtn, submitbtn, nextbtn;
    ImageButton plusbtn, minusbtn;
    LinearLayout amountArea;
    RadioGroup radioGroup;
    RadioButton selectedRadioButton;

    String selectedActionText;

    String[] scenario = {"scene1", "scene2", "scene3"};
    String[] explanation = {"explain1", "explain2", "explain3"};
    int[] unitPriceSell = {10,10,10};
    int[] unitPriceBuy = {20,20,20};

    int currentAmountSelected = 0;
    int currentStockHave = 1000;
    int currentCashHave = 1000;

    int currentScene = 0;

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
        instructionText.setText(Html.fromHtml("&emsp Welcome to the trading simulation game! Now you have <b>$1000</b> and <b>1000 stocks</b> of HappyStock company. You will be given some scenarios, and you have to choose your action. Let's see how much you'll have at the end. "));
        letsgobtn = findViewById(R.id.letsgo);
        scenarioText = findViewById(R.id.scenarioView);
        explainText = findViewById(R.id.explainView);
        submitbtn = findViewById(R.id.submit);
        nextbtn = findViewById(R.id.next);
        finalText = findViewById(R.id.finalTextView);
        amountSelectText = findViewById(R.id.amountSelectView);
        minusbtn = findViewById(R.id.minusView);
        plusbtn = findViewById(R.id.plusView);
        amountArea = findViewById(R.id.amountAreaView);
        radioGroup = findViewById(R.id.radio_group);
        actionText = findViewById(R.id.actionView);

        letsgobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letsgobtn.setVisibility(View.GONE);
                nameText.setVisibility(View.GONE);
                instructionText.setVisibility(View.GONE);
                scenarioText.setVisibility(View.VISIBLE);
                submitbtn.setVisibility(View.VISIBLE);
                nextbtn.setVisibility(View.VISIBLE);
                changeScene();
                changeStatus();
            }
        });

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                explainText.setVisibility(View.VISIBLE);
                submitbtn.setEnabled(false);
                nextbtn.setEnabled(true);
                plusbtn.setVisibility(View.GONE);
                minusbtn.setVisibility(View.GONE);
                amountSelectText.setVisibility(View.GONE);
                amountArea.setVisibility(View.GONE);
                radioGroup.setVisibility(View.GONE);
                actionText.setVisibility(View.GONE);
            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentScene++;
                if(currentScene<3){
                    changeScene();
                } else{
                    scenarioText.setVisibility(View.GONE);
                    explainText.setVisibility(View.GONE);
                    submitbtn.setVisibility(View.GONE);
                    nextbtn.setVisibility(View.GONE);
                    finalText.setText("You have reached the end of the game.");
                    finalText.setVisibility(View.VISIBLE);
                }
            }
        });

        plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedActionText.equals("do nothing")){ //you cannot set amount if you decide to be idle

                }else{
                    currentAmountSelected+=100;
                    amountSelectText.setText(""+currentAmountSelected);
                }
            }
        });

         minusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedActionText.equals("do nothing")){

                }else{
                    if(currentAmountSelected>0){
                        currentAmountSelected-=100;
                    }
                    amountSelectText.setText(""+currentAmountSelected);
                }
            }
        });



        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                changeStatus();
            }
        });

    }

    public void changeScene(){
        scenarioText.setText(scenario[currentScene]);
        explainText.setText(explanation[currentScene]);
        explainText.setVisibility(View.GONE);
        nextbtn.setEnabled(false);
        submitbtn.setEnabled(true);
        plusbtn.setVisibility(View.VISIBLE);
        minusbtn.setVisibility(View.VISIBLE);
        amountSelectText.setVisibility(View.VISIBLE);
        amountArea.setVisibility(View.VISIBLE);
        radioGroup.setVisibility(View.VISIBLE);
        actionText.setVisibility(View.VISIBLE);
    }

    public void changeStatus(){
        selectedRadioButton = (RadioButton)radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
        selectedActionText = (String) selectedRadioButton.getText();
        actionText.setText("You want to "+selectedActionText);
        if(selectedActionText.equals("do nothing")){
            currentAmountSelected = 0;
            amountSelectText.setText(""+currentAmountSelected);
        }
    }

}
