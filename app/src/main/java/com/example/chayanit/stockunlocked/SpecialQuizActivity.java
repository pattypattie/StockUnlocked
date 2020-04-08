package com.example.chayanit.stockunlocked;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class SpecialQuizActivity extends AppCompatActivity {

    TextView nameText, instructionText, scenarioText, profileText, explainText, finalText, amountSelectText, actionText, assetText, finalAssetText, finalPerformanceText, finalNoticeText;
    Button letsgobtn, submitbtn, nextbtn, profileTogglebtn, assetTogglebtn, finalPerformanceTogglebtn, finalNoticeTogglebtn;
    ImageButton plusbtn, minusbtn;
    LinearLayout amountArea;
    RadioGroup radioGroup;
    RadioButton selectedRadioButton, donothing;
    ImageView scene2QuestionImage, explainImage;
    GifImageView congratsImg, comfortImg;

    String selectedActionText;

    String[] scenario = {"  The news reported that there is a high chance that Social Security Office scheme (SSO) will increase the rate of diagnosis-related group (DRG) payment next year." +
            "\n\nInvestment Period : 21 Oct 19 - 7 Nov 19\n",
            "  Below is a candlestick chart and PSAR indicator of HappyHospital stock from 24 Oct - 6 Nov." +
            "\n\nInvestment Period : 7 Nov 19 - 13 Nov 19\n",
            "   HappyHospital has announced its 3Q19 financial statement. Its profit is +54%QoQ (Quarter on Quarter), and +13%YoY (Year over Year). For QoQ, the profit increases due to the high season of the industry," +
            "as there are increasing seasonal fever and epidemic. ABCHospital, which is a branch of HappyHospital, can resume its service after facing the difficulty during the moving of its diabetes center from 10th floor to 1st floor in the last quarter." +
            "\n\nInvestment Period : 13 Nov 19 - 29 Nov 19\n"};
    String[] explanation = {"With this news, investors are hoping that the income of the hospital will increase since the hospital accepts social security patients, and 33% of the hospital's income is from these type of patients." +
            "If the income of the hospital increases, it is expected that the profit will increase as well. Thus, investors are starting to buy the company's shares. Once there is a high demand for the stock, its price will increase accordingly." +
            " This is an example of sentiment analysis. Moreover, an analysis of on the news itself (an increased DRG rate will result in more profit to the company which leads to the increased of stock price) can also suggest buying the stock as well." +
            "\n\nThe current share unit price has increased to ฿16.8\n\nThe picture below shows the line chart of the stock price from 15 Oct - 7 Nov.\n",
            "It can be seen that the price from 24/10 until 6/11 is during an uptrend period. The PSAR indicator, which is shown as dotted lines, confirms this trend by positioning below the candlestick chart that is going upwards." +
            " However, on 6/11, the PSAR graph almost reached the candlestick chart from the bottom. This can be predicted that the PSAR might flip soon, and position above the candlestick chart instead." +
            " Once the PSAR is above the price chart, it is indicating a downtrend. Thus, it is a good idea to sell at this point before the price drops lower." +
            " This is an example of technical analysis.\n\nThe current share unit price has decreased to ฿16.4\n\nThe picture below shows a candlestick chart and PSAR from 24 Oct - 13 Nov.\n",
            "Looking at the company's financial statement, the income and the profit of the company increases due to its increasing performance. Since the company's earning rises, it causes the stock price to rise accordingly. Thus, after conducting the analysis," +
            "you can predict that the stock price will increase,and buying the stock is a good option. This is an example of fundamental analysis." +
            "\n\nThe current share unit price has increased to ฿17.4\n\nThe picture below shows the line chart of the stock price from 7 Nov - 29 Nov.\n"};
    double[] unitPrice = {15.8,16.7,16.4,17.4};
    String[] explain_img_array = {"special_scene1_solution","special_scene2_solution","special_scene3_solution"};

    int currentAmountSelected = 0;
    double currentCashSelected = 0;
    int currentStockHave = 1000;
    double currentCashHave = 10000;
    double performanceBaht = 0;
    double performancePercent = 0;
    String performanceStatus = "";//profit or loss

    int currentScene = 0;
    int resId;

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
        instructionText.setText(Html.fromHtml("&emsp Welcome to the trading simulation game!" +
                "Now you have <b>฿1000</b> and you have a starting amount of stock of <b>1000 stocks</b> of HappyHospital company which you bought at Friday 18 Oct at unit price of ฿15.9." +
                "You will be given some scenarios, and you have to choose your action. Once you have selected an action, you will have to maintain the same portfolio status until the end of the given investment period." +
                "<br><br>Let's see how much profit you can gain at the end :) <br>"));
        letsgobtn = findViewById(R.id.letsgo);
        scenarioText = findViewById(R.id.scenarioView);
        profileText = findViewById(R.id.profileView);
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
        assetText = findViewById(R.id.assetView);
        donothing = findViewById(R.id.radionone);
        finalAssetText = findViewById(R.id.finalAssetView);
        profileTogglebtn = findViewById(R.id.profileToggleView);
        assetTogglebtn = findViewById(R.id.assetToggleView);
        finalPerformanceText = findViewById(R.id.finalPerformanceView);
        finalPerformanceTogglebtn = findViewById(R.id.finalPerformanceToggleView);
        finalNoticeTogglebtn = findViewById(R.id.finalNoticeToggleView);
        finalNoticeText = findViewById(R.id.finalNoticeView);
        scene2QuestionImage = findViewById(R.id.scene2questionImageView);
        explainImage = findViewById(R.id.explainImageView);
        congratsImg = findViewById(R.id.congratsView);
        comfortImg = findViewById(R.id.comfortView);

        assetText.setText("\n -- Your current asset -- \nYou have ฿"+currentCashHave+" in cash, and "+currentStockHave+" stocks of HappyHospital company.");

        letsgobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letsgobtn.setVisibility(View.GONE);
                nameText.setVisibility(View.GONE);
                instructionText.setVisibility(View.GONE);
                scenarioText.setVisibility(View.VISIBLE);
                submitbtn.setVisibility(View.VISIBLE);
                nextbtn.setVisibility(View.INVISIBLE);
                nextbtn.setEnabled(false);
                changeScene();
                changeStatus();
            }
        });

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                explainText.setVisibility(View.VISIBLE);
                submitbtn.setEnabled(false);
                submitbtn.setVisibility(View.INVISIBLE);
                nextbtn.setVisibility(View.VISIBLE);
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
                if(!explain_img_array[currentScene].equals("")){
                    explainImage.setVisibility(View.VISIBLE);
                }
                profileText.setText("\n -- HappyHospital Company Profile --\nMarket : SET\nIndustry : Services\nSector : Health Care Services" +
                        "\nCompany Description : The Company operates business as a Group providing health care service for both cash patients and social security scheme" +
                        "\nIncome from Social Security patient : 33% of total income\nDividend Yield : 1.93%\nCurrent share unit price : ฿"+unitPrice[currentScene+1]);
                assetText.setText("\n -- Your current asset -- \nYou have ฿"+currentCashHave+" in cash, and "+currentStockHave+" stocks of HappyHospital company.");
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
                    profileText.setVisibility(View.GONE);
                    explainText.setVisibility(View.GONE);
                    submitbtn.setVisibility(View.GONE);
                    nextbtn.setVisibility(View.GONE);
                    explainImage.setVisibility(View.GONE);
                    performanceBaht = (currentCashHave+(currentStockHave*unitPrice[3]))-(10000+(1000*15.9));
                    performancePercent = (performanceBaht/(10000+(1000*15.9)))*100;
                    if(performanceBaht>0){
                        performanceStatus = "profit";
                        congratsImg.setVisibility(View.VISIBLE);
                        finalText.setText("You have reached the end of the game. \nYour performance : "+performanceStatus+" ฿"+Math.round(performanceBaht)+", or about "+Math.round(performancePercent)+"%\n\nCongratulations!!! You profit from this game!!! Great job!!!");
                    } else if(performanceBaht<0){
                        performanceStatus = "loss";
                        comfortImg.setVisibility(View.VISIBLE);
                        finalText.setText("You have reached the end of the game. \nYour performance : "+performanceStatus+" ฿"+Math.round(performanceBaht)+", or about "+Math.round(performancePercent)+"%\n\nYou did not profit from this game. It's alright, you can try harder next time.");
                    } else{
                        performanceStatus = "no loss or profit";
                        comfortImg.setVisibility(View.VISIBLE);
                        finalText.setText("You have reached the end of the game. \nYour performance : "+performanceStatus+"\n\nYou did not profit from this game. It's alright, you can try harder next time.");
                    }
                    profileText.setVisibility(View.GONE);
                    profileTogglebtn.setVisibility(View.GONE);
                    finalText.setVisibility(View.VISIBLE);
                    finalAssetText.setText("\n -- Your current asset -- \nYou have ฿"+Math.round(currentCashHave)+" in cash, and "+currentStockHave+" stocks of HappyHospital company.");
                    finalAssetText.setVisibility(View.VISIBLE);
                    assetText.setVisibility(View.GONE);
                    assetTogglebtn.setVisibility(View.GONE);
                    finalNoticeTogglebtn.setText("* View Final Notice *");
                    finalNoticeTogglebtn.setVisibility(View.VISIBLE);
                    finalNoticeText.setText("\n --- Final Note ---" +
                            "\n- HappyHospital Company later declares Ex-dividend date to be on 17 Mar 2020, and the record date is one 18 Mar 2020." +
                            "This means if you own the stock of HappyHospital before the ex-dividend date, you will get a dividend." +
                            "\n- In reality, you should consider fundamental, sentiment, and technical factors altogether. Considering only one type of analysis is generally not adequate for stock price prediction." +
                            "And when you use technical indicator, it is recommended to compare several indicators to confirm a trend." +
                            "\n- In this game, we use closing price as a price for you to buy/sell. However, in the real trading, the price swings during the day, and you have to determine the price you want to" +
                            " buy/sell by considering the current market price by yourself. Moreover, in this game, your order always matches, which means your order is always successful. But in real trading, you will be able to" +
                            " buy/sell according to the market demand/supply available."+
                            "\n- Precaution : Approximately at the beginning of year 2020, Thailand had encountered Covid-19, which is a crisis that results in most of the stock price to decline." +
                            "In crisis such as this case, typical analysis would not be effective, and further study on investment during crisis is required.");
                    finalPerformanceTogglebtn.setText("How to calculate performance?");
                    finalPerformanceTogglebtn.setVisibility(View.VISIBLE);
                    finalPerformanceText.setText("\nPerformance calculation : Your profit or loss is calculated by '฿Final Asset - ฿Beginning Asset', and your profit or loss percentage is calculated by '[(฿Final Asset - ฿Beginning Asset)/฿Beginning Asset]x100'." +
                            "The asset was calculated by converting the amount of stock into Baht by 'Amount of stock x unit price of stock'. Your beginning asset was ฿10,000 and 1,000 stocks of unit price ฿15.9, which was stated in the beginning of the game." +
                            "The unit price of your final stock asset is the unit price at the end of scenario 3, which is ฿17.4.");
                }
            }
        });

        plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if you decide to be idle, you cannot set amount
                if(selectedActionText.equals("sell")&&!(currentAmountSelected+100>currentStockHave)){ //you can only sell not more than the amount of stock you have
                    currentAmountSelected+=100;
                    currentCashSelected = currentAmountSelected*unitPrice[currentScene];
                    actionText.setText("You want to "+selectedActionText+" "+currentAmountSelected+" stocks and receive ฿"+Math.round(currentCashSelected));
                }else if(selectedActionText.equals("buy")&&!((currentAmountSelected+100)*unitPrice[currentScene]>currentCashHave)){ //you can only buy not more than the amount of money you have
                    currentAmountSelected+=100;
                    currentCashSelected = currentAmountSelected*unitPrice[currentScene];
                    actionText.setText("You want to "+selectedActionText+" "+currentAmountSelected+" stocks and pay ฿"+Math.round(currentCashSelected));
                }
                amountSelectText.setText(""+currentAmountSelected);
            }
        });

         minusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((!selectedActionText.equals("do nothing"))&&currentAmountSelected>0){ //amount is non negative
                    currentAmountSelected-=100;
                    currentCashSelected = currentAmountSelected*unitPrice[currentScene];
                    amountSelectText.setText(""+currentAmountSelected);
                    if(selectedActionText.equals("sell")){
                        actionText.setText("You want to "+selectedActionText+" "+currentAmountSelected+" stocks and receive ฿"+Math.round(currentCashSelected));

                    }else if(selectedActionText.equals("buy")){
                        currentCashSelected = currentAmountSelected*unitPrice[currentScene];
                        actionText.setText("You want to "+selectedActionText+" "+currentAmountSelected+" stocks and pay ฿"+Math.round(currentCashSelected));
                    }
                }
            }
        });

         profileTogglebtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(profileText.getVisibility()==View.VISIBLE){
                     profileText.setVisibility(View.GONE);
                     profileTogglebtn.setText("View Company Profile");
                 }else{
                     profileText.setVisibility(View.VISIBLE);
                     profileTogglebtn.setText("Close Company Profile");
                 }
             }
         });

        assetTogglebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(assetText.getVisibility()==View.VISIBLE){
                    assetText.setVisibility(View.GONE);
                    assetTogglebtn.setText("View Your Asset Information");
                }else{
                    assetText.setVisibility(View.VISIBLE);
                    assetTogglebtn.setText("Close Your Asset Information");
                }
            }
        });

        finalPerformanceTogglebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(finalPerformanceText.getVisibility()==View.VISIBLE){
                    finalPerformanceText.setVisibility(View.GONE);
                    finalPerformanceTogglebtn.setText("How to calculate performance?");
                }else{
                    finalPerformanceText.setVisibility(View.VISIBLE);
                    finalPerformanceTogglebtn.setText("Close how to calculate performance");
                }
            }
        });

        finalNoticeTogglebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(finalNoticeText.getVisibility()==View.VISIBLE){
                    finalNoticeText.setVisibility(View.GONE);
                    finalNoticeTogglebtn.setText("* View Final Notice *");
                }else{
                    finalNoticeText.setVisibility(View.VISIBLE);
                    finalNoticeTogglebtn.setText("Close Final Notice");
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
        profileText.setText("\n -- HappyHospital Company Profile --\nMarket : SET\nIndustry : Services\nSector : Health Care Services" +
                "\nCompany Description : The Company operates business as a Group providing health care service for both cash patients and social security scheme" +
                "\nIncome from Social Security patient : 33% of total income\nDividend Yield : 1.93%\nCurrent share unit price : ฿"+unitPrice[currentScene]);
        explainText.setText("Explanation : "+explanation[currentScene]);
        explainText.setVisibility(View.GONE);
        nextbtn.setEnabled(false);
        nextbtn.setVisibility(View.INVISIBLE);
        submitbtn.setEnabled(true);
        submitbtn.setVisibility(View.VISIBLE);
        plusbtn.setVisibility(View.VISIBLE);
        minusbtn.setVisibility(View.VISIBLE);
        amountSelectText.setVisibility(View.VISIBLE);
        amountArea.setVisibility(View.VISIBLE);
        radioGroup.setVisibility(View.VISIBLE);
        actionText.setVisibility(View.VISIBLE);
        currentAmountSelected = 0;
        currentCashSelected = 0;
        amountSelectText.setText(""+currentAmountSelected);
        donothing.setChecked(true);
        profileTogglebtn.setVisibility(View.VISIBLE);
        assetTogglebtn.setVisibility(View.VISIBLE);
        explainImage.setVisibility(View.GONE);
        if(!explain_img_array[currentScene].equals("")){
            resId = this.getResources().getIdentifier(explain_img_array[currentScene], "drawable", this.getPackageName());
            explainImage.setImageResource(resId);
        }
        if(currentScene==1){
            scene2QuestionImage.setVisibility(View.VISIBLE);
        } else{
            scene2QuestionImage.setVisibility(View.GONE);
        }
    }

    public void changeStatus(){
        selectedRadioButton = (RadioButton)radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
        selectedActionText = (String) selectedRadioButton.getText();
        actionText.setText("You want to "+selectedActionText);
        currentAmountSelected = 0;
        currentCashSelected = 0;
        amountSelectText.setText(""+currentAmountSelected);
        if(selectedActionText.equals("sell")){
            actionText.setText("You want to "+selectedActionText+" "+currentAmountSelected+" stocks and receive ฿"+currentCashSelected);
        } else if(selectedActionText.equals("buy")){
            actionText.setText("You want to "+selectedActionText+" "+currentAmountSelected+" stocks and pay ฿"+currentCashSelected);
        }

    }

}
