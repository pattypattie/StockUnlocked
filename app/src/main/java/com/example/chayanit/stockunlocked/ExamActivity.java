package com.example.chayanit.stockunlocked;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class ExamActivity extends AppCompatActivity {

    public Button b1, b2, b3, b4, nextQbtn;
    public TextView questionText, scoreText, checkCorrectText, explainText;
    public ImageView questionImage;
    public int random_question = 0;
    public int random_answer_order = 0;

    //keep track of how many questions have been answered
    int questionCounter = 0;

    //keep track of the user's score
    int testScore = 0;

    //track user's current level
    int level = 1;

    //for image
    int resId;

    String[] questionLevel1 = {"What does the Ceiling term mean?", "What does the Floor term mean?", "Who is a broker?", "The top-down approach in Fundamental Analysis consists of ……..", "How does the stock market benefit both business and investor?", "Which of these are not types of trend lines?", "What do you NOT have to do in order to open a stock trading account?", "What does a stock chart show?", "How many bands do a Bollinger Band have?", "Which of the following is not a Technical Indicator?"};
    String[] questionLevel2 = {"What analysis should a trader make?", "What is a circuit breaker?", "Which of the following is a good source of market information?", "How do we calculate PE?", "What are the characteristics of a technical analyst?", "Which of the following is not a type of stock account?", "Which is NOT true about Moving Average?", "What information can be provided by the candlestick chart?", "What does a line chart represent?", "What is true about Technical Analysis?"};
    String[] questionLevel3 = {"Which of these stocks is cheapest?", "Which of these stocks is the most expensive?", "Quality Co. has net income during the year of 50,000 baht and 5,000 weighted average shares outstanding, what is their EPS?", "If a stock is trading a 100baht and payout 6% in dividend, what would that be in baht?", "Due to the COVID-19 situation in 2020, SET has decreased the floor and ceiling limit by half, how much is that percentage?", "Which definition about stock type is correct?", "What is NOT an example of a company product that can be classified as cyclical stock type?", "In “Support and Resistance”, a resistance level is...", "If you want to avoid risks, which stock type should you avoid investing?", "Which of these is NOT true about OBV (On-Balance Volume)"};
    String[] questionLevel4 = {"Which of the following is NOT related to a fundamental event?", "How does fundamental analysis help investors?", "Can PE value be compared to any company in the market?", "In industry analysis, why entering the financial planning industry is easier than entering the automobile industry for the new company?", "What sentiment is this?", "When plotting a 50-day and 200-day Moving Average graph, a buy signal occurs when...", "When plotting fast and slow lines for MACD, a sell signal occurs when...", "The selling signal for RSI occurs when...", "Which of these is true when the outer bands of the Bollinger Band squeeze?", "Which of the following is true about divergences?"};

    String[] explainLevel1 = {"The Ceiling or Resistance level is the price level at which selling is thought to be strong enough to prevent the price from rising further.", "The Floor or Support level is the price level at which demand is thought to be strong enough to prevent the price from declining further.", "A broker is an individual or firm that acts as an intermediary between an investor and a securities exchange", "The Top-Down Approach is the most widely used method for implementing Fundamental Analysis. It begins with analysing the global economy, then the Industry research and finally the company.", "Companies will be able to grow and also tend to make profits for investors", "Uptrend means price is going up, downtrend means price is going down, and sideways trend means price is moving horizontally", "There are various broker companies for you to choose from. Then you can choose from 3 different account types to open. You also have to submit your documents : ID card, house registration, bank statement, and bank book to the broker.", "We can use a stock chart to observe the rise and fall of stock price or volume.", "The Bollinger band consists of 3 bands : a middle band, an upper band, and a lower band. All are simple moving average bands with different deviations.", "All of these are calculations based on historical values."};
    String[] explainLevel2 = {"Traders should make Fundamental, Technical, and Sentiment analysis to help forecast future trends in stock markets.", "SET implemented a circuit breaker system to curb any excessive volatility in the market that may cause investor panic. ", "You can find all the market information and news via social media or a newspaper.", "PE stands for price per earnings per share", "Technical Analysis is the forecasting of future financial price movements based on an examination of past price movements. It uses a wide variety of charts that show price over time.", "Opening one of the 3 types of stock accounts - Cash Account, Cash Balance, or Credit Balance Account - with the broker will allow you to trade in stocks.", "Moving Average is a Technical Analysis tool.", "The candlestick chart shows the open, high, low, and close price.", "The line chart is drawn by connecting each day’s closing price.", "Technical analysis studies the historical data using statistics as tools to predict the stock price. It believes that trends are repetitive so we can study its pattern. Technical analysis alone is more beneficial for short-term investment."};
    String[] explainLevel3 = {"Apple has the lowest PE which means less price to earning per shares", "Amazon has the highest PE which means more price to earning per shares", "Earning per share is equals to net income divided by number of outstanding shares so 50,000/5,000 = 10 baht", "100*0.06 = 6 baht", "Before the COVID-19 situation, SET set the limit of 30% of the previous day's closing price.", "Slow Growers belong to large companies that are growing at a low rate but provide a high dividend. Asset Plays belong to companies that own assets which value might not reflect in their stock price. Stalwarts belong to large companies that are tolerant to economic uncertainties.", "Cyclical stock price varies according to the business sales in some period of time. Airline stock price rises during high travel season and coal stock price rises during high demand for coal for energy consumption. Soap is an essential product at any time.", "The resistance level creates a ceiling for the stock price. Once the price reaches this level, its price tends to bounce back lower.", "Slow Growers are not very risky since they are stocks of large companies. Turnarounds stock will yield great profit only if the company successfully restores the business.", "OBV believes that volume precedes price, thus, volume can be used to predict the price."};
    String[] explainLevel4 = {"An important price level is broken in a technical analysis not fundamental analysis", "Fundamental Analysis helps to identify assets that represent a good value in longer-term investment.", "Investors have to look at a relation 0f the P-E from similar companies in the industry in terms of size and sector.", "The industry where the rivalry is friendly or modest among competitors provides greater opportunity for product differentiation & increased profits.", "There’s a negative comment complaining about malfunction of the company product so the feeling of people toward this will be negative", "This is called the “Golden Cross”", "On the other hand, a buy signal occurs when the fast line crosses above the slow line.", "Once the RSI falls below an overbought 70 band, it is indicating a downtrend.", "When the contraction of the upper and lower bands of the Bollinger Band squeezes, the volatility decreases, and the price might have a breakthrough in either direction afterwards.", "On the other hand, a bearish divergence occurs when the price reaches higher highs, while the technical indicator reaches lower highs."};

    //image file name if the question needs image
    String[] picLevel1 = {"", "", "", "", "", "", "", "", "", ""};
    String[] picLevel2 = {"", "", "", "", "", "", "", "", "", ""};
    String[] picLevel3 = {"", "", "", "", "", "", "", "", "", ""};
    String[] picLevel4 = {"", "", "", "", "exampic1", "", "", "", "", ""};


    //The correct answer is stored in index 0 (a1)
    String[][] answerLevel1 =
            {{"The highest level the price line can reach in a given period", "The lowest level the price line can reach in a given period", "The difference between close and open price", "The sum between close and open price"},
                    {"The lowest level the price line can reach in a given period", "The highest level the price line can reach in a given period", "The difference between close and open price", "The sum between close and open price"},
                    {"An intermediary", "Platform maker", "An investor", "An analyst"},
                    {"All of them are correct", "Company Analysis", "Industry Analysis", "Economic Analysis"},
                    {"Both are correct", "Both are incorrect", "Companies can raise money to make their businesses grow", "Investors invest in businesses to make their money grow"},
                    {"Cyclical", "Uptrend", "Sideways", "Downtrend"},
                    {"None of them is correct.", "Submit documents for opening an account - you can walk-in and sign up for an account.", "Select a broker - there is only one firm that is responsible for opening a stock account.", "Select a stock account type - the account will be automatically selected for you."},
                    {"Stock price or volume changes over time.", "Number of active investors over time.", "Number of new stocks in the market per month.", "None of them is true."},
                    {"3", "10", "5", "6"},
                    {"All of them are Technical Indicators", "RSI (Relative Strength Index)", "MACD (Moving Average Convergence Divergence)", "Bollinger Bands"}};

    String[][] answerLevel2 =
            {{"All are correct", "Sentiment Analysis", "Fundamental Analysis", "Technical Analysis"},
                    {"Regulatory measures to temporarily halt in trading on an exchange", "Index in the SET50", "Index in the SET100", "Market that is on the rise"},
                    {"All are correct", "Twitter", "Economic Calendar", "Newspaper"},
                    {"Price divided by earnings per share", "Earnings per share divided by price", "Price divided by sales per share", "Sales per share divided by price"},
                    {"Someone who analyzes charts", "Someone who analyzes the industry", "Someone who analyzes competitors", "Someone who analyzes the economic"},
                    {"Debit Balance", "Credit Balance Account", "Cash Account", "Cash Balance"},
                    {"It is an example of Sentiment Analysis.", "It is an average price of a given period of time.", "It can be used as a support level for the resistance and support technique.", "It can be used to identify a trend."},
                    {"Both are correct.", "Both are incorrect.", "High and low price", "Opening and closing price"},
                    {"Closing price", "Opening price", "Lowest price of the day", "Highest price of the day"},
                    {"It aims to predict  the future price of the stock using statistical data.", "It believes that stock trends are not repetitive over time.", "It is more suitable for long term investment than short term investment.", "It studies the practices of current investors in the market."}};

    String[][] answerLevel3 =
            {{"Apple with PE of 46", "Google with PE of 90", "Amazon with PE of 230", "CP with PE of 110"},
                    {"Amazon with PE of 230", "Google with PE of 90", "CP with PE of 110", "Apple with PE of 46"},
                    {"10 baht", "15 baht", "1 baht", "5 baht"},
                    {"6", "4", "5", "60"},
                    {"15%", "5%", "10%", "20%"},
                    {"Turnarounds are stocks of companies that nearly faced bankruptcy and are showing signs of improvement.", "Slow Growers are stocks of small companies that don’t do well in the market.", "Asset Plays are stocks of companies that deal with assets.", "Stalwarts are stocks of companies owned by larger companies, and their growth depends on their owner company’s growth."},
                    {"Soap", "Airlines", "Coal", "None of them is correct"},
                    {"The level that stops the stock price from going higher.", "The level that stops the stock price from going lower.", "The level that signals high fluctuation in stock price.", "The level that signals the steady state in stock price."},
                    {"Turnarounds", "Slow Growers", "You should avoid both.", "You should invest in both."},
                    {"OBV is the concept that price precedes volume.", "If OBV and price are moving in an opposite direction, the trend reversal will soon occur.", "OBV can be used to indicate buying and selling pressure.", "All of them are true."}};

    String[][] answerLevel4 =
            {{"An important price level is broken", "Donald Trump becomes the president of the U.S.", "Oil prices rise due to supply reduction", "None of them are correct"},
                    {"Help them understand patterns in company’s financial performance", "Help them understand patterns in company’s share price", "Both of them", "Neither"},
                    {"No, we have to compare PE value of the company from the same industry", "Yes, we can compare the PE value of any company to the others", "No, we have to compare PE value of the company from the same country", "No, we have to compare PE value of the company from the same region"},
                    {"All of them are correct", "No extraordinary efforts are required", "The growth in the industry is slowed down through the rivalry among the current competitors", "The rivalry is modest among the competitor in the same sector"},
                    {"Negative", "Neutral", "Positive", "Decrease"},
                    {"The 50-day graph crosses above the 200-day graph.", "The 50-day graph oscillates when the 200-day graph remains highly steady.", "The 50-day graph remains highly steady when the 200-day graph oscillates.", "The 50-day graph crosses below the 200-day graph."},
                    {"The fast line crosses below the slow line.", "The fast line crosses above the slow line.", "The fast and the slow line are both moving horizontally.", "None of them is correct."},
                    {"The RSI falls back under the overbought 70 band.", "The RSI rises back above the 30 oversold band.", "Both of them can be a selling signal.", "None of them is correct."},
                    {"After the squeeze, the price will make a large movement either in up or down direction.", "After the squeeze, the price will normally remain steady for a long period of time.", "After the squeeze, the trend will reverse (uptrend becomes downtrend, downtrend becomes uptrend)", "None of them is correct."},
                    {"A bullish divergence occurs when the price falls to lower lows while the technical indicator reaches higher lows.", "A bearish divergence occurs when the price falls to lower lows while the technical indicator reaches higher lows.", "A bullish divergence occurs when the price reaches higher lows while the technical indicator falls to lower lows.", "A bearish divergence occurs when the price reaches higher lows while the technical indicator falls to lower lows."}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        questionText = findViewById(R.id.textView2);
        Button btn_none = findViewById(R.id.buttonnone);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        scoreText = findViewById(R.id.score);
        questionImage = findViewById(R.id.imageView70);
        explainText = findViewById(R.id.examExplainText);
        nextQbtn = findViewById(R.id.nextExam);
        checkCorrectText = findViewById(R.id.correctText);

        btn_none.setVisibility(View.INVISIBLE);
        nextQbtn.setVisibility(View.INVISIBLE);

        createNewQuestion(1);

        nextQbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questionCounter!=10){ //limit to 10 questions per one exam
                    createNewQuestion(level);
                    nextQbtn.setVisibility(View.INVISIBLE);
                }else{
                    //startActivity(new Intent(ExamActivity.this,ExamResultActivity.class));
                    Intent intent = new Intent(ExamActivity.this,ExamResultActivity.class);
                    intent.putExtra("finalScore", testScore+"");
                    startActivity(intent);
                }
            }
        });

        ImageButton exam_back = findViewById(R.id.examback);
        exam_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExamActivity.this,TitleActivity.class));
            }
        });

    }

    public static int getResourceByFilename(Context context, String filename) {
        return context.getResources().getIdentifier(filename, "drawable", context.getPackageName());
    }

    public void createNewQuestion(int level){

        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);

        if(level==1){
            setAnswerText(answerLevel1, questionLevel1, picLevel1, explainLevel1);
        }
        else if(level==2){
            setAnswerText(answerLevel2, questionLevel2, picLevel2, explainLevel2);
        }
        else if(level==3){
            setAnswerText(answerLevel3, questionLevel3, picLevel3, explainLevel3);
        }
        else if(level==4){
            setAnswerText(answerLevel4, questionLevel4, picLevel4, explainLevel4);
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAnswer(1);
            }});
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAnswer(2);
            }});
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAnswer(3);
            }});
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAnswer(4);
            }});

    }

    public void setAnswerText(String[][] ansString, String[] quesString, String[] picString, String[] explainString){

        do{
            random_question = (int)(Math.random()*quesString.length);
        }
        while(quesString[random_question]=="");

        random_answer_order = (int)((Math.random()*4)+1);

        questionText.setText(""+ quesString[random_question]);
        if(random_answer_order==1) {
            b1.setText(""+ansString[random_question][0]);
            b2.setText("" + ansString[random_question][1]);
            b3.setText("" + ansString[random_question][2]);
            b4.setText("" + ansString[random_question][3]);
        }
        else if(random_answer_order==2){
            b2.setText(""+ansString[random_question][0]);
            b3.setText("" + ansString[random_question][1]);
            b4.setText("" + ansString[random_question][2]);
            b1.setText("" + ansString[random_question][3]);
        }
        else if(random_answer_order==3){
            b3.setText(""+ansString[random_question][0]);
            b4.setText("" + ansString[random_question][1]);
            b1.setText("" + ansString[random_question][2]);
            b2.setText("" + ansString[random_question][3]);
        }
        else if(random_answer_order==4){
            b4.setText(""+ansString[random_question][0]);
            b1.setText("" + ansString[random_question][1]);
            b2.setText("" + ansString[random_question][2]);
            b3.setText("" + ansString[random_question][3]);
        }

        explainText.setText(explainString[random_question]);
        explainText.setVisibility(View.GONE);
        checkCorrectText.setVisibility(View.INVISIBLE);

        //if the question has image, show it. else don't
        if(picString[random_question]!=""){
            resId = this.getResources().getIdentifier(picString[random_question], "drawable", this.getPackageName());
            questionImage.setImageResource(resId);
            questionImage.setVisibility(View.VISIBLE);
        } else{
            questionImage.setVisibility(View.GONE);
        }

        //remove duplicate
        quesString[random_question] = "";
        picString[random_question] = "";
        explainString[random_question] = "";

    }

    public void clickAnswer(int btn_number){
        if(btn_number==random_answer_order){ //if the answer is correct, increase one level
            testScore+=level; //as level gets higher, the score is higher
            level++;
            checkCorrectText.setText("Correct!");
            if(level>4){
                level = 4; //the highest level is 4
            }
        }
        else{ //if the answer is incorrect, decrease one level
            level--;
            checkCorrectText.setText("Incorrect");
            if(level<1){
                level = 1; //the lowest level is 1
            }
        }
        explainText.setVisibility(View.VISIBLE);
        checkCorrectText.setVisibility(View.VISIBLE);
        scoreText.setText("Score : "+testScore);
        questionCounter++;
        nextQbtn.setVisibility(View.VISIBLE);
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);

    }
}
