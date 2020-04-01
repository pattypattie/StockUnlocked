package com.example.chayanit.stockunlocked;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Lesson4Quiz1Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Lesson4Quiz1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Lesson4Quiz1Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    TextView question, checkAns, explainAns;
    ArrayList<String> questionList, answerList, explainList;
    Button slowGrowers, stalWarts, fastGrowers, cyclical, turnaround, assetPlay, nextbtn;
    String correctAns;
    int randomQuestion;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Lesson4Quiz1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Lesson4Quiz1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Lesson4Quiz1Fragment newInstance(String param1, String param2) {
        Lesson4Quiz1Fragment fragment = new Lesson4Quiz1Fragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View myFragmentView = inflater.inflate(R.layout.fragment_lesson4_quiz1, container, false);

        question = myFragmentView.findViewById(R.id.questionl4);
        checkAns = myFragmentView.findViewById(R.id.checkAns);
        slowGrowers = myFragmentView.findViewById(R.id.stocktype1);
        stalWarts = myFragmentView.findViewById(R.id.stocktype2);
        fastGrowers = myFragmentView.findViewById(R.id.stocktype3);
        cyclical = myFragmentView.findViewById(R.id.stocktype4);
        turnaround = myFragmentView.findViewById(R.id.stocktype5);
        assetPlay = myFragmentView.findViewById(R.id.stocktype6);
        nextbtn = myFragmentView.findViewById(R.id.button6);
        explainAns = myFragmentView.findViewById(R.id.explainText);

        questionList = new ArrayList<String>(3);
        answerList = new ArrayList<String>(3);
        explainList = new ArrayList<String>(3);

        randomQuestion = -1;
        questionList.addAll(Arrays.asList("...you are looking for a stock with high constant dividend", "...you want to invest in big company's stock to ensure safe investment", "...oil price has the tendency to increase so you want to benefit from this period"));
        answerList.addAll(Arrays.asList("Slow Growers", "Stalwarts", "Cyclical"));
        explainList.addAll(Arrays.asList("Slow growers stock growth are not very high, but it yields a good amount of dividend.","Stalwarts are tolerant to economic crisis, thus investing in this type of stock is less risky.","Cyclical stock profit varies according to the economy related to the business at the moment. Oil stocks are cyclical since its profit varies according to the oil price."));
        nextQuestion();

        slowGrowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSolution("Slow Growers");
            }
        });

        slowGrowers.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    slowGrowers.setBackgroundResource(R.drawable.button_style_2);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    slowGrowers.setBackgroundResource(R.drawable.button_style_1);
                }
                return false;
            }
        });

        stalWarts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSolution("Stalwarts");
            }
        });

        stalWarts.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    stalWarts.setBackgroundResource(R.drawable.button_style_2);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    stalWarts.setBackgroundResource(R.drawable.button_style_1);
                }
                return false;
            }
        });

        fastGrowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSolution("Fast Growers");
            }
        });

        fastGrowers.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    fastGrowers.setBackgroundResource(R.drawable.button_style_2);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    fastGrowers.setBackgroundResource(R.drawable.button_style_1);
                }
                return false;
            }
        });

        cyclical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSolution("Cyclical");
            }
        });

        cyclical.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    cyclical.setBackgroundResource(R.drawable.button_style_2);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    cyclical.setBackgroundResource(R.drawable.button_style_1);
                }
                return false;
            }
        });

        turnaround.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSolution("Turnaround");
            }
        });

        turnaround.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    turnaround.setBackgroundResource(R.drawable.button_style_2);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    turnaround.setBackgroundResource(R.drawable.button_style_1);
                }
                return false;
            }
        });

        assetPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSolution("Asset Play");
            }
        });

        assetPlay.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    assetPlay.setBackgroundResource(R.drawable.button_style_2);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    assetPlay.setBackgroundResource(R.drawable.button_style_1);
                }
                return false;
            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextQuestion();
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

        nextbtn.setEnabled(false);

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
            checkAns.setText("");
            explainAns.setText("");
            slowGrowers.setEnabled(true);
            stalWarts.setEnabled(true);
            fastGrowers.setEnabled(true);
            cyclical.setEnabled(true);
            turnaround.setEnabled(true);
            assetPlay.setEnabled(true);
        }
    }

    public void showSolution(String buttonClickedName){
        if(correctAns.equals(buttonClickedName)){
            checkAns.setText("Correct! You should aim for "+correctAns);
        }else{
            checkAns.setText("Incorrect. You should aim for "+correctAns);
        }
        explainAns.setText(explainList.get(randomQuestion));
        slowGrowers.setEnabled(false);
        stalWarts.setEnabled(false);
        fastGrowers.setEnabled(false);
        cyclical.setEnabled(false);
        turnaround.setEnabled(false);
        assetPlay.setEnabled(false);
        if(questionList.size()==1){ //last question, disable next button
            nextbtn.setVisibility(View.INVISIBLE);
        } else {
            nextbtn.setEnabled(true);
        }
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
