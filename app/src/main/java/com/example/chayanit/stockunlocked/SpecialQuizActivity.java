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

    TextView nameText, instructionText, scenarioText, explainText, finalText, amountSelectText, actionText, portText;
    Button letsgobtn, submitbtn, nextbtn;
    ImageButton plusbtn, minusbtn;
    LinearLayout amountArea;
    RadioGroup radioGroup;
    RadioButton selectedRadioButton, donothing;

    String selectedActionText;

    String[] scenario = {"scene1", "scene2", "scene3"};
    String[] explanation = {"explain1", "explain2", "explain3"};
    double[] unitPriceSell = {10,10,10};
    double[] unitPriceBuy = {20,20,20};

    int currentAmountSelected = 0;
    double currentCashSelected = 0;
    int currentStockHave = 1000;
    double currentCashHave = 10000;

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
        portText = findViewById(R.id.portView);
        donothing = findViewById(R.id.radionone);

        portText.setText("Your current portfolio : You have $"+currentCashHave+" in cash, and "+currentStockHave+" stocks of HappyStock company.");

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
                if(selectedActionText.equals("sell")){
                    currentStockHave-=currentAmountSelected;
                    currentCashHave+=currentCashSelected;
                }else if(selectedActionText.equals("buy")){
                    currentStockHave+=currentAmountSelected;
                    currentCashHave-=currentCashSelected;
                }
                portText.setText("Your current portfolio : You have $"+currentCashHave+" in cash, and "+currentStockHave+" stocks of HappyStock company.");
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
                    portText.setVisibility(View.GONE);
                }
            }
        });

        plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if you decide to be idle, you cannot set amount
                if(selectedActionText.equals("sell")&&!(currentAmountSelected+100>currentStockHave)){ //you can only sell not more than the amount of stock you have
                    currentAmountSelected+=100;
                    currentCashSelected = currentAmountSelected*unitPriceSell[currentScene];
                    actionText.setText("You want to "+selectedActionText+" "+currentAmountSelected+" stocks and receive $"+currentCashSelected);
                }else if(selectedActionText.equals("buy")&&!((currentAmountSelected+100)*unitPriceBuy[currentScene]>currentCashHave)){ //you can only buy not more than the amount of money you have
                    currentAmountSelected+=100;
                    currentCashSelected = currentAmountSelected*unitPriceBuy[currentScene];
                    actionText.setText("You want to "+selectedActionText+" "+currentAmountSelected+" stocks and pay $"+currentCashSelected);
                }
                amountSelectText.setText(""+currentAmountSelected);
            }
        });

         minusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((!selectedActionText.equals("do nothing"))&&currentAmountSelected>0){ //amount is non negative
                    currentAmountSelected-=100;
                    amountSelectText.setText(""+currentAmountSelected);
                    if(selectedActionText.equals("sell")){
                        actionText.setText("You want to "+selectedActionText+" "+currentAmountSelected+" stocks and receive $"+currentCashSelected);

                    }else if(selectedActionText.equals("buy")){
                        actionText.setText("You want to "+selectedActionText+" "+currentAmountSelected+" stocks and pay $"+currentCashSelected);
                    }
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
        portText.setVisibility(View.VISIBLE);
        currentAmountSelected = 0;
        currentCashSelected = 0;
        amountSelectText.setText(""+currentAmountSelected);
        donothing.setChecked(true);
    }

    public void changeStatus(){
        selectedRadioButton = (RadioButton)radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
        selectedActionText = (String) selectedRadioButton.getText();
        actionText.setText("You want to "+selectedActionText);
        currentAmountSelected = 0;
        currentCashSelected = 0;
        amountSelectText.setText(""+currentAmountSelected);
        if(selectedActionText.equals("sell")){
            actionText.setText("You want to "+selectedActionText+" "+currentAmountSelected+" stocks and receive $"+currentCashSelected);
        } else if(selectedActionText.equals("buy")){
            actionText.setText("You want to "+selectedActionText+" "+currentAmountSelected+" stocks and pay $"+currentCashSelected);
        }

    }

}
