package com.npappdev.chayanit.stockunlocked;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Lesson4Quiz2Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Lesson4Quiz2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Lesson4Quiz2Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    TextView instructionText, question, checkAns, explainAns;
    String quizName, correctAns;
    int randomQuestion;
    ArrayList<String> questionList, answerList, explainList;
    ImageView turnaroundImg, fastGrowerImg, assetPlayImg;
    ImageButton randomCompany, randomCompanyFade;
    Button slowGrowers, stalWarts, fastGrowers, cyclical, turnaround, assetPlay, next;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Lesson4Quiz2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Lesson4Quiz2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Lesson4Quiz2Fragment newInstance(String param1, String param2) {
        Lesson4Quiz2Fragment fragment = new Lesson4Quiz2Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View myFragmentView = inflater.inflate(R.layout.fragment_lesson4_quiz2, container, false);

        question = myFragmentView.findViewById(R.id.questionText);
        checkAns = myFragmentView.findViewById(R.id.checkAnsText);
        explainAns = myFragmentView.findViewById(R.id.explainAnsText);
        turnaroundImg = myFragmentView.findViewById(R.id.turnaroundImg1);
        fastGrowerImg = myFragmentView.findViewById(R.id.fastGrowerImg1);
        assetPlayImg = myFragmentView.findViewById(R.id.assetPlayImg1);
        randomCompany = myFragmentView.findViewById(R.id.randomImgBtn);
        randomCompanyFade = myFragmentView.findViewById(R.id.randomImgBtnFade);
        slowGrowers = myFragmentView.findViewById(R.id.stocktype1);
        stalWarts = myFragmentView.findViewById(R.id.stocktype2);
        fastGrowers = myFragmentView.findViewById(R.id.stocktype3);
        cyclical = myFragmentView.findViewById(R.id.stocktype4);
        turnaround = myFragmentView.findViewById(R.id.stocktype5);
        assetPlay = myFragmentView.findViewById(R.id.stocktype6);

        next = myFragmentView.findViewById(R.id.nextQ);
        next.setVisibility(View.INVISIBLE);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), QuizResultActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("finalScore", 2);
                    bundle.putInt("QsNum", 4);
                    i.putExtras(bundle);
                    getActivity().finish();
                    startActivity(i);
            }
        });

        instructionText = myFragmentView.findViewById(R.id.instructionl4q2);
        quizName = "<h1>What type am I?</h1>";
        instructionText.setText(Html.fromHtml(quizName));

        questionList = new ArrayList<String>(3);
        answerList = new ArrayList<String>(3);
        explainList = new ArrayList<String>(3);

        slowGrowers.setEnabled(false);
        stalWarts.setEnabled(false);
        fastGrowers.setEnabled(false);
        cyclical.setEnabled(false);
        turnaround.setEnabled(false);
        assetPlay.setEnabled(false);

        randomQuestion = -1;
        questionList.addAll(Arrays.asList("I once almost faced bankruptcy, but I managed to survive by following a better business plan.", "I have just started the business, but I am investing in a lot of things and I keep getting successful.", "I am a small retailer company, but I own some valuable real estate in other country."));
        answerList.addAll(Arrays.asList("Turnaround", "Fast Growers", "Asset Play"));
        explainList.addAll(Arrays.asList("Turnarounds overcame severe loss and are in the process of becoming successful.", "Fast Growers are typically not large businesses that are currently expanding fast in a short period of time.", "Asset Player companies own assets that may not reflect in its stock price."));

        randomCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                slowGrowers.setEnabled(false);
                stalWarts.setEnabled(false);
                fastGrowers.setEnabled(false);
                cyclical.setEnabled(false);
                turnaround.setEnabled(false);
                assetPlay.setEnabled(false);
                randomCompany.setVisibility(View.INVISIBLE);
                randomCompanyFade.setVisibility(View.VISIBLE);
                question.setText("");
                checkAns.setText("");
                explainAns.setText("");
                CountDownTimer cdt = new CountDownTimer(2000, 100) {
                    public void onTick(long millisUntilFinished) {
                        if((millisUntilFinished/100)%3==0){
                            turnaroundImg.setVisibility(View.VISIBLE);
                            fastGrowerImg.setVisibility(View.INVISIBLE);
                            assetPlayImg.setVisibility(View.INVISIBLE);
                        } else if((millisUntilFinished/100)%3==1){
                            turnaroundImg.setVisibility(View.INVISIBLE);
                            fastGrowerImg.setVisibility(View.VISIBLE);
                            assetPlayImg.setVisibility(View.INVISIBLE);
                        } else if((millisUntilFinished/100)%3==2){
                            turnaroundImg.setVisibility(View.INVISIBLE);
                            fastGrowerImg.setVisibility(View.INVISIBLE);
                            assetPlayImg.setVisibility(View.VISIBLE);
                        }
                    }

                    public void onFinish() {

                        nextQuestion();
                        slowGrowers.setEnabled(true);
                        stalWarts.setEnabled(true);
                        fastGrowers.setEnabled(true);
                        cyclical.setEnabled(true);
                        turnaround.setEnabled(true);
                        assetPlay.setEnabled(true);
                    }
                }.start();

            }
        });

        slowGrowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSolution("Slow Growers");
            }
        });

        stalWarts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSolution("Stalwarts");
            }
        });

        fastGrowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSolution("Fast Growers");
            }
        });

        cyclical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSolution("Cyclical");
            }
        });

        turnaround.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSolution("Turnaround");
            }
        });

        assetPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSolution("Asset Play");
            }
        });

        return myFragmentView;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public void nextQuestion(){

        turnaroundImg.setVisibility(View.INVISIBLE);
        fastGrowerImg.setVisibility(View.INVISIBLE);
        assetPlayImg.setVisibility(View.INVISIBLE);

        if(randomQuestion!=-1){
            questionList.remove(randomQuestion);
            answerList.remove(randomQuestion);
            explainList.remove(randomQuestion);
            questionList.trimToSize();
            answerList.trimToSize();
            explainList.trimToSize();
        }

        if(questionList.size()!=0){
            randomQuestion = (int)(Math.random()*questionList.size());
            question.setText(questionList.get(randomQuestion));
            correctAns = answerList.get(randomQuestion);
            if(correctAns=="Turnaround"){
                turnaroundImg.setVisibility(View.VISIBLE);
            } else if(correctAns=="Fast Growers"){
                fastGrowerImg.setVisibility(View.VISIBLE);
            } else if(correctAns=="Asset Play"){
                assetPlayImg.setVisibility(View.VISIBLE);
            }
        }
    }

    public void showSolution(String buttonClickedName){
        if(correctAns.equals(buttonClickedName)){
            checkAns.setText("Correct! My stock is "+correctAns);
            explainAns.setText(explainList.get(randomQuestion));
            slowGrowers.setEnabled(false);
            stalWarts.setEnabled(false);
            fastGrowers.setEnabled(false);
            cyclical.setEnabled(false);
            turnaround.setEnabled(false);
            assetPlay.setEnabled(false);
            if(questionList.size()==1){ //last question, disable next button
                randomCompany.setVisibility(View.INVISIBLE);
                randomCompanyFade.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
            } else {
                randomCompany.setVisibility(View.VISIBLE);
                randomCompanyFade.setVisibility(View.INVISIBLE);
            }
        }else{
            //checkAns.setText("Incorrect. My stock is "+correctAns);
            Toast.makeText(getActivity(), "Try again!", Toast.LENGTH_SHORT).show();
        }
//        explainAns.setText(explainList.get(randomQuestion));
//        slowGrowers.setEnabled(false);
//        stalWarts.setEnabled(false);
//        fastGrowers.setEnabled(false);
//        cyclical.setEnabled(false);
//        turnaround.setEnabled(false);
//        assetPlay.setEnabled(false);
//        if(questionList.size()==1){ //last question, disable next button
//            randomCompany.setVisibility(View.INVISIBLE);
//            randomCompanyFade.setVisibility(View.VISIBLE);
//        } else {
//            randomCompany.setVisibility(View.VISIBLE);
//            randomCompanyFade.setVisibility(View.INVISIBLE);
//        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
