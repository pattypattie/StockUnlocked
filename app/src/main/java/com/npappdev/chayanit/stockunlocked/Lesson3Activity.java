package com.npappdev.chayanit.stockunlocked;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.text.Spannable;

public class Lesson3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3);

        Button unlockls4_bt = findViewById(R.id.unlockls4);
        Button take_quiz3 = findViewById(R.id.takequiz3);

        TextView textv17 = findViewById(R.id.textView17);
        SpannableStringBuilder str = new SpannableStringBuilder("SET Index is a Thai composite stock market index which is calculated from the prices of all common stocks on the main board of the Stock Exchange of Thailand (SET)"
        + "\n" + "It is a market capitalization-weighted price index which compares the current market value of all listed common shares with its value on the base date of April 30, 1975, which was when the Index was established and set at 100 points"
        + "\n"+ "\n" + "The formula of calculation is as follows:");
        str.setSpan(new RelativeSizeSpan(1.3f), 0,9,0);
        str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textv17.setText(str);

        TextView textv19 = findViewById(R.id.textView19);
        SpannableStringBuilder snp = new SpannableStringBuilder("The Standard and Poor's 500 or S&P500 is a stock market index that tracks the stocks of 500 large U.S. companies. "
                + "It represents the stock market's performance by reporting the risks and returns of the biggest companies.");
        snp.setSpan(new RelativeSizeSpan(1.3f), 31,37,0);
        snp.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 31, 37, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textv19.setText(snp);


        TextView textv20 = findViewById(R.id.textView20);
        SpannableStringBuilder cirb = new SpannableStringBuilder("Circuit Breakers : In order to control volatility of the market and to give investors an opportunity to better consider information during periods of panic buying and selling, the SET will temporarily stop during the trading session.\n " +
        " - If the SET Index falls by 10% from the previous day's close, all trading in listed securities will be halted for 30 minutes.\n" +
        " - If the SET Index falls another 10% (to 20% from the previous day's close), trading in all listed securities will be halted for one hour.\n" +
                " - If trading time left in a session is less than 30 minutes, or one hour after the circuit breaker comes into effect, trading will be halted until the closing time of that session, and will then resume in the next session."
        );
        cirb.setSpan(new RelativeSizeSpan(1.3f), 0,16,0);
        cirb.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 16, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textv20.setText(cirb);

        TextView textv21 = findViewById(R.id.textView21);
        SpannableStringBuilder cnf = new SpannableStringBuilder("Ceiling and Floor is the highest and lowest selling price in that day, respectively. " +
                "SET sets the floor limit at a minus 30% of the previous day's closing price on the main board while the ceiling limit at a plus 30% of the previous day's closing price on the main board.");
        cnf.setSpan(new RelativeSizeSpan(1.3f), 0,17,0);
        cnf.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 17, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textv21.setText(cnf);

        TextView textv22 = findViewById(R.id.textView22);
        SpannableStringBuilder bull = new SpannableStringBuilder("Bull Market refers to a market that is on the rise, it is typified by a sustained increase in price. " +
                "Investors often have faith that the uptrend will continue over the long term. Typically, in this scenario, the country's economy is strong and employment levels are high");
        bull.setSpan(new RelativeSizeSpan(1.3f), 0,11,0);
        bull.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textv22.setText(bull);

        TextView textv23 = findViewById(R.id.textView23);
        SpannableStringBuilder bear = new SpannableStringBuilder("Bear Market is one that is in decline, typically having fallen 20% or more from recent highs. " +
                "Share prices are continuously dropping, resulting in a downward trend that investors believe will continue." +
                "During a bear market, the economy will typically slow down and unemployment will rise as companies begin laying off workers. ");
        bear.setSpan(new RelativeSizeSpan(1.3f), 0,11,0);
        bear.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textv23.setText(bear);

        TextView textv24 = findViewById(R.id.textView24);
        SpannableStringBuilder bidnOf = new SpannableStringBuilder("Bid is the price selected by a buyer to buy a stock, while the Offer is the price at which the seller is offering to sell the stock.");
        bidnOf.setSpan(new RelativeSizeSpan(1.3f), 0,3,0);
        bidnOf.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bidnOf.setSpan(new RelativeSizeSpan(1.3f), 63,69,0);
        bidnOf.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 63, 69, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textv24.setText(bidnOf);

        TextView textv25 = findViewById(R.id.textView25);
        SpannableStringBuilder vol = new SpannableStringBuilder("Volume is the total number of shares that are actually traded, bought and sold, during the trading day or specified set period of time." );
        vol.setSpan(new RelativeSizeSpan(1.3f), 0,6,0);
        vol.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textv25.setText(vol);

        unlockls4_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences shared = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putBoolean("ls4_enable",true);
                editor.putBoolean("qz3_enable",true);
                editor.commit();
                startActivity(new Intent(Lesson3Activity.this,Lesson4Activity.class));

            }});
        take_quiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences shared = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putBoolean("qz3_enable",true);
                editor.putBoolean("ls4_enable",true);
                editor.commit();
                startActivity(new Intent(Lesson3Activity.this,Quiz3Activity.class));

            }
        });


        ImageButton lesson3_back = findViewById(R.id.lesson3back);
        lesson3_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lesson3Activity.this,LessonActivity.class));
            }
        });
    }
}
