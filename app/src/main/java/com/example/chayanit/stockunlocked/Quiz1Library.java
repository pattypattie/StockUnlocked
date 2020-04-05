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

     String ls3q1 [] = {
             "bear","bull","lamp","sell","stock","wood"
     };


     String ls3q2 [] = {
             "What does Ceiling and Floor mean?",
             "What does Bull and Bear mean?",
             "What does Bid and Offer mean?"

     };
     String ls3q3 [] = {
             "S&P500 is a Thai composite stock market index from all the common stocks on the main board of the Stock Exchange of Thailand (SET)",
             "SET Index is a stock market index that tracks the stocks of 500 large U.S. companies",
             "Volume is the total number of shares that are actually traded, bought and sold, during the trading day or specified set period of time"

     };


    private String mChoices [][] = {
            {"Buy", "Sell", "Buy or Sell"},
            {"Investopedia", "Financial Service Industry", "Stock Exchange"},
            {"The Stock Market is a market where people bet on race horses to gain some money.", "The Stock Market is a market where people buy products which the merchants have a lot of stock of", "The Stock Market is a market where people can buy stocks which are shares of companies."},
            {"more", "less", "equal number of"},
            {"more", "less", "equal number of"},
            {"Buying low and selling high", "Buying high and selling low", "Buying and selling at the same price"}
    };

     String ls3q2choices [][] ={
            {"The highest and lowest selling price in the day","Market that on the rise or in decline","Buying price and selling price of the stock"}
    };



    private String mCorrectAnswers[] = {"Buy or Sell", "Financial Service Industry", "The Stock Market is a market where people can buy stocks which are shares of companies.",
            "more", "less", "Buying low and selling high"};

    private String ls3q2Ans [] = {"The highest and lowest selling price in the day","Market that on the rise or in decline","Buying price and selling price of the stock"

    };

    String ls1result [] = {"Investors can buy or sell their shares. An investor who owns a stock is called a shareholder","Financial Service Industry encompasses a broad range of businesses that manage money, including including banks, investment companies, insurance companies, and real estate firms.",
    "The stock market is where investors connect to buy and sell investments or stocks which are shares of ownership in a public company.",
    "As more people are selling the stocks, the demand of that shares will decrease and causes the stock to drop","As more people are buying the stocks, the demand of that shares will increase and causes the stock to rise",
    "For example, if a person buy a stock at 10 baht ans sell it at 15 baht, a person get a profit of 5 baht."};

      String ls3q3Ans [] = {
              "false","false","true"
      };

      String ls3q2Explain [] = {
              "Ceiling and Floor is the highest and lowest selling price in that day, respectively.","A bull market is the condition of a financial market in which prices are rising or are expected to rise. The opposite of a bull market is a bear market, which is characterized by falling prices"
              ,"Bid is the price selected by a buyer to buy a stock, while the Offer is the price at which the seller is offering to sell the stock."
      };

    String ls3q3Explain [] = {
            "The Standard and Poor's 500 or S&P500 is a stock market index that tracks the stocks of 500 large U.S. companies.","SET Index is a Thai composite stock market index which is calculated from the prices of all common stocks on the main board of the Stock Exchange of Thailand (SET)",""
    };

      public String ls3q2getResult(int a){
          String result = ls3q2Explain[a];
          return result;
      }
    public String ls3q3getResult(int a){
        String result = ls3q3Explain[a];
        return result;
    }

    public String ls1getResult(int a){
        String result = ls1result[a];
        return result;
    }

    public String ls3q2getQuestion(int a) {
        String question = ls3q2[a];
        return question;
    }

    public String ls3q3getQuestion(int a) {
        String question = ls3q3[a];
        return question;
    }


    public String ls3q2getCorrectAnswer(int a) {
        String answer = ls3q2Ans[a];
        return answer;
    }

    public String ls3q3getCorrectAnswer(int a) {
        String answer = ls3q3Ans[a];
        return answer;
    }


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
