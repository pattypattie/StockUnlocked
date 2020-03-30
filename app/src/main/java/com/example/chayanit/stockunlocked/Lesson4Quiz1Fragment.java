package com.example.chayanit.stockunlocked;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


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

    TextView question, checkAns;
    String[] questionList;
    String[] answerList;
    Button slowGrowers, stalWarts, fastGrowers, cyclical, turnaround, assetPlay;
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

        questionList = new String[] {"...you are looking for a stock with high constant dividend", "...you want to invest in big company's stock to ensure safe investment"};
        answerList = new String[] {"Slow Growers", "Stalwarts"};

        nextQuestion();

        slowGrowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(correctAns.equals("Slow Growers")){
                    checkAns.setText("Correct! You should aim for Slow Growers.");
                }else{
                    checkAns.setText("Incorrect. You should aim for "+correctAns);
                }
                nextQuestion();
            }
        });

        stalWarts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(correctAns.equals("Stalwarts")){
                    checkAns.setText("Correct! You should aim for Stalwarts.");
                }else{
                    checkAns.setText("Incorrect. You should aim for "+correctAns);
                }
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
        randomQuestion = (int)(Math.random()*questionList.length);
        question.setText(questionList[randomQuestion]);
        correctAns = answerList[randomQuestion];
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
