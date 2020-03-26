package com.example.chayanit.stockunlocked;


public class Quiz1Library {
     String mQuestions [] = {
            "Investors have the ability to ________ their shares.",
            "What is the name of corporations that handle the money?",
            "What is the Stock Market?",
            "If _____ people are selling than those buying it, the stock will drop.",
            "If _____ people are selling than those buying it, the stock will rise.",
            "One can profit from stocks by _____"

    };


    private String mChoices [][] = {
            {"Buy", "Sell", "Buy or Sell"},
            {"Investopedia", "Financial Industry", "Stock Exchange"},
            {"The Stock Market is a market where people bet on race horses to gain some money.", "The Stock Market is a market where people buy products which the merchants have a lot of stock of", "The Stock Market is a market where people can buy stocks which are shares of companies."},
            {"more", "less", "equal number of"},
            {"more", "less", "equal number of"},
            {"Buying high and selling low", "Buying low and selling high", "Buying and selling at the same price"}
    };



    private String mCorrectAnswers[] = {"Buy or Sell", "Financial Industry", "The Stock Market is a market where people can buy stocks which are shares of companies.",
            "more", "less", "Buying high and selling low"};




    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }


    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }


    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

}
